package k.anastasia.marineworld.common

import k.anastasia.marineworld.R

class Option(width: Int, height: Int) {
    val orca = R.mipmap.orca
    val tux = R.mipmap.tux
    var rectParm: Float
    val margin: Float = 50F
    init {
        rectParm = if ((height * 0.75) < width)
            ((width - (margin * 2)) / 10)
        else
            ((((height * 0.75) - (margin * 2)) / 15).toFloat())
    }
}