package com.example.android.pets;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.pets.Tables.AnimalName;

public class MainActivity extends AppCompatActivity {

    static AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDb = AppDatabase.getInstance(getApplicationContext());


        BottomNavigationView bnv_main_var = findViewById(R.id.btv_main_xml);
        bnv_main_var.setOnNavigationItemSelectedListener(itemSelectedListener);
        // Set this as default fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_Container_mainXml, new FragmentAllAnimal())
                .commit();

    }

    public static AnimalName[] populateData() {
        return new AnimalName[]{
                // Populate Cats
                new AnimalName("Oliver", mDb.animalDao().get_typeId("Cat")),
                new AnimalName("Leo", mDb.animalDao().get_typeId("Cat")),
                new AnimalName("Charlie", mDb.animalDao().get_typeId("Cat")),
                // Populate Dogs
                new AnimalName("Bella", mDb.animalDao().get_typeId("Dog")),
                new AnimalName("Lucy", mDb.animalDao().get_typeId("Dog")),
                new AnimalName("Daisy", mDb.animalDao().get_typeId("Dog")),
                // Horses
                new AnimalName("OPIE", mDb.animalDao().get_typeId("Horse")),
                new AnimalName("FIONA", mDb.animalDao().get_typeId("Horse")),
                new AnimalName("RUSSELL", mDb.animalDao().get_typeId("Horse")),
                // Birds
                new AnimalName("Eric", mDb.animalDao().get_typeId("Bird")),
                new AnimalName("Hal", mDb.animalDao().get_typeId("Bird")),
                new AnimalName("Iago", mDb.animalDao().get_typeId("Bird"))

        };
    }


    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {

                case R.id.menu_AllAnimalsBNV_xml:
                    fragment = new FragmentAllAnimal();

                    break;
                case R.id.menu_MyPetsBNV_xml:
                    fragment = new FragmentMyPets();
                    break;
                case R.id.menu_SettingBNV_xml:
                    fragment = new FragmentSetting();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container_mainXml, fragment).commit();
            return true;
        }
    };

    public void testUpload() {
        int i = 1+1;
    }
}
