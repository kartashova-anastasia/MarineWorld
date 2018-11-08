package k.anastasia.marineworld.entity

import k.anastasia.marineworld.ArrayCell
import k.anastasia.marineworld.common.EnumEntity

class Tux : Entity {
    override var posX: Int = -1
    override var posY: Int = -1
    override var increase: Int =3

    override fun move(arrayCell: ArrayCell) {
        if (isEmptyTop(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posY++
            arrayCell.cell[posX][posY]=EnumEntity.TUX
            minIncr()
            return
        }

        if (isEmptyBottom(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posY--
            arrayCell.cell[posX][posY]=EnumEntity.TUX
            minIncr()
            return
        }

        if (isEmptyLeft(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX--
            arrayCell.cell[posX][posY]=EnumEntity.TUX
            minIncr()
            return
        }

        if (isEmptyRight(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX++
            arrayCell.cell[posX][posY]=EnumEntity.TUX
            minIncr()
            return
        }

        if (isEmptyLeftTop(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX--
            posY++
            arrayCell.cell[posX][posY]=EnumEntity.TUX
            minIncr()
            return
        }

        if (isEmptyRightTop(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX++
            posY++
            arrayCell.cell[posX][posY]=EnumEntity.TUX
            minIncr()
            return
        }

        if (isEmptyLeftBottom(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX--
            posY--
            arrayCell.cell[posX][posY]=EnumEntity.TUX
            minIncr()
            return
        }

        if (isEmptyRightBottom(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX++
            posY--
            arrayCell.cell[posX][posY]=EnumEntity.TUX
            minIncr()
            return
        }
        minIncr()
    }

    override fun increase(arrayCell: ArrayCell) {
        val newTux =  Tux()
        if (increase==0) {
            increase=3
            if (isEmptyTop(arrayCell,EnumEntity.EMPTY)){
                arrayCell.cell[posX][posY+1] = EnumEntity.TUX
                newTux.posX = posX
                newTux.posY = posY+1
                arrayCell.tux.add(newTux)
                return
            }
            if (isEmptyBottom(arrayCell,EnumEntity.EMPTY)){
                arrayCell.cell[posX][posY-1] = EnumEntity.TUX
                newTux.posX = posX
                newTux.posY = posY-1
                arrayCell.tux.add(newTux)
                return
            }
            if (isEmptyLeft(arrayCell,EnumEntity.EMPTY)){
                arrayCell.cell[posX-1][posY] = EnumEntity.TUX
                newTux.posX = posX-1
                newTux.posY = posY
                arrayCell.tux.add(newTux)
                return
            }
            if (isEmptyRight(arrayCell,EnumEntity.EMPTY)){
                arrayCell.cell[posX+1][posY] = EnumEntity.TUX
                newTux.posX = posX+1
                newTux.posY = posY
                arrayCell.tux.add(newTux)
                return
            }
            if (isEmptyLeftTop(arrayCell,EnumEntity.EMPTY)){
                arrayCell.cell[posX-1][posY+1] = EnumEntity.TUX
                newTux.posX = posX-1
                newTux.posY = posY+1
                arrayCell.tux.add(newTux)
                return
            }
            if (isEmptyRightTop(arrayCell,EnumEntity.EMPTY)){
                arrayCell.cell[posX+1][posY+1] = EnumEntity.TUX
                newTux.posX = posX+1
                newTux.posY = posY+1
                arrayCell.tux.add(newTux)
                return
            }
            if (isEmptyLeftBottom(arrayCell,EnumEntity.EMPTY)){
                arrayCell.cell[posX-1][posY-1] = EnumEntity.TUX
                newTux.posX = posX-1
                newTux.posY = posY-1
                arrayCell.tux.add(newTux)
                return
            }
            if (isEmptyRightBottom(arrayCell,EnumEntity.EMPTY)){
                arrayCell.cell[posX+1][posY-1] = EnumEntity.TUX
                newTux.posX = posX+1
                newTux.posY = posY-1
                arrayCell.tux.add(newTux)
                return
            }

        }


    }

}