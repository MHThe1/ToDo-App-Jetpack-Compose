package com.kotlintut.todoapp.viewmodels

import androidx.lifecycle.ViewModel
import com.kotlintut.todoapp.data.Task
import com.kotlintut.todoapp.data.repo.TaskRepo
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel: ViewModel() {
    private val repo = TaskRepo()
    val tasks: StateFlow<List<Task>> = repo.tasks

    fun addTask(title: String) {
        if(title.isNotBlank()) {
            val newTask = Task(id = System.currentTimeMillis().toInt(), title = title)
            repo.addTask(newTask)
        }
    }

    fun addTask(task: Task) {
        repo.addTask(task)
    }


    fun remove(task: Task) {
        repo.removeTask(task)
    }


    fun toggleTaskCompletion(task: Task) {
        repo.toggleTaskCompletion(task)
    }
}


