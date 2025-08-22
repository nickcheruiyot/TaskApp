package com.example.todolistapp.presentation.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.data.model.ToDoItem
import com.example.todolistapp.domain.usecase.ToDoUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ToDoViewModel(
    private val useCases: ToDoUseCases
) : ViewModel() {

    private val _toDoList = mutableStateListOf<ToDoItem>()
    val toDoList: List<ToDoItem> get() = _toDoList

    init {
        loadToDos()
    }

    fun loadToDos() {
        viewModelScope.launch {
            val items = withContext(Dispatchers.IO) {
                useCases.getToDos()
            }
            _toDoList.clear()
            _toDoList.addAll(items)
        }
    }

    fun addItem(title: String) {
        val item = ToDoItem(id = _toDoList.size + 1, title = title)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                useCases.addToDo(item)
            }
            loadToDos()
        }
    }

    fun toggleStatus(id: Int) {
        val item = _toDoList.find { it.id == id } ?: return
        val updated = item.copy(isDone = !item.isDone)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                useCases.updateToDo(updated)
            }
            loadToDos()
        }
    }

    fun deleteItem(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                useCases.deleteToDo(id)
            }
            loadToDos()
        }
    }
}
