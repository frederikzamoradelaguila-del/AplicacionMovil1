package com.example.aplicacion.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aplicacion.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    fun addTask(name: String) {
        if (name.isNotBlank()) {
            _tasks.update { currentTasks ->
                currentTasks + Task(name = name)
            }
        }
    }

    fun toggleTaskStatus(taskId: String, isCompleted: Boolean) {
        _tasks.update { currentTasks ->
            currentTasks.map { task ->
                if (task.id == taskId) task.copy(isCompleted = isCompleted) else task
            }
        }
    }

    fun deleteTask(taskId: String) {
        _tasks.update { currentTasks ->
            currentTasks.filter { it.id != taskId }
        }
    }
}