package com.example.snake.game

class Snake(_x: Int, _y: Int) : GameObject(_x, _y) {
    private val HEAD_SIGN = "\uD83D\uDC7E"
    private val BODY_SIGN = "\u26AB"

    var isAlive: Boolean

    private val snakeParts: ArrayList<GameObject> = ArrayList<GameObject>()
    private var direction: Direction

    init {
        isAlive = true
        snakeParts.add(GameObject(_x, _y))
        snakeParts.add(GameObject(_x + 1, _y))
        snakeParts.add(GameObject(_x + 2, _y))
        direction = Direction.LEFT
    }

    fun getLength() : Int {
        return snakeParts.size
    }

    fun draw(game: SnakeGame) {
        for (part in snakeParts) {
//            TODO рисуем отдельные части
        }
    }

    fun setDirection(direction: Direction) {
        val xEqual = (snakeParts.get(0).x == snakeParts.get(1).x)
        val yEqual = (snakeParts.get(0).y == snakeParts.get(1).y)
        when(this.direction) {
            Direction.UP -> if (Direction.DOWN == direction || yEqual) return
            Direction.LEFT -> if (Direction.RIGHT == direction || xEqual) return
            Direction.DOWN -> if (Direction.UP == direction || yEqual) return
            Direction.RIGHT -> if (Direction.LEFT == direction || xEqual) return
        }
        this.direction = direction
    }

    fun createNewHead(): GameObject {
        var headX = snakeParts.get(0).x
        var headY = snakeParts.get(0).y
        when(direction) {
            Direction.UP -> headY--
            Direction.LEFT -> headX--
            Direction.DOWN -> headY++
            Direction.RIGHT -> headX++
        }
        return GameObject(headX, headY)
    }

    fun removeTail() {
        snakeParts.removeAt(snakeParts.size - 1)
    }

    fun move(apple: Apple) {
        val newHead = createNewHead()
        if (checkCollision(newHead)) {
            isAlive = false
        }
        else {
            if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH ||
                newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT) {
                isAlive = false
            }
            else {
                snakeParts.add(0, newHead)
                if (apple.x == newHead.x && apple.y == newHead.y) apple.isAlive = false
                else removeTail()
            }
        }
    }

    fun checkCollision(head: GameObject): Boolean {
        for (part in snakeParts) {
            if (head != part && head.x == part.x && head.y == part.y) return true
        }
        return false
    }
}