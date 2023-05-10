package com.example.snake.drawer

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import com.example.snake.game.GameObject


class Drawer(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas) {
        val c = Canvas()

    }
    fun print(c: GameObject) {

    }
}

class GameView(context: Context?) : SurfaceView(context),
    SurfaceHolder.Callback {
    init {
        holder.addCallback(this)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
    override fun surfaceCreated(holder: SurfaceHolder) {}
    override fun surfaceDestroyed(holder: SurfaceHolder) {}
    fun surfaceCreated(holder: SurfaceHolder?) {
        /* Тут можно провести инициализацию механизмов отрисовки, Canvas получать так же, как в потоке отрисовки */
//        mDrawThread = DrawThread(holder!!)
//        mDrawThread.setRunning(true)
//        mDrawThread.start()
    }
}

class DrawThread(private val mSurfaceHolder: SurfaceHolder) : Thread() {
    private var mRunning = false
    fun setRunning(running: Boolean) {
        mRunning = running
    }

    override fun run() {
        var canvas: Canvas?
        while (mRunning) {
            canvas = null
            try {
                canvas = mSurfaceHolder.lockCanvas(null)
                if (canvas == null) {
                    continue
                }
                /* Рисуем на canvas */
            } finally {
                if (canvas != null) {
                    mSurfaceHolder.unlockCanvasAndPost(canvas)
                }
            }
            try {
                //let other threads do they work
                sleep(15)
            } catch (e: InterruptedException) {
            }
        }
    }
}