package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button1:Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var button0:Button
    private lateinit var buttonPOINT:Button
    private lateinit var buttonBACKSPACE:Button
    private lateinit var buttonCCCCC:Button
    private lateinit var buttonPLS_MNS:Button
    private lateinit var buttonPERCENT:Button
    private lateinit var buttonPLUS:Button
    private lateinit var buttonMINUS:Button
    private lateinit var buttonMULTIPLY:Button
    private lateinit var buttonDIVIDE:Button
    private lateinit var buttonEQUAL:Button

    private lateinit var hisobla:TextView
    private lateinit var javob:TextView

    private var current = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.light)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button0 = findViewById(R.id.button0)
        buttonPOINT = findViewById(R.id.buttonPOINT)
        buttonBACKSPACE = findViewById(R.id.buttonBACKSPACE)
        buttonCCCCC = findViewById(R.id.buttonCCCCC)
        buttonPLS_MNS = findViewById(R.id.buttonPLS_MNS)
        buttonPERCENT = findViewById(R.id.buttonPERCENT)
        buttonPLUS = findViewById(R.id.buttonPLUS)
        buttonMINUS = findViewById(R.id.buttonMINUS)
        buttonMULTIPLY = findViewById(R.id.buttonMULTIPLY)
        buttonDIVIDE = findViewById(R.id.buttonDIVIDE)
        buttonEQUAL = findViewById(R.id.buttonEQUAL)

        hisobla = findViewById(R.id.hisobla)
        javob = findViewById(R.id.javob)

        button1.setOnClickListener {
            add("1")
        }
        button2.setOnClickListener {
            add("2")
        }
        button3.setOnClickListener {
            add("3")
        }
        button4.setOnClickListener {
            add("4")
        }
        button5.setOnClickListener {
            add("5")
        }
        button6.setOnClickListener {
            add("6")
        }
        button7.setOnClickListener {
            add("7")
        }
        button8.setOnClickListener {
            add("8")
        }
        button9.setOnClickListener {
            add("9")
        }
        button0.setOnClickListener {
            add("0")
        }
        buttonPOINT.setOnClickListener {
            addPOINT()
        }


    }

    @SuppressLint("SetTextI18n")
    fun add(son : String){
        current += son
        hisobla.text = current
    }
    fun addPOINT(){
        if (!current.contains('.')){
            current += "."
            hisobla.text = current
        }
    }

}