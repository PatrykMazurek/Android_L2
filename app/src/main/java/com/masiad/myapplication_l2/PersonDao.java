package com.masiad.myapplication_l2;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPerson(Person person);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updatePerson(Person person);

    @Query("SELECT * FROM person_table")
    LiveData<List<Person>> getAllPersons();

}
