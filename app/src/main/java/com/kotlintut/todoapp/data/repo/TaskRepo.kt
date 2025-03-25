package com.kotlintut.todoapp.data.repo

import androidx.lifecycle.LiveData
import com.kotlintut.todoapp.data.Task
import com.kotlintut.todoapp.data.dao.TaskDao

class TaskRepo(private val taskDao: TaskDao) {

    val getAllTodo: LiveData<List<Task>> = taskDao.getAllTodo()

    suspend fun addTask(task: Task) {
       taskDao.addTodo(task)
    }

    suspend fun removeTask(task: Task) {
        taskDao.deleteTodo(task.id)
    }

    suspend fun toggleTaskCompletion(task: Task) {
        taskDao.toggleTodoCompletion(task.id)
    }
}