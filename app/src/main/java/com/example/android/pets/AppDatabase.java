package com.example.android.pets;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.android.pets.Tables.AnimalName;
import com.example.android.pets.Tables.AnimalType;

import java.util.concurrent.Executors;

@Database(entities = {AnimalType.class, AnimalName.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private final static Object LOCK = new Object();

    private final static String DATABASE_NAME = "animal.db";

    private static AppDatabase sInstance;

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {

            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .fallbackToDestructiveMigration().addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        getInstance(context).animalDao().createAnimalsType(AnimalType.populateData());
                                        getInstance(context).animalDao().addAnimalNames(MainActivity.populateData());

                                    }
                                });
                            }
                        })
                        .build();
            }
        }
        return sInstance;
    }

    public abstract AnimalDao animalDao();
}
