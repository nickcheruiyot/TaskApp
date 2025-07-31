package com.example.todolistapp.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.example.todolistapp.data.model.ToDoItem

@Composable
fun ToDoItemRow(
    item: ToDoItem,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = item.isDone, onCheckedChange = { onToggle() })
        Text(
            text = item.title,
            modifier = Modifier.weight(1f),
            style = if (item.isDone) TextStyle(textDecoration = TextDecoration.LineThrough)
            else TextStyle.Default
        )
        IconButton(onClick = onDelete) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}
