/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        //rollButton.setOnClickListener { rollDice6() }

        val  spinner: Spinner = findViewById(R.id.spinner_bar)
        ArrayAdapter.createFromResource(
            this,
            R.array.dice_array,
            android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

        }


        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                when (position) {

                     0 -> rollButton.setOnClickListener{ rollDice(6) }
                     1 -> rollButton.setOnClickListener{ rollDice( 4 ) }
                     2 -> rollButton.setOnClickListener{ rollDice( 8 ) }
                     3 -> rollButton.setOnClickListener{ rollDice( 10 ) }
                     4 -> rollButton.setOnClickListener{ rollDice(12) }
                     5 -> rollButton.setOnClickListener{ rollDice(20) }
                     6 -> rollButton.setOnClickListener{ rollDice( 100 ) }

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }


    }



    /**
     * Click listener for the Roll button.
     */
    private fun rollDice(number: Int) {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = (1..number).random()

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

//    private fun rollDice4() {
//        // Toast.makeText(this, "button clicked",
//        //  Toast.LENGTH_SHORT).show()
//        val randomInt = (1..4).random()
//
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()
//    }
//
//    private fun rollDice8() {
//        // Toast.makeText(this, "button clicked",
//        //  Toast.LENGTH_SHORT).show()
//        val randomInt = (1..8).random()
//
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()
//    }
//
//    private fun rollDice10() {
//        // Toast.makeText(this, "button clicked",
//        //  Toast.LENGTH_SHORT).show()
//        val randomInt = (1..10).random()
//
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()
//    }
//
//    private fun rollDice12() {
//        // Toast.makeText(this, "button clicked",
//        //  Toast.LENGTH_SHORT).show()
//        val randomInt = (1..12).random()
//
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()
//    }
//
//    private fun rollDice20() {
//        // Toast.makeText(this, "button clicked",
//        //  Toast.LENGTH_SHORT).show()
//        val randomInt = (1..20).random()
//
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()
//    }
//
//    private fun rollDice100() {
//        // Toast.makeText(this, "button clicked",
//        //  Toast.LENGTH_SHORT).show()
//        val randomInt = (1..100).random()
//
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()
//    }
}
