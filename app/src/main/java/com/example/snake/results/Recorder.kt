package com.example.snake.results

interface Recorder {
    fun update(name: String, score: Int)
    fun read()
    fun create()
}