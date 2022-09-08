package com.bignerdranch.android.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bignerdranch.android.tetris.storage.AppPreferences

class GameActivity : AppCompatActivity() {
    var tvHighScore: TextView? = null
    var tvCurrentScore: TextView? = null
    var appPreferences: AppPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        appPreferences = AppPreferences(this)

        /* создаем ссылки на обьекты элементов представлений макета */
        val btnRestart = findViewById<Button>(R.id.btn_restart)
        tvHighScore = findViewById<TextView>(R.id.tv_high_score)
        tvCurrentScore = findViewById<TextView>(R.id.tv_current_score)

        /* функции вызываются при создании представления */
        updateHighScore()
        updateCurrentScore()

    }

    /* функция максимального количества очков */
    private fun updateHighScore(){
        tvHighScore?.text = "${appPreferences?.getHighScore()}"
    }

    /* функция заданного по умолчанию количество очков */
    private fun updateCurrentScore(){
        tvCurrentScore?.text = "0"
    }
}