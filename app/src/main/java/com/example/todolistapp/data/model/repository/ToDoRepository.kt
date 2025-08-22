package com.example.todolistapp.data.model.repository

import com.example.todolistapp.data.model.local.entity.Task


interface ToDoRepository {
    suspend fun getAllTasks(): List<Task>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
}

