package com.example.todolistapp.presentation.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.model.ToDoItem
import com.example.todolistapp.domain.usecase.ToDoUseCases

class ToDoViewModel (
    private val useCases: ToDoUseCases
) : ViewModel() {

    private val _toDoList = mutableStateListOf<ToDoItem>()
    val toDoList: List<ToDoItem> get() = _toDoList

    fun loadToDos() {
        _toDoList.clear()
        _toDoList.addAll(useCases.getToDos())
    }

    fun addItem(title: String) {
        val item = ToDoItem(id = _toDoList.size + 1, title = title)
        useCases.addToDo(item)
        loadToDos()
    }

    fun toggleStatus(id: Int) {
        val item = _toDoList.find { it.id == id } ?: return
        val updated = item.copy(isDone = !item.isDone)
        useCases.updateToDo(updated)
        loadToDos()
    }

    fun deleteItem(id: Int) {
        useCases.deleteToDo(id)
        loadToDos()
    }
}