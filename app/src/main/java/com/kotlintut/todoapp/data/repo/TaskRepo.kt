package com.kotlintut.todoapp.data.repo

import androidx.lifecycle.LiveData
import com.kotlintut.todoapp.data.Task
import com.kotlintut.todoapp.data.dao.TaskDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskRepo(private val taskDao: TaskDao) {

    val getAllTodo: LiveData<List<Task>> = taskDao.getAllTodo()

//    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
//    val tasks: StateFlow<List<Task>> = _tasks

    suspend fun addTask(task: Task) {
        taskDao.addTodo(task)
    }

    fun removeTask(task: Task) {
        taskDao.deleteTodo(task.id)
    }

    fun toggleTaskCompletion(task: Task) {
        taskDao.toggleTodoCompletion(task.id)
    }
}