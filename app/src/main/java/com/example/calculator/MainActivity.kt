package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private lateinit var buttonPLSMNS: Button
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
        buttonPLSMNS = findViewById(R.id.buttonPLS_MNS)
        buttonPERCENT = findViewById(R.id.buttonPERCENT)
        buttonPLUS = findViewById(R.id.buttonPLUS)
        buttonMINUS = findViewById(R.id.buttonMINUS)
        buttonMULTIPLY = findViewById(R.id.buttonMULTIPLY)
        buttonDIVIDE = findViewById(R.id.buttonDIVIDE)
        buttonEQUAL = findViewById(R.id.buttonEQUAL)

        enter = findViewById(R.id.hisobla)
        result = findViewById(R.id.javob)

        button1.setOnClickListener {add("1") }
        button2.setOnClickListener { add("2") }
        button3.setOnClickListener { add("3") }
        button4.setOnClickListener { add("4") }
        button5.setOnClickListener { add("5") }
        button6.setOnClickListener { add("6") }
        button7.setOnClickListener { add("7") }
        button8.setOnClickListener { add("8") }
        button9.setOnClickListener { add("9") }
        button0.setOnClickListener { add("0") }
        buttonPOINT.setOnClickListener { add(".") }

        buttonBACKSPACE.setOnClickListener { backspace() }
        buttonPLSMNS.setOnClickListener { negativePositive() }
        buttonCCCCC.setOnClickListener { clear() }
        buttonPLUS.setOnClickListener { amal("+") }
        buttonMINUS.setOnClickListener { amal("-") }
        buttonMULTIPLY.setOnClickListener { amal("×") }
        buttonDIVIDE.setOnClickListener { amal("÷") }
        buttonPERCENT.setOnClickListener{ percent() }
    }

    private var current = "0"
    private var all = ArrayList<String>()

    private fun hasPoint(): Boolean { return current.contains('.') }
    private fun hasAmal(): Boolean { return current == "" }
    private fun isNegative(): Boolean {return current[0] == '-'}

    private fun getAll(): MutableList<String> {return all.toMutableList()}
    private fun update() { enter.text = getTEXT() }
    private fun setResult(){ if (all.size > 0 && current != "") result.text = calculate() else result.text = "" }


    private fun backspace(){
        if (current == "0" && all.size == 0) return
        if (current == "-") current = ""
        if (current != ""){
            current = current.substring(0, current.length-1)
            if (current == "" && all.size == 0) current = "0"
        }else{
            all.removeAt(all.size-1)
            current = all[all.size-1]
            all.removeAt(all.size-1)
        }
        if (current == "-") current = ""
        if (current == "" && all.size == 0) current = "0"
        setResult()
        update()
    }

    private fun clear() {
        all.clear()
        current = "0"
        result.text = ""
        update()
    }

    private fun add(nima: String) {
        if (nima == "." && hasPoint()) return
        if (current == "0") current = ""
        if (nima == "." && current.isEmpty()) current += "0"
        current += nima
        setResult()
        update()
    }

    private fun amal(nima: String) {
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

    private fun percent(){
        if (current == "") return
        if (all.size == 0) return
        if (all[all.size-1] != "÷") all[all.size-1] = "×"
        var myNum = current.toDouble()
        myNum /= 100
        current = myNum.toString()
        setResult()
        update()
    }

    private fun negativePositive(){
        if (current.isEmpty() || current == "0") return
        current = if (isNegative()) current.substring(1, current.length) else "-$current"
        setResult()
        update()
    }

    private fun calculate(): String {
        return step2(step1(getAll()))
    }

    private fun step1(list: MutableList<String>): MutableList<String> {
        if (!list.contains("÷") && !list.contains("×")) return list
        list.add(current)
        var j = 0
        while (j < list.size){
            val i = list[j]
            if (i == "÷" || i == "×"){
                val first = list[j-1].toDouble()
                val second = list[j+1].toDouble()
                val res:Double = if (i == "×") first*second
                else first/second
                list[j-1] = if ((res % 1).toFloat() == (0).toFloat()) res.toInt().toString() else res.toString()
                list.removeAt(j)
                list.removeAt(j)
                j-=2
            }
            j++
        }
        return list
    }

    private fun step2(list: MutableList<String>): String {
        if (!list.contains("+") && !list.contains("-")) return list[0]
        list.add(current)
        var j = 0
        while (j < list.size) {
            val i = list[j]
            if (i == "+" || i == "-") {
                val first = list[j - 1].toDouble()
                val second = list[j + 1].toDouble()
                val res: Double = if (i == "+") first + second
                else first - second
                list[j - 1] = if ((res % 1).toFloat() == (0).toFloat()) res.toInt()
                    .toString() else res.toString()
                list.removeAt(j)

                list.removeAt(j)
            }
            j++
        }
        return list[0]
    }

    private fun getTEXT(): String {
        var returnVal = ""
        if (all.size == 0) return current
        for (j in all.indices) {
            val i = all[j]
            returnVal += if (i.length > 1 && i.contains('-') && j != 0) {
                "($i)"
            } else {
                i
            }
        }
        returnVal += if (current.contains('-')) "($current)"
        else current
        return returnVal
    }
}