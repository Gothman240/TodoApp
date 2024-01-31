package com.todoapp.addtasks.data.di

import android.content.Context
import androidx.room.Room
import com.todoapp.addtasks.data.TaskDao
import com.todoapp.addtasks.data.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideTaskDao(todoDatabase: TodoDatabase): TaskDao {
        return todoDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext appcontext: Context): TodoDatabase {
        return Room.databaseBuilder(appcontext, TodoDatabase::class.java, name = "TaskDatabase").build()

    }
}