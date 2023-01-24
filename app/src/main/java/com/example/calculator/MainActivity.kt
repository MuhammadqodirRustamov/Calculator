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
    private lateinit var input:TextView

    private var current = "0"
    private var ozi_bor = ""
    private var isCurrentMINUS = false

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
        input = findViewById(R.id.javob)

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
            //addPOINT()
            POINT()
        }

        buttonBACKSPACE.setOnClickListener {
           //BACKSPACE()
        }

        buttonPLS_MNS.setOnClickListener {
            //PLS_MNS()
        }

        buttonCCCCC.setOnClickListener {
            //CCCCC()
            CCCCCc()
        }

        buttonPLUS.setOnClickListener {
            //OPERATIONS("+")
            operations("+")
        }
        buttonMINUS.setOnClickListener {
            //OPERATIONS("-")
            operations("-")
        }
        buttonMULTIPLY.setOnClickListener {
            //OPERATIONS("×")
            operations("×")
        }
        buttonDIVIDE.setOnClickListener {
            //OPERATIONS("÷")
            operations("÷")
        }



    }

    fun operations(nima:String){
        if (current == "") {
            ozi_bor = ozi_bor
        }else{
            ozi_bor += nima
            current = ""
            SET()
        }
    }


    fun add(son : String){
        if (current == "0") current = ""
        if (ozi_bor == "0") ozi_bor = ""
        current += son
        ozi_bor += son
        SET()
    }

    fun POINT(){
        if (current.contains(".")) return
        ozi_bor += "."
        current += "."
        SET()
    }


    fun CCCCCc(){
        ozi_bor = "0"
        current = "0"
        SET()
    }


    fun SET(){
        hisobla.text = ozi_bor
    }

//
//    fun CCCCC(){
//        ozi_bor = ""
//        current = "0"
//        isCurrentMINUS = false
//        setHisoblaJAVOB()
//    }
//
//    fun PLS_MNS(){
//        if (current == "0") return
//        if (isCurrentMINUS){
//            isCurrentMINUS = false
//        }else{
//            isCurrentMINUS = true
//        }
//        setHisoblaJAVOB()
//    }
//
//    fun BACKSPACE(){
//        if (current.length > 0) current = current.substring(0, current.length-1)
//        if (current == "") {
//            current = "0"
//            isCurrentMINUS = false
//        }
//
//        setHisoblaJAVOB()
//
//    }
//
//    @SuppressLint("SetTextI18n")
//    fun add(son : String){
//        if (current == "0") current = ""
//        current += son
//        input.text = current
//        setHisoblaJAVOB()
//    }
//    fun addPOINT(){
//        if (!current.contains('.')){
//            current += "."
//            hisobla.text = current
//            setHisoblaJAVOB()
//
//        }
//    }
//    @SuppressLint("SetTextI18n")
//    fun setHisoblaJAVOB(){
//        if (isCurrentMINUS){
//            hisobla.text = ozi_bor + "(-" + current + ")"
//            input.text = "-" + current
//        }else{
//            hisobla.text = ozi_bor + current
//            input.text = current
//        }
//
//
//    }
//
//    fun OPERATIONS(nima:String){
//        if (current == "0") return
//        if (isCurrentMINUS){
//            ozi_bor = ozi_bor + "(-" + current + ")" + nima
//        }else{
//            ozi_bor = ozi_bor + current + nima
//        }
//        current = "0"
//
//
//        setHisoblaJAVOB()
//
//    }


}