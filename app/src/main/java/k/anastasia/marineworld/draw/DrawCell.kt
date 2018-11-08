package k.anastasia.marineworld.draw

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import k.anastasia.marineworld.ArrayCell
import k.anastasia.marineworld.common.EnumEntity
import k.anastasia.marineworld.common.Option
import k.anastasia.marineworld.common.Params

@SuppressLint("ViewConstructor")
class DrawCell: SurfaceView, SurfaceHolder.Callback {

    private lateinit var drawThread: DrawThread
    private var pt: Paint
    private var rect: RectF

    private var paint: Paint? = null
    private var pngOrca: Bitmap? = null
    private var pngTux: Bitmap? = null
    private val mat: Matrix = Matrix()

    internal var arrayCell: ArrayCell

    private val option: Option = Option(resources.displayMetrics.widthPixels, resources.displayMetrics.heightPixels)
    private val params = Params()

    constructor(context: Context?) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {
        holder.addCallback(this)
        arrayCell = ArrayCell()

        pt = Paint()
        pt.strokeWidth = 3f
        pt.style = Paint.Style.STROKE

        rect = RectF(option.margin, option.margin, option.margin + option.rectParm, option.margin + option.rectParm)
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        pngOrca = BitmapFactory.decodeResource(resources, option.orca)
        pngTux = BitmapFactory.decodeResource(resources, option.tux)

        mat.postScale(option.rectParm / pngOrca!!.width, option.rectParm / pngOrca!!.height)
        mat.postTranslate( option.margin , option.margin)
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)

        pt.color = Color.BLACK
        canvas.save()

        for (i in 0 until params.ht) {
            for (j in 0 until params.wh) {
                when (arrayCell.cell[j][i]) {
                    EnumEntity.ORCA -> canvas.drawBitmap(pngOrca, mat, paint)
                    EnumEntity.TUX -> canvas.drawBitmap(pngTux, mat, paint)
                    else -> {
                    }
                }
                canvas.drawRect(rect, pt)
                canvas.translate(option.rectParm, 0F)
            }
            canvas.restore()
            canvas.translate(0F, option.rectParm)
            canvas.save()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event!!.action == MotionEvent.ACTION_DOWN)
            MovetoMove(arrayCell)
        return true
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
    }


    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        var retry = true
        drawThread.setRunning(false)
        while (retry) {
            try {
                drawThread.join()
                retry = false
            } catch (e: InterruptedException) {
            }
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        drawThread = DrawThread(getHolder(), this)
        drawThread.setRunning(true)
        drawThread.start()
    }



}