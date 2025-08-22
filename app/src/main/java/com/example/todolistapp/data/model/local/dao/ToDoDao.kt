package com.example.todolistapp.data.model.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todolistapp.data.model.local.ToDoItem
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_items ORDER BY id DESC")
    fun getAll(): Flow<List<ToDoItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ToDoItem)

    @Update
    suspend fun update(item: ToDoItem)

    @Query("DELETE FROM todo_items WHERE id = :id")
    suspend fun delete(id: Int)
}