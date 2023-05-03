package com.example.snake.game

import android.widget.Button

class SnakeGame() {
    val WIDTH = 15
    val HEIGHT = 15
    val GOAL = 28

    var score: Int
    var turnDelay: Int
    var isGameStopped: Boolean
    var snake: Snake
    var apple: Apple

    fun gameOver() {
        stopTurnTimer()
        isGameStopped = true
//        TODO Сообщение об гамовере
    }

    fun win() {
        stopTurnTimer()
        isGameStopped = true
//        TODO Сообщение о победе
    }

    fun createGame() {
        turnDelay = 300
        setTurnTimer(turnDelay)
        isGameStopped = false
        score = 0
        setScore(score)

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

    fun onTurn(val n: Int) {
        snake.move(apple)
        if (!apple.isAlive) {
            score += 5
            setScore(score)
            turnDelay -= 10
            setTurnTimer(turnDelay)
            createNewApple()
        }
        if (snake.getLength() > GOAL) win()
        if (!snake.isAlive) gameOver()
        drawScene()
    }

    fun onKeyPress(key: Button) {
        when (key) {
            btnUp -> snake.setDirection(Direction.UP)
            btnRight -> snake.setDirection(Direction.RIGHT)
            btnDown -> snake.setDirection(Direction.DOWN)
            btnLeft -> snake.setDirection(Direction.LEFT)
        }
    }

}