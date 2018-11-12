package com.example.user.myprogect1;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MemDao {
    @Query("SELECT * FROM mems")
    List<Mem> getAll();

    @Query("SELECT * FROM mems WHERE id = :id")
    Mem getById(long id);

    @Insert
    long insertMem(Mem mem);
}
