package com.example.todolistapp.data.model.repository

import com.example.todolistapp.data.model.local.dao.TaskDao
import com.example.todolistapp.data.model.local.entity.Task

abstract class ToDoRepositoryImpl(private val dao: TaskDao) : ToDoRepository {
    override suspend fun getAllTasks(): List<Task> = dao.getAllTasks()
    override suspend fun insertTask(task: Task) = dao.insertTask(task)
    override suspend fun deleteTask(task: Task) = dao.deleteTask(task)
}

