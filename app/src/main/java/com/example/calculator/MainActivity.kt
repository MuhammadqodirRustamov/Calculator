package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var buttonPOINT: Button
    private lateinit var buttonBACKSPACE: Button
    private lateinit var buttonCCCCC: Button
    private lateinit var buttonPLS_MNS: Button
    private lateinit var buttonPERCENT: Button
    private lateinit var buttonPLUS: Button
    private lateinit var buttonMINUS: Button
    private lateinit var buttonMULTIPLY: Button
    private lateinit var buttonDIVIDE: Button
    private lateinit var buttonEQUAL: Button

    private lateinit var enter: TextView
    private lateinit var result: TextView


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

        enter = findViewById(R.id.hisobla)
        result = findViewById(R.id.javob)

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
            add(".")
        }

        buttonBACKSPACE.setOnClickListener {

        }

        buttonPLS_MNS.setOnClickListener {
            pls_mns()
        }

        buttonCCCCC.setOnClickListener {
            clear()
        }

        buttonPLUS.setOnClickListener {
            amal("+")
        }
        buttonMINUS.setOnClickListener {
            amal("-")
        }
        buttonMULTIPLY.setOnClickListener {
            amal("×")
        }
        buttonDIVIDE.setOnClickListener {
            amal("÷")
        }


    }


    private var current = "0"
    private var all = ArrayList<Any>()


    fun hasPoint(): Boolean { return current.contains('.') }
    fun hasAmal(): Boolean { return current == "" }
    fun isManfiy(): Boolean {return current[0] == '-'}


    fun clear() {
        all.clear()
        current = "0"
        update()
    }

    fun add(nima: String) {
        if (nima == "." && hasPoint()) return
        if (current == "0") current = ""
        if (nima == "." && current.isEmpty()) current += "0"
        if (nima != ".") current += nima
        //calculate()
        update()
    }

    fun amal(nima: String) {
        if (hasAmal()) {
            all[all.size-1] = nima
            update()
            return
        }
        if (current.last() == '.') current = current.substring(0, current.length-1)
        all.add(current)
        all.add(nima)
        current = ""
        update()
    }

    fun pls_mns(){
        if (current.isEmpty() || current == "0") return
        current = if (isManfiy()) current.substring(1, current.length) else "-" + current
        update()
    }

    fun calculate(): String {
        step1()

        return "123"
    }


    fun step1(): ArrayList<Any> {
        var list = all
        list.add(current)
        if (!list.contains("÷") && !list.contains("×")) {
            Log.d("TAG", list.toString())
            return list
        }

        var j = 0
        while (j < list.size){

            val i = list[j]
            Log.d("ishladi", i.toString())

            if (i == "÷" || i == "×"){
                val bir = list[j-1] as Double
                val ikki = list[j+1] as Double
                var res:Double
                if (i == "×") res = bir*ikki
                else res = bir/ikki
                list[j-1] = res
                list.removeAt(j)
                list.removeAt(j)
            }
            j++
        }
        return list


    }





    fun getTEXT(): String {
        var returnVal = ""
        if (all.size == 0) return current
        for (j in all.indices) {
            var  i = all[j]
            if (i.toString().length > 1 && i.toString().contains('-') && j != 0) {
                returnVal += "(" + i.toString() + ")"
            } else {
                returnVal += i.toString()
            }
        }
        if (current.contains('-')) returnVal += "(" + current + ")"
        else returnVal += current
        return returnVal
    }


    fun update() {
        enter.text = getTEXT()
    }


//
//    fun operations(nima:String){
//        if (current == "") {
//            ozi_bor = ozi_bor
//        }else{
//            ozi_bor += nima
//            current = ""
//            SET()
//        }
//    }
//
//
//    fun add(son : String){
//        if (current == "0") current = ""
//        if (ozi_bor == "0") ozi_bor = ""
//        current += son
//        ozi_bor += son
//        SET()
//    }
//
//    fun POINT(){
//        if (current.contains(".")) return
//        ozi_bor += "."
//        current += "."
//        SET()
//    }
//
//
//    fun CCCCCc(){
//        ozi_bor = "0"
//        current = "0"
//        SET()
//    }
//
//
//    fun SET(){
//        hisobla.text = ozi_bor
//    }

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