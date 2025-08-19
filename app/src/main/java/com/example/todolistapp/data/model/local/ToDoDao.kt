package com.example.todolistapp.data.model.local

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_items")
    fun getAll(): Flow<List<ToDoEntity>>

    @Insert
    suspend fun insert(item: ToDoEntity)

    @Update
    suspend fun update(item: ToDoEntity)

    @Query("DELETE FROM todo_items WHERE id = :id")
    suspend fun deleteById(id: Int)
}