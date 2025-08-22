package com.example.todolistapp.data.model.repository

import com.example.todolistapp.data.model.ToDoItem
import com.example.todolistapp.data.model.local.entity.Task

object InMemoryToDoRepository : ToDoRepository {
    private val tasks = mutableListOf<Task>()

    override suspend fun getAllTasks(): List<Task> = tasks

    override suspend fun insertTask(task: Task) {
        tasks.add(task)
    }

    override suspend fun deleteTask(task: Task) {
        tasks.removeIf { it.id == task.id }
    }}
