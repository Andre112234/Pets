package com.example.android.pets;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.android.pets.POJO.AnimalModel;
import com.example.android.pets.Tables.AnimalName;
import com.example.android.pets.Tables.AnimalType;

import java.util.List;

public class AnimalRepository {

    AnimalDao animalDao;

    LiveData<List<AnimalType>> all_animalTypes;
    LiveData<List<AnimalName>> all_animalNames;

    LiveData<List<AnimalModel>> animalModel;


    public AnimalRepository(Application application) {

        AppDatabase db = AppDatabase.getInstance(application);
        animalDao = db.animalDao();
        all_animalTypes = animalDao.getAllAnimalTypes();
        all_animalNames=animalDao.getAllAnimalNames();
        animalModel=animalDao.get_TypeAndName();


    }

    public LiveData<List<AnimalType>> get_all_animalTypes() {
        return all_animalTypes;
    }

    public LiveData<List<AnimalName>> get_all_animalNames() {
        return all_animalNames;
    }
    public LiveData<List<AnimalModel>> get_TypeAndName() {
        return animalModel;
    }


    public void createAnimalType(AnimalType type) {
        new CreateAnimalTypeAsync(animalDao).execute(type);
    }
    private static class CreateAnimalTypeAsync extends AsyncTask<AnimalType, Void, Void> {
        AnimalDao animalDao;

        CreateAnimalTypeAsync(AnimalDao gymDao) {
            this.animalDao = gymDao;
        }

        @Override
        protected Void doInBackground(AnimalType... animalTypes) {
            animalDao.createAnimalType(animalTypes[0]);
            return null;
        }
    }











    public void createAnimalsType(AnimalType type) {
        new CreateAnimalsTypeAsync(animalDao).execute(type);
    }
    private static class CreateAnimalsTypeAsync extends AsyncTask<AnimalType, Void, Void> {
        AnimalDao animalDao;

        CreateAnimalsTypeAsync(AnimalDao gymDao) {
            this.animalDao = gymDao;
        }

        @Override
        protected Void doInBackground(AnimalType... animalTypes) {
            animalDao.createAnimalsType(animalTypes[0]);
            return null;
        }
    }




    public void deleteAnimalType(AnimalType type) {
        new DeleteAnimalTypeAsync(animalDao).execute(type);
    }
    private static class DeleteAnimalTypeAsync extends AsyncTask<AnimalType, Void, Void> {
        AnimalDao animalDao;

        DeleteAnimalTypeAsync(AnimalDao gymDao) {
            this.animalDao = gymDao;
        }

        @Override
        protected Void doInBackground(AnimalType... animalTypes) {
            animalDao.deleteAnimalType(animalTypes[0]);
            return null;
        }
    }



    public void addAnimalName(AnimalName name) {
        new AddAnimalNameAsync(animalDao).execute(name);
    }
    private static class AddAnimalNameAsync extends AsyncTask<AnimalName, Void, Void> {
        AnimalDao animalDao;

        AddAnimalNameAsync(AnimalDao gymDao) {
            this.animalDao = gymDao;
        }

        @Override
        protected Void doInBackground(AnimalName... name) {
            animalDao.AddAnimalName(name[0]);
            return null;
        }
    }

    public void deleteAnimalName(AnimalName name) {
        new DeleteAnimalNameAsync(animalDao).execute(name);
    }
    private static class DeleteAnimalNameAsync extends AsyncTask<AnimalName, Void, Void> {
        AnimalDao animalDao;

        DeleteAnimalNameAsync(AnimalDao gymDao) {
            this.animalDao = gymDao;
        }

        @Override
        protected Void doInBackground(AnimalName... name) {
            animalDao.deleteAnimalName(name[0]);
            return null;
        }
    }


}
