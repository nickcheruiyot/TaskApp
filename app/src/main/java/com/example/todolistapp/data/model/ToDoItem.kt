package com.example.todolistapp.data.model

data class ToDoItem(
    val id: Int,
    val title: String,
    val isDone: Boolean = false
)
