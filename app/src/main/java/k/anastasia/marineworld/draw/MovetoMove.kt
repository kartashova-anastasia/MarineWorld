package k.anastasia.marineworld.draw

import k.anastasia.marineworld.ArrayCell

class MovetoMove(arrayCell: ArrayCell) {

    init {
        toMove(arrayCell)
    }

    private fun toMove(arrayCell: ArrayCell){
        for (tux in arrayCell.tux){
            tux.move(arrayCell)
            tux.increase(arrayCell)
        }

        for (orca in arrayCell.orca){
            orca.move(arrayCell)
            orca.increase(arrayCell)
            orca.death(arrayCell)
        }
    }
}