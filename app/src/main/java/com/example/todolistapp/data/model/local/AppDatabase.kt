package com.example.todolistapp.data.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolistapp.data.model.local.dao.ToDoDao
import com.example.todolistapp.data.model.local.ToDoItem

@Database(entities = [ToDoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}