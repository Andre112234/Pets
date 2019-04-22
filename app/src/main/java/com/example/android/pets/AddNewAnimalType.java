package com.example.android.pets;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.pets.Tables.AnimalType;

public class AddNewAnimalType extends AppCompatActivity {

    EditText et_addAnimal_type_var;
    Button btn_addAnimal_type_var;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_animal);

        et_addAnimal_type_var = findViewById(R.id.et_addAnimal_type_xml);
        btn_addAnimal_type_var = findViewById(R.id.btn_addAnimal_type_xml);
// Create animal Type button
        btn_addAnimal_type_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAnimalType();
                finish();
            }
        });
    }
    // Create Animal Type
    public void createAnimalType() {
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        String typeString = et_addAnimal_type_var.getText().toString().trim();

        AnimalType type = new AnimalType(typeString);
        viewModel.createAnimalType(type);

    }
}
