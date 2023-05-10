package com.example.snake.results

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//import androidx.room.Entity
//import androidx.room.PrimaryKey

@Entity(tableName = "result")
data class Record(
    @PrimaryKey//(autoGenerate = true)
    val id: Long,
    @ColumnInfo
    val name: String?,
    val score: Int
    )
