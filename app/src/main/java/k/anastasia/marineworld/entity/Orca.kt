package k.anastasia.marineworld.entity

import k.anastasia.marineworld.ArrayCell
import k.anastasia.marineworld.common.EnumEntity

class Orca : Entity {
    override var posX: Int =-1
    override var posY: Int =-1
    override var increase: Int = 8
    private  var dead: Int = 3

    private fun minDead(){
        if (dead != 0) dead--
    }

    override fun increase(arrayCell: ArrayCell) {
        val newOrca =  Orca()
        if (increase==0) {
            increase=8
            if (isEmptyTop(arrayCell, EnumEntity.EMPTY)){
                arrayCell.cell[posX][posY+1] = EnumEntity.ORCA
                newOrca.posX = posX
                newOrca.posY = posY+1
                arrayCell.orca.add(newOrca)
                return
            }
            if (isEmptyBottom(arrayCell, EnumEntity.EMPTY)){
                arrayCell.cell[posX][posY-1] = EnumEntity.ORCA
                newOrca.posX = posX
                newOrca.posY = posY-1
                arrayCell.orca.add(newOrca)
                return
            }
            if (isEmptyLeft(arrayCell, EnumEntity.EMPTY)){
                arrayCell.cell[posX-1][posY] = EnumEntity.ORCA
                newOrca.posX = posX-1
                newOrca.posY = posY
                arrayCell.orca.add(newOrca)
                return
            }
            if (isEmptyRight(arrayCell, EnumEntity.EMPTY)){
                arrayCell.cell[posX+1][posY] = EnumEntity.ORCA
                newOrca.posX = posX+1
                newOrca.posY = posY
                arrayCell.orca.add(newOrca)
                return
            }
            if (isEmptyLeftTop(arrayCell, EnumEntity.EMPTY)){
                arrayCell.cell[posX-1][posY+1] = EnumEntity.ORCA
                newOrca.posX = posX-1
                newOrca.posY = posY+1
                arrayCell.orca.add(newOrca)
                return
            }
            if (isEmptyRightTop(arrayCell, EnumEntity.EMPTY)){
                arrayCell.cell[posX+1][posY+1] = EnumEntity.ORCA
                newOrca.posX = posX+1
                newOrca.posY = posY+1
                arrayCell.orca.add(newOrca)
                return
            }
            if (isEmptyLeftBottom(arrayCell, EnumEntity.EMPTY)){
                arrayCell.cell[posX-1][posY-1] = EnumEntity.ORCA
                newOrca.posX = posX-1
                newOrca.posY = posY-1
                arrayCell.orca.add(newOrca)
                return
            }
            if (isEmptyRightBottom(arrayCell, EnumEntity.EMPTY)){
                arrayCell.cell[posX+1][posY-1] = EnumEntity.ORCA
                newOrca.posX = posX+1
                newOrca.posY = posY-1
                arrayCell.orca.add(newOrca)
                return
            }
        }
    }

    fun death(arrayCell: ArrayCell){
        if (dead == 0){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            arrayCell.orca.remove(this)
        }
    }
    private fun searchTux(arrayCell: ArrayCell, x: Int, y: Int): Tux {
        for (tux in arrayCell.tux){
            if (tux.posX == x && tux.posY == y)
                return tux
        }
        return Tux()

    }

    override fun move(arrayCell: ArrayCell) {
       if (moveEat(arrayCell)) return else {moveOrca(arrayCell)}
    }

    private fun moveEat(arrayCell: ArrayCell) :Boolean {
        if (isEmptyTop(arrayCell, EnumEntity.TUX)){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            posY++
            arrayCell.tux.remove(searchTux(arrayCell, posX, posY))
            arrayCell.cell[posX][posY] = EnumEntity.ORCA
            minIncr()
            return true
        }
        if (isEmptyBottom(arrayCell, EnumEntity.TUX)){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            posY--
            arrayCell.tux.remove(searchTux(arrayCell, posX, posY))
            arrayCell.cell[posX][posY] = EnumEntity.ORCA
            minIncr()
            return true
        }
        if (isEmptyLeft(arrayCell, EnumEntity.TUX)){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            posX--
            arrayCell.tux.remove(searchTux(arrayCell, posX, posY))
            arrayCell.cell[posX][posY] = EnumEntity.ORCA
            minIncr()
            return true
        }
        if (isEmptyRight(arrayCell, EnumEntity.TUX)){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            posX++
            arrayCell.tux.remove(searchTux(arrayCell, posX, posY))
            arrayCell.cell[posX][posY] = EnumEntity.ORCA
            minIncr()
            return true
        }
        if (isEmptyLeftTop(arrayCell, EnumEntity.TUX)){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            posX--
            posY++
            arrayCell.tux.remove(searchTux(arrayCell, posX, posY))
            arrayCell.cell[posX][posY] = EnumEntity.ORCA
            minIncr()
            return true
        }
        if (isEmptyRightTop(arrayCell, EnumEntity.TUX)){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            posX++
            posY++
            arrayCell.tux.remove(searchTux(arrayCell, posX, posY))
            arrayCell.cell[posX][posY] = EnumEntity.ORCA
            minIncr()
            return true
        }
        if (isEmptyLeftBottom(arrayCell, EnumEntity.TUX)){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            posX--
            posY--
            arrayCell.tux.remove(searchTux(arrayCell, posX, posY))
            arrayCell.cell[posX][posY] = EnumEntity.ORCA
            minIncr()
            return true
        }
        if (isEmptyRightBottom(arrayCell, EnumEntity.TUX)){
            arrayCell.cell[posX][posY] = EnumEntity.EMPTY
            posX++
            posY--
            arrayCell.tux.remove(searchTux(arrayCell, posX, posY))
            arrayCell.cell[posX][posY] = EnumEntity.ORCA
            minIncr()
            return true
        }
         return false
    }

   private fun moveOrca(arrayCell: ArrayCell) {
        if (isEmptyTop(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posY++
            arrayCell.cell[posX][posY]=EnumEntity.ORCA
            minDead()
            return
        }

        if (isEmptyBottom(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posY--
            arrayCell.cell[posX][posY]=EnumEntity.ORCA
            minDead()
            return
        }

        if (isEmptyLeft(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX--
            arrayCell.cell[posX][posY]=EnumEntity.ORCA
            minDead()
            return
        }

        if (isEmptyRight(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX++
            arrayCell.cell[posX][posY]=EnumEntity.ORCA
            minDead()
            return
        }

        if (isEmptyLeftTop(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX--
            posY++
            arrayCell.cell[posX][posY]=EnumEntity.ORCA
            minDead()
            return
        }

        if (isEmptyRightTop(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX++
            posY++
            arrayCell.cell[posX][posY]=EnumEntity.ORCA
            minDead()
            return
        }

        if (isEmptyLeftBottom(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX--
            posY--
            arrayCell.cell[posX][posY]=EnumEntity.ORCA
            minDead()
            return
        }

        if (isEmptyRightBottom(arrayCell,EnumEntity.EMPTY)) {
            arrayCell.cell[posX][posY]=EnumEntity.EMPTY
            posX++
            posY--
            arrayCell.cell[posX][posY]=EnumEntity.ORCA
            minDead()
            return
        }
       minDead()
    }
}