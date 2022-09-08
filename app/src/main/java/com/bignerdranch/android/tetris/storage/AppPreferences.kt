package com.bignerdranch.android.tetris.storage

import android.content.Context
import android.content.SharedPreferences

/* класс утилит */
class AppPreferences(ctx: Context) {
    var data: SharedPreferences = ctx.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)

    /* функция сохраняет наибольшее количество очков */
    fun saveHighScore(highScore: Int) {
        data.edit().putInt("HIGH_SCORE", highScore).apply()
    }

    /* функция возвращает наибольшее количество очков */
    fun getHighScore(): Int {
        return data.getInt("HIGH_SCORE", 0)
    }

    /* функция сбрасывает значение до нуля */
    fun clearHighScore() {
        data.edit().putInt("HIGH_SCORE", 0).apply()
    }
}