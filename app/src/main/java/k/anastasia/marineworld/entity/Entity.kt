package k.anastasia.marineworld.entity

import k.anastasia.marineworld.ArrayCell
import k.anastasia.marineworld.common.EnumEntity

interface Entity {
    var posX: Int
    var posY: Int
    var increase: Int

    fun move(arrayCell: ArrayCell)
    fun increase(arrayCell: ArrayCell)

    fun minIncr() {
        if (increase != 0) increase--
    }

    fun isEmptyTop(arrayCell: ArrayCell, enumEntity: EnumEntity): Boolean {
        return posY != arrayCell.ht - 1 && arrayCell.cell[posX][posY + 1] == enumEntity
    }

    fun isEmptyBottom(arrayCell: ArrayCell, enumEntity: EnumEntity): Boolean {
        return posY != 0 && arrayCell.cell[posX][posY-1] == enumEntity
    }

    fun isEmptyLeft(arrayCell: ArrayCell, enumEntity: EnumEntity): Boolean {
        return posX != 0 && arrayCell.cell[posX-1][posY] == enumEntity
    }

    fun isEmptyRight(arrayCell: ArrayCell, enumEntity: EnumEntity): Boolean {
        return posX != arrayCell.wh - 1 && arrayCell.cell[posX+1][posY] == enumEntity
    }

    fun isEmptyLeftTop(arrayCell: ArrayCell, enumEntity: EnumEntity): Boolean {
        return posX!=0 && posY != arrayCell.ht-1  && arrayCell.cell[posX -1][posY + 1] == enumEntity
    }

    fun isEmptyRightTop(arrayCell: ArrayCell, enumEntity: EnumEntity): Boolean {
        return posY != arrayCell.ht - 1 && posX != arrayCell.wh - 1 && arrayCell.cell[posX + 1][posY + 1] == enumEntity
    }

    fun isEmptyLeftBottom(arrayCell: ArrayCell, enumEntity: EnumEntity): Boolean {
        return posY != 0 && posX != 0 && arrayCell.cell[posX - 1][posY - 1] == enumEntity
    }

    fun isEmptyRightBottom(arrayCell: ArrayCell, enumEntity: EnumEntity): Boolean {
        return posX != arrayCell.wh - 1 && posY != 0 && arrayCell.cell[posX + 1][posY - 1] == enumEntity
    }
}