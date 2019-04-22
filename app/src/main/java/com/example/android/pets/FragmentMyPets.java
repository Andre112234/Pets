package com.example.android.pets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentMyPets extends Fragment {

    public FragmentMyPets() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_pets, container, false);

        ListView listView = view.findViewById(R.id.listview);
        ArrayList<String> dummyData = new ArrayList<>();
        dummyData.add("dummy data 1");
        dummyData.add("dummy data 2");
        dummyData.add("dummy data 3");
        dummyData.add("dummy data 4");
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, dummyData);
        listView.setAdapter(adapter);


        return view;

    }



}
