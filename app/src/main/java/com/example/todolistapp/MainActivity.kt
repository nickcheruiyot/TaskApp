package com.example.todolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.example.todolistapp.data.model.repository.InMemoryToDoRepository
import com.example.todolistapp.domain.usecase.ToDoUseCases
import com.example.todolistapp.presentation.ui.ToDoScreen
import com.example.todolistapp.presentation.ui.viewmodel.ToDoViewModel
import com.example.todolistapp.ui.theme.TodolistappTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Manual DI setup
        val useCases = ToDoUseCases(InMemoryToDoRepository)
        val viewModel = ToDoViewModel(useCases)

        setContent {
            TodolistappTheme {
                Scaffold(modifier = androidx.compose.ui.Modifier.fillMaxSize()) { innerPadding ->
                    ToDoScreen(
                        viewModel = viewModel,
                        modifier = androidx.compose.ui.Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}