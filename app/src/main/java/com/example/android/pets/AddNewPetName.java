package com.example.android.pets;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.pets.Tables.AnimalName;
import com.example.android.pets.Tables.AnimalType;

import java.util.ArrayList;
import java.util.List;

public class AddNewPetName extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    EditText et_addPet_name_var;
    Button btt_addPet_name_var;
    Spinner spinner;
    MainViewModel viewModel;
    ArrayList<String> animal_type;
    int type_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_pet_name);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        et_addPet_name_var = findViewById(R.id.et_addPet_name_xml);
        btt_addPet_name_var = findViewById(R.id.btn_addPet_name_xml);
        //Spinner
        spinner = findViewById(R.id.spinner);
        // List that store animal types that we query in getAnimalsType() method
        animal_type = new ArrayList<>();

        getAnimalsType();
        getSelectItem_id();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, animal_type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        btt_addPet_name_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animal_type.size() == 0) {
                    Toast.makeText(AddNewPetName.this, "Add animal Type First", Toast.LENGTH_SHORT).show();
                } else {
                    insertPetName();
                    finish();

                }
            }
        });
    }

    private void insertPetName() {

            String petName = et_addPet_name_var.getText().toString().trim();
            AnimalName name = new AnimalName(petName, type_id);
            viewModel.addAnimalName(name);

    }

    private void getAnimalsType() {
        viewModel.get_all_animalTypes().observe(this, new Observer<List<AnimalType>>() {
            @Override
            public void onChanged(@Nullable List<AnimalType> animalTypes) {
                for (int i = 0; i < animalTypes.size(); i++) {

                    animal_type.add(animalTypes.get(i).getType_name());
                    adapter.notifyDataSetChanged();

                }

            }
        });
    }

    // Getting animal type foreign id (type_id) to be stored with animal name
    private void getSelectItem_id() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, final View view, final int i, long l) {

                viewModel.get_all_animalTypes().observe(AddNewPetName.this, new Observer<List<AnimalType>>() {
                    @Override
                    public void onChanged(@Nullable List<AnimalType> animalTypes) {
                        type_id = animalTypes.get(i).getType_id();

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
