package com.example.todolistapp.data.model.local

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "todo_database"
        ).build()
    }
}