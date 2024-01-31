package com.todoapp.addtasks.data

import com.todoapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {
    val tasks: Flow<List<TaskModel>> =
        taskDao.getAllTasks().map { task -> task.map { TaskModel(it.id, it.task, it.selected) } }

    suspend fun addTask(task: TaskModel) {
        taskDao.addTask(TaskEntity(task.id, task.task, task.selected))
    }
}