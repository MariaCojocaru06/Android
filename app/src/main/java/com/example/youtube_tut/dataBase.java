package com.example.youtube_tut;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Utilizator.class},version =1, exportSchema = false)
public abstract class dataBase extends RoomDatabase {
    public  abstract UtilizatorDao utilizatorDao();
}