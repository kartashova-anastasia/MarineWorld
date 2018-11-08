package k.anastasia.marineworld.common

class Params {
    val ht = 15
    val wh = 10
    private val TuxPercent = 50
    private val OrcaPercent = 5
    private val PercentF = 100
    private val PercentQ = (wh * ht) / PercentF.toFloat()

    var TuxQW = (PercentQ * TuxPercent).toInt()
    var OrcaQW = (PercentQ * OrcaPercent).toInt()

}