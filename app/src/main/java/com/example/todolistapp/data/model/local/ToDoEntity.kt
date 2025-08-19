package com.example.todolistapp.data.model.local

@Entity(tableName = "todo_items")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val isDone: Boolean = false
)
