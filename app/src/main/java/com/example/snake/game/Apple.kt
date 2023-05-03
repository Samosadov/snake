package com.example.snake.game

import androidx.compose.ui.graphics.BlendMode.Companion.Color

class Apple(_x: Int, _y: Int) : GameObject(_x, _y) {
    private val APPLE_SIGN: String = "\uD83C\uDF4E"
    var isAlive: Boolean = true

    fun draw(game: SnakeGame) {
        if (isAlive) {
//            TODO рисуем яблоко
        }
        else {
//            TODO стираем яблоко
        }
    }

}