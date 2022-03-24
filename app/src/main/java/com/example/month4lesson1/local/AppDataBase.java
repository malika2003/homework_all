package com.example.month4lesson1.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.month4lesson1.model.Task;

@Database(entities = {Task.class} , version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
