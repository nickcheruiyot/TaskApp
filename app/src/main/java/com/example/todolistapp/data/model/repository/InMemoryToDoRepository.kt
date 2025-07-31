package com.example.todolistapp.data.model.repository

import com.example.todolistapp.data.model.ToDoItem

object InMemoryToDoRepository : ToDoRepository {
    private val todos = mutableListOf<ToDoItem>()

    override fun getToDos(): List<ToDoItem> = todos

    override fun addToDo(item: ToDoItem) {
        todos.add(item)
    }

    override fun updateToDo(item: ToDoItem) {
        val index = todos.indexOfFirst { it.id == item.id }
        if (index != -1) todos[index] = item
    }

    override fun deleteToDo(id: Int) {
        todos.removeAll { it.id == id }
    }
}
