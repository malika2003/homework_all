package com.example.month4lesson1.local;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.month4lesson1.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM tableTask")
    List<Task> getAllTask();
    @Insert
    void  insertTask(Task task);

    @Query("DELETE FROM tableTask")
    void deleteAll();

    @Delete
    void deletePlace(Task task);
}
