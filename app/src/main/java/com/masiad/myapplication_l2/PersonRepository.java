package com.masiad.myapplication_l2;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonRepository {
    AppRoomDatabase appRoomDatabase;
    PersonDao personDao;

    private LiveData<List<Person>> listPerson;

    public PersonRepository(Application application) {
        appRoomDatabase = AppRoomDatabase.getAppRoomDatabase(application);
        personDao = appRoomDatabase.personDao();
        listPerson = personDao.getAllPersons();
    }

    public LiveData<List<Person>> getListPerson(){
        return listPerson;
    }

    public void insertPerson(Person person){
        AppRoomDatabase.databaseWriterExecutor.execute(
                () -> personDao.insertPerson(person));
    }
}
