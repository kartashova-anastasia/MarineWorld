package k.anastasia.marineworld

import k.anastasia.marineworld.common.EnumEntity
import k.anastasia.marineworld.common.Params
import k.anastasia.marineworld.entity.Orca
import k.anastasia.marineworld.entity.Tux
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList

class ArrayCell {
    private val params = Params()
    internal val wh = params.wh
    internal val ht = params.ht

    private inline fun <reified INNER> arrayCell(sizeOuter: Int, sizeInner: Int, noinline innerInit: (Int) -> INNER):
            Array<Array<INNER>> = Array(sizeOuter) { Array(sizeInner, innerInit) }

    private fun ClosedRange<Int>.random() = Random().nextInt((endInclusive + 1) - start) + start

    internal val cell: Array<Array<EnumEntity?>>

    internal val tux: CopyOnWriteArrayList<Tux> = CopyOnWriteArrayList()
    internal val orca: CopyOnWriteArrayList<Orca> = CopyOnWriteArrayList()

    init {
        cell = arrayCell(wh, ht) { EnumEntity.EMPTY }
        initTux()
        initOrca()

    }
    private fun initTux(){
        while (params.TuxQW != 0)
        {
            val i = (0 until wh).random()
            val j = (0 until ht).random()
            if (cell[i][j] == EnumEntity.EMPTY) {
                cell[i][j] = EnumEntity.TUX
                addTux(Tux(), i, j)
                params.TuxQW--
            }
        }
    }

    private fun initOrca(){
        while (params.OrcaQW != 0)
        {
            val i = (0 until wh).random()
            val j = (0 until ht).random()
            if (cell[i][j] == EnumEntity.EMPTY) {
                cell[i][j] = EnumEntity.ORCA
                addOrca(Orca(), i, j)
                params.OrcaQW--
            }
        }
    }

    private fun addTux(entity: Tux, i: Int, j: Int){
        entity.posX = i
        entity.posY = j
        tux.add(entity)
    }

    private fun addOrca(entity: Orca, i: Int, j: Int){
        entity.posX = i
        entity.posY = j
        orca.add(entity)
    }
}