package com.kotlintut.todoapp.data.repo

import com.kotlintut.todoapp.data.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskRepo {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    fun addTask(task: Task) {
        _tasks.value += task
    }

    fun removeTask(task: Task) {
        _tasks.value -= task
    }

    fun toggleTaskCompletion(task: Task) {
        _tasks.value = _tasks.value.map {
            if (it.id == task.id) it.copy(isCompleted = !it.isCompleted) else it
        }
    }
}