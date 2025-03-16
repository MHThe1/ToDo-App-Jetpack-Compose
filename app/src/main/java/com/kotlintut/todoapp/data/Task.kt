package com.kotlintut.todoapp.data

data class Task(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)
