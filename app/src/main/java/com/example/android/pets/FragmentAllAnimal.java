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
import android.widget.TextView;

import com.example.android.pets.Adapters.Adapter_v2;
import com.example.android.pets.POJO.AnimalModel;
import com.example.android.pets.Tables.AnimalName;
import com.example.android.pets.Tables.AnimalType;

import java.util.ArrayList;
import java.util.List;

public class FragmentAllAnimal extends Fragment {

    RecyclerView rc_allAnimals_var;
    //    AllAnimalAdapter adapter;
    Adapter_v2 adapter_2;
    MainViewModel viewModel;

//    ArrayList<AnimalType> type_list;
//    ArrayList<AnimalName> names_list;

    TextView tv_TypeListSize_var, tv_NameListSize_var;

    // Empty Constructor
    public FragmentAllAnimal() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_animal, container, false);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        tv_TypeListSize_var = view.findViewById(R.id.Typelist_size);
        tv_NameListSize_var = view.findViewById(R.id.Namelist_size);


        buildRecyclerView(view);
        setHasOptionsMenu(true);
        //  setUpViewModel_loadAnimalModel();
        getQuery();

        return view;

    }


    // Building RecyclerView
    private void buildRecyclerView(View view) {
        rc_allAnimals_var = view.findViewById(R.id.rc_allAnimals_xml);
        rc_allAnimals_var.setLayoutManager(new LinearLayoutManager(getActivity()));
//        adapter = new AllAnimalAdapter(getActivity());
        adapter_2 = new Adapter_v2(getActivity());
        rc_allAnimals_var.setAdapter(adapter_2);


    }

    // Query for animal Model
    public void setUpViewModel_loadAnimalModel() {
        viewModel.get_TypeAndName().observe(this, new Observer<List<AnimalModel>>() {
            @Override
            public void onChanged(@Nullable List<AnimalModel> animalModels) {
//                adapter.setAnimalModel_list((ArrayList<AnimalModel>) animalModels);

            }
        });


    }

    public void getQuery() {
        viewModel.get_all_animalTypes().observe(this, new Observer<List<AnimalType>>() {
            @Override
            public void onChanged(@Nullable List<AnimalType> animalTypes) {
                adapter_2.setType_list((ArrayList<AnimalType>) animalTypes);
                adapter_2.notifyDataSetChanged();
                tv_TypeListSize_var.setText("Type Size= " + String.valueOf(animalTypes.size()));
            }
        });
        viewModel.get_all_animalNames().observe(this, new Observer<List<AnimalName>>() {
            @Override
            public void onChanged(@Nullable List<AnimalName> animalNames) {
                adapter_2.setNames_list((ArrayList<AnimalName>) animalNames);
                adapter_2.notifyDataSetChanged();
                tv_NameListSize_var.setText(",                   Name Size= " + String.valueOf(animalNames.size()));

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


