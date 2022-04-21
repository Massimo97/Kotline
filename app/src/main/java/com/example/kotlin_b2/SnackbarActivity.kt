package com.example.kotlin_b2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar

class SnackbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multifontions_fragment)

        // Snack Bar
        var llmain : LinearLayout = findViewById(R.id.main)
        var btn1 : Button = findViewById(R.id.btn1)
        var btn2 : Button = findViewById(R.id.btn2)
        var btn3 : Button = findViewById(R.id.btn3)



        btn1.setOnClickListener {
            val defaultSnackbar: Snackbar = Snackbar.make(llmain, "Coucou, :)", Snackbar.LENGTH_LONG)
            defaultSnackbar.show()
        }

        btn2.setOnClickListener {
            val customSnackbar: Snackbar = Snackbar.make(llmain, "essayez encore :(", Snackbar.LENGTH_LONG).setAction("Re-try"){}
                customSnackbar.setActionTextColor(Color.RED)
                customSnackbar.show()
        }

        btn3.setOnClickListener {
            val actionSnackbar = Snackbar.make(llmain,"Message is supprime ;/", Snackbar.LENGTH_LONG).setAction("UNDO",object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val snackbar = Snackbar.make(llmain,"Message est restaure!!", Snackbar.LENGTH_LONG)
                    snackbar.show()
                }

            })
            actionSnackbar.show()
        }

    }

}
