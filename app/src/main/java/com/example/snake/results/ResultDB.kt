package com.example.snake.results

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [Record::class]
)

abstract class ResultDB : RoomDatabase() {
    abstract fun getResultDao(): ResultDao

}