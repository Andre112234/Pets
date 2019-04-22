package com.example.android.pets.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "animal_type")
public class AnimalType {
    @PrimaryKey(autoGenerate = true)
    int type_id;
    // Type of the animal (cat or dog or bird )
    String type_name;


    public AnimalType(String type_name) {
        this.type_name = type_name;
    }


    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }


    public static AnimalType[] populateData() {
        return new AnimalType[]{
                new AnimalType("Cat"),
                new AnimalType("Dog"),
                new AnimalType("Horse"),
                new AnimalType("Bird")
        };
    }

}


/**         ------------------------
 *          Animal Type Table (Example)
 *          ------------------------
 *          |type_id |  type_name  |
 *          ------------------------
 *          |    1   |  Dog        |
 *          |    2   |  Cat        |
 *          |    3   |  Bird       |
 *          |    4   |  Fish       |
 *          |    5   |  Horse      |
 */
