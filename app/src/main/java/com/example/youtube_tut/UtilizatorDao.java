package com.example.youtube_tut;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UtilizatorDao {
    @Insert
    void insert(Utilizator utilizator);


    @Delete
    void delete(Utilizator utilizator);

    @Query("Select* from utilizator")
    List<Utilizator> select();

    @Query("Select * from utilizator where nume=:nume")
    List<Utilizator> getAll(String nume);
}
