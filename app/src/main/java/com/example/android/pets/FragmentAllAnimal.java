package com.example.android.pets;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.pets.POJO.AnimalModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentAllAnimal extends Fragment {

    RecyclerView rc_allAnimals_var;
    AllAnimalAdapter adapter;
    MainViewModel viewModel;


    // Empty Constructor
    public FragmentAllAnimal() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_animal, container, false);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        buildRecyclerView(view);
        setHasOptionsMenu(true);
        setUpViewModel_loadAnimalModel();


        return view;

    }

    // Building RecyclerView
    private void buildRecyclerView(View view) {
        rc_allAnimals_var = view.findViewById(R.id.rc_allAnimals_xml);
        rc_allAnimals_var.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AllAnimalAdapter(getActivity());
        rc_allAnimals_var.setAdapter(adapter);


    }

    // Query for animal Model
    public void setUpViewModel_loadAnimalModel() {
        viewModel.get_TypeAndName().observe(this, new Observer<List<AnimalModel>>() {
            @Override
            public void onChanged(@Nullable List<AnimalModel> animalModels) {
                adapter.setAnimalModel_list((ArrayList<AnimalModel>) animalModels);
            }
        });


    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add_animal_type, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_animal_type_xml:
                Intent i = new Intent(getContext(), AddNewAnimalType.class);
                startActivity(i);
                break;
            case R.id.menu_add_pet_name_xml:
                Intent ii = new Intent(getContext(), AddNewPetName.class);
                startActivity(ii);
                break;
        }
        return true;
    }

}


