package com.kotlintut.todoapp.viewmodels

import androidx.lifecycle.ViewModel
import com.kotlintut.todoapp.data.Task
import com.kotlintut.todoapp.data.repo.TaskRepo
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel: ViewModel() {
    private val repo = TaskRepo()
    val tasks: StateFlow<List<Task>> = repo.tasks

    init {
        if(tasks.value.isEmpty()) {
            repo.addTask(
                Task(
                    title = "Get some A4 papers",
                    id = 1,
                    isCompleted = false
                )
            )
            repo.addTask(
                Task(
                    title = "Have some food",
                    id = 2,
                    isCompleted = true
                )
            )
            repo.addTask(
                Task(
                    title = "Complete CS assignment",
                    id = 3,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Call Ammu",
                    id = 4,
                    isCompleted = true
                )
            )

            repo.addTask(
                Task(
                    title = "Read 10 pages of a book",
                    id = 5,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Workout for 30 minutes",
                    id = 6,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Reply to important emails",
                    id = 7,
                    isCompleted = true
                )
            )

            repo.addTask(
                Task(
                    title = "Plan next week's schedule",
                    id = 8,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Fix bugs in the project",
                    id = 9,
                    isCompleted = true
                )
            )

            repo.addTask(
                Task(
                    title = "Review pull requests",
                    id = 10,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Watch a tutorial on DIY tiny home building",
                    id = 11,
                    isCompleted = true
                )
            )

            repo.addTask(
                Task(
                    title = "Go for a short walk",
                    id = 12,
                    isCompleted = false
                )
            )
            repo.addTask(
                Task(
                    title = "Write a blog post",
                    id = 13,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Backup important files",
                    id = 14,
                    isCompleted = true
                )
            )

            repo.addTask(
                Task(
                    title = "Refactor old code",
                    id = 15,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Prepare presentation slides",
                    id = 16,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Submit project report",
                    id = 17,
                    isCompleted = true
                )
            )

            repo.addTask(
                Task(
                    title = "Clean up workspace",
                    id = 18,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Order food online",
                    id = 19,
                    isCompleted = true
                )
            )

            repo.addTask(
                Task(
                    title = "Write unit tests",
                    id = 20,
                    isCompleted = false
                )
            )

            repo.addTask(
                Task(
                    title = "Check up on a friend",
                    id = 21,
                    isCompleted = true
                )
            )

            repo.addTask(
                Task(
                    title = "Watch a documentary",
                    id = 22,
                    isCompleted = false
                )
            )


        }
    }


    fun addTask(title: String) {
        if(title.isNotBlank()) {
            val newTask = Task(id = System.currentTimeMillis().toInt(), title = title)
        }
    }


    fun remove(task: Task) {
        repo.removeTask(task)
    }


    fun toggleTaskCompletion(task: Task) {
        repo.toggleTaskCompletion(task)
    }
}


