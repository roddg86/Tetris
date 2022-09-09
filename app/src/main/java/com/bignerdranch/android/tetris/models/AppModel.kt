package com.bignerdranch.android.tetris.models

class AppModel {
    enum class Statuses {
        AWAITING_START, ACTIVE, OVER
    }

    enum class Motions {
        LEFT, RIGHT, DOWN, ROTATE
    }
}