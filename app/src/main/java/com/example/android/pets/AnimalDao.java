package com.example.android.pets;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.android.pets.POJO.AnimalModel;
import com.example.android.pets.Tables.AnimalName;
import com.example.android.pets.Tables.AnimalType;

import java.util.List;

@Dao
public interface AnimalDao {

    @Query("SELECT * FROM animal_type ")
    LiveData<List<AnimalType>> getAllAnimalTypes();

    @Insert
    void createAnimalType(AnimalType type);

    @Insert
    void createAnimalsType(AnimalType... type);

    @Delete
    void deleteAnimalType(AnimalType type);


    @Query("SELECT type_id FROM animal_type where type_name=:type_name ")
    int get_typeId(String type_name);


    @Query("SELECT * FROM animal_name ")
    LiveData<List<AnimalName>> getAllAnimalNames();

    @Insert
    void AddAnimalName(AnimalName type);

    @Insert
    void addAnimalNames(AnimalName... names);
    @Delete
    void deleteAnimalName(AnimalName name);


   @Query("select type_name,animal_name from animal_type inner join animal_name")
   LiveData<List<AnimalModel>> get_TypeAndName();
}
