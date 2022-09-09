package com.bignerdranch.android.tetris.models

import android.graphics.Point
import com.bignerdranch.android.tetris.constants.CellConstants
import com.bignerdranch.android.tetris.constants.FieldConstants
import com.bignerdranch.android.tetris.helpers.array2dOfByte
import com.bignerdranch.android.tetris.storage.AppPreferences

class AppModel {
    var score: Int = 0
    private var preferences: AppPreferences? = null

    var currentBlock: Block? = null
    var currentState: String = Statuses.AWAITING_START.name

    private var field: Array<ByteArray> = array2dOfByte(
        FieldConstants.ROW_COUNT.value,
        FieldConstants.COLUMN_COUNT.value
    )

    private fun validTranslation(position: Point, shape: Array<ByteArray>): Boolean {
        return if (position.y < 0 || position.x < 0) {
            false
        } else if (position.y + shape.size > FieldConstants.ROW_COUNT.value) {
            false
        } else if (position.x + shape[0].size > FieldConstants.COLUMN_COUNT.value) {
            false
        } else {
            // Check all the items in field:
            for (i in 0 until shape.size) {
                for (j in 0 until shape[i].size) {

                    val y = position.y + i
                    val x = position.x + j

                    if (CellConstants.EMPTY.value != shape[i][j] && CellConstants.EMPTY.value != field[y][x]) {
                        return false
                    }
                }
            }
            true
        }
    }

    fun setPreferences(preferences: AppPreferences?) {
        this.preferences = preferences
    }

    fun getCellStatus(row: Int, column: Int): Byte? {
        return field[row][column]
    }

    private fun setCellStatus(row: Int, column: Int, status: Byte?) {
        if (status != null) {
            field[row][column] = status
        }
    }

    private fun boostScore() {
        score += 10
        if (score > preferences?.getHighScore() as Int)
            preferences?.saveHighScore(score)
    }

    fun isGameOver(): Boolean {
        return currentState == Statuses.OVER.name
    }

    fun isGameActive(): Boolean {
        return currentState == Statuses.ACTIVE.name
    }

    fun isGameAwaitingStart(): Boolean {
        return currentState == Statuses.AWAITING_START.name
    }

    enum class Statuses {
        AWAITING_START, ACTIVE, OVER
    }

    enum class Motions {
        LEFT, RIGHT, DOWN, ROTATE
    }
}