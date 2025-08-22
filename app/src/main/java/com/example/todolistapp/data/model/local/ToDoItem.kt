package com.example.todolistapp.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class ToDoItem(
    @PrimaryKey val id: Int,
    val title: String,
    val isDone: Boolean = false
)