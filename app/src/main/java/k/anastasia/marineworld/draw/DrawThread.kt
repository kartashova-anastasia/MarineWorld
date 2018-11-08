package k.anastasia.marineworld.draw

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.view.SurfaceHolder

class DrawThread(private val surfaceHolder: SurfaceHolder,
                 private val surfaceView: DrawCell) : Thread() {
    private var running = false

    fun setRunning(running: Boolean) {
        this.running = running
    }

    @Suppress("SENSELESS_COMPARISON")
    @SuppressLint("WrongCall")
    override fun run() {
        var canvas: Canvas?
        while (running) {
            canvas = null
            try {
                canvas = surfaceHolder.lockCanvas(null)
                synchronized(surfaceHolder) {
                    surfaceView.onDraw(canvas)
                }
                sleep(100)
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas)
                }
            }
        }
    }
}