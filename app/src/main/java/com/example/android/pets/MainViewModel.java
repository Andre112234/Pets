package com.example.android.pets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.pets.POJO.AnimalModel;
import com.example.android.pets.Tables.AnimalName;
import com.example.android.pets.Tables.AnimalType;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private AnimalRepository animalRepository;

    AppDatabase db;

   private  LiveData<List<AnimalType>> all_animalTypes;
   private  LiveData<List<AnimalName>> all_animalNames;
    private  LiveData<List<AnimalModel>> animalModel;


    public MainViewModel(@NonNull Application application) {
        super(application);

        AppDatabase appDatabase = AppDatabase.getInstance(getApplication());

        db = AppDatabase.getInstance(getApplication());
        animalRepository = new AnimalRepository(application);

        all_animalTypes = animalRepository.get_all_animalTypes();
        all_animalNames = animalRepository.get_all_animalNames();
        animalModel = animalRepository.get_TypeAndName();

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
        animalRepository.createAnimalType(type);
    }
    public void deleteAnimalType(AnimalType type) {
        animalRepository.deleteAnimalType(type);
    }

    public void createAnimalsType(AnimalType type) {
        animalRepository.createAnimalsType(type);
    }
    public void deleteAnimalsType(AnimalType type) {
        animalRepository.deleteAnimalType(type);
    }


    public void addAnimalName(AnimalName name) {
        animalRepository.addAnimalName(name);
    }
    public void deleteAnimalName(AnimalName name) {
        animalRepository.deleteAnimalName(name);
    }



}
