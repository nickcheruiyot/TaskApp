package com.example.todolistapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistapp.presentation.ui.viewmodel.ToDoViewModel

@Composable
fun ToDoScreen(
    viewModel: ToDoViewModel,
    modifier: Modifier = Modifier
) {
    // Fixes delegation error
    var inputText by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        viewModel.loadToDos()
    }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            placeholder = { Text("Add task...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (inputText.isNotBlank()) {
                    viewModel.addItem(inputText)
                    inputText = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(viewModel.toDoList) { item ->
                ToDoItemRow(
                    item = item,
                    onToggle = { viewModel.toggleStatus(item.id) },
                    onDelete = { viewModel.deleteItem(item.id) }
                )
            }
        }
    }
}



