package com.masiad.myapplication_l2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person_table")
public class Person {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String name;
    public String lastName;
    public String city;

    public Person(){
        id = 0;
        name = "";
        lastName = "";
        city = "";
    }

    public Person(int i, String n, String l, String c){
        id = i;
        name = n;
        lastName = l;
        city = c;
    }
}
