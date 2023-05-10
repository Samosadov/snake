package com.example.snake.game

import android.content.Context
import com.example.snake.drawer.Drawer
import kotlin.random.Random

class SnakeGame() {
    companion object {
        val HEIGHT: Int = 15
        val WIDTH: Int = 15
    }
    val GOAL = 28

    var score: Int = 0
    var turnDelay: Int = 300
    var isGameStopped: Boolean = true

    private lateinit var snake: Snake
    private lateinit var apple:Apple

    fun gameOver() {
//        stopTurnTimer()
        isGameStopped = true
//        TODO Сообщение об гамовере

    }

    fun win() {
//        stopTurnTimer()
        isGameStopped = true
//        TODO Сообщение о победе

    }

    fun createGame() {
        turnDelay = 300
//        setTurnTimer(turnDelay)
        isGameStopped = false
        score = 0
//        setScore(score)

        snake = Snake(WIDTH / 2, HEIGHT / 2)
        createNewApple()
        drawScene()
    }

   fun drawScene() {
       for (x in 0..WIDTH) {
           for (y in 0..HEIGHT) {
//               TODO Рисуем игровое поле
           }
       }
       snake.draw(this)
       apple.draw(this)
   }

    fun createNewApple() {
        do {
            apple = Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT))
        } while (snake.checkCollision(apple))
    }

    fun onTurn() { // TODO
        snake.move(apple)
        if (!apple.isAlive) {
            score += 5
//            setScore(score)
            turnDelay -= 10
//            setTurnTimer(turnDelay)
            createNewApple()
        }
        if (snake.getLength() > GOAL) win()
        if (!snake.isAlive) gameOver()
        drawScene()
    }

    fun keyPress(key: Keys) {
        when (key) {
            Keys.btnUp -> snake.setDirection(Direction.UP)
            Keys.btnRight -> snake.setDirection(Direction.RIGHT)
            Keys.btnDown -> snake.setDirection(Direction.DOWN)
            Keys.btnLeft -> snake.setDirection(Direction.LEFT)
        }
    }
    fun getRandomNumber(max: Int): Int {
        return Random.nextInt(max)
    }


}