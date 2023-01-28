package com.example.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var respostaTextView: TextView
    private lateinit var inputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        respostaTextView = findViewById(R.id.respostaTextView)
        inputTextView = findViewById(R.id.inputTextView)
    }

    fun numeroAcao(view: View) {
        inputTextView.append((view as Button).text)
    }

    fun operadorAcao(view: View) {
        if (view is Button) {
            val inputString = inputTextView.text.toString()
            val lastChar = inputString.takeLast(1)
            if (inputString.isEmpty()) {
                Toast.makeText(this, "Formato inválido", Toast.LENGTH_SHORT).show()
                return
            } else
                if (lastChar in listOf("+", "-", "*", "%", "/")) {
                    inputTextView.text = inputString.dropLast(1)
                }
            inputTextView.append(view.text)
        }
    }

    fun igualAcao(view: View) {
        val inputString = inputTextView.text.toString()
        if (inputString.isNotEmpty()){
            val inputList = inputString.split("%", "/", "*", "-", "+")

            val resultado = 1
            respostaTextView.text = inputList.toString()
        }
    }

    fun apagarAcao(view: View) {
        val inputString = inputTextView.text.toString()
        if (inputString.isNotEmpty()) {
            inputTextView.text = inputString.dropLast(1)
        }
    }

    fun limparAcao(view: View) {
        inputTextView.text = ""
        respostaTextView.text = ""
    }

    fun pontoAcao(view: View) {
        if (view is Button) {
            val inputString = inputTextView.text.toString()
            val lastChar = inputString.takeLast(1)
            if (lastChar == "."){}
            else
                if (inputString.isEmpty() || lastChar in listOf("+", "-", "*", "%", "/")) {
                    inputTextView.append("0.")
                } else inputTextView.append(view.text)
        }
    }

    fun sinalAcao(view: View){
        val inputString = inputTextView.text.toString()
        val lastChar = inputString.take(1)
    }
}