package com.example.todolistapp.data.model.repository

import com.example.todolistapp.data.model.ToDoItem

interface ToDoRepository {fun getToDos(): List<ToDoItem>
    fun addToDo(item: ToDoItem)
    fun updateToDo(item: ToDoItem)
    fun deleteToDo(id: Int)
}