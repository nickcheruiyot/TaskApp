package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.model.ToDoItem
import com.example.todolistapp.data.model.repository.ToDoRepository

class ToDoUseCases (private val repository: ToDoRepository) {
    fun getToDos() = repository.getToDos()
    fun addToDo(item: ToDoItem) = repository.addToDo(item)
    fun updateToDo(item: ToDoItem) = repository.updateToDo(item)
    fun deleteToDo(id: Int) = repository.deleteToDo(id)
}