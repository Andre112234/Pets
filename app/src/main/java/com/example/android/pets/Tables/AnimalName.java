package com.example.android.pets.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "animal_name",
        foreignKeys = @ForeignKey(entity = AnimalType.class, parentColumns = "type_id", childColumns = "type_fk", onDelete = ForeignKey.CASCADE))

public class AnimalName {

    @PrimaryKey(autoGenerate = true)
    int name_id;
    String animal_name;

    // Animal type foreign key
    int type_fk;

    public AnimalName(String animal_name, int type_fk) {
        this.animal_name = animal_name;
        this.type_fk = type_fk;
    }


    public int getName_id() {
        return name_id;
    }

    public void setName_id(int name_id) {
        this.name_id = name_id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public int getType_fk() {
        return type_fk;
    }

    public void setType_fk(int type_fk) {
        this.type_fk = type_fk;
    }


/**         --------------------------------
 *          Animal Name Table (Example)
 *          --------------------------------
 *          |name_id |  animal_name| type_fk|
 *          ---------------------------------
 *          |    1   |  Oliver      |  1    |
 *          |    2   |  Bella       |  2    |
 *          |    3   |  Lucy        |  2    |
 *          |    4   |  Leo         |  1    |
 *          |    5   |  FIONA       |  3    |
 */
}
