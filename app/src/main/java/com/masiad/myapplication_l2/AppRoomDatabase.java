package com.masiad.myapplication_l2;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {

    public abstract PersonDao personDao();

    private static volatile AppRoomDatabase appRoomDatabase;
    private static int THREAD_NUMBER = 4;
    static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(THREAD_NUMBER);

    static AppRoomDatabase getAppRoomDatabase(final Context context){
        if (appRoomDatabase == null){
            synchronized (AppRoomDatabase.class){
                appRoomDatabase = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppRoomDatabase.class,
                        "app_database"
                ).build();
            }
        }
        return appRoomDatabase;
    }
}
