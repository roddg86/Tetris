package com.bignerdranch.android.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.bignerdranch.android.tetris.storage.AppPreferences
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    var tvHighScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* скрыть панель действий */
        supportActionBar?.hide()

        /* сформировать ссылки на обьекты для виджетов */
        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        val btnExit = findViewById<Button>(R.id.btn_exit)
        tvHighScore = findViewById<TextView>(R.id.tv_high_score)

        /* слушатель устанавливает функцию которая вызывается при щелчке на представлении */
        btnNewGame.setOnClickListener(this::onBtnNewGameClick)
    }

    /* функция обработки щелчка на кнопку btnNewGame */
    private fun onBtnNewGameClick(view: View) {
        /* применить намерение для запуска действия
        this - это текущий контекст, фактически это текущее действие MainActivity, передается первым аргументом
        */
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    /* функция обработки щелчка на кнопку reset score */
    private fun onBtnResetScoreClick(view: View){
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
    }

    /* функция обработки щелчка на кнопку exit */
    private fun onBtnExitClick(view: View){
        /* метод завержает программу если в аргумент передается число 0 */
        exitProcess(0)
    }
}