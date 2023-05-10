package com.example.snake.results

import androidx.room.*

@Dao
interface ResultDao {
    @Insert(entity = Record::class)
    fun insertData(record: Record)

    @Query("SELECT * FROM result")
    fun getData(): List<Record>

    @Query("DELETE FROM result WHERE id = :_id")
    fun deleteData(_id: Long)
}