package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var dice1Image : ImageView
    lateinit var dice2Image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice1Image = findViewById(R.id.dice1_image)
        dice2Image = findViewById(R.id.dice2_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clearDice() }
    }

    private fun clearDice() {
        dice1Image.setImageResource(R.drawable.empty_dice)
        dice2Image.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice() {
        // Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        val dice1Number: Int = getRandomDiceImage();
        var dice2Number: Int
        do {
            dice2Number = getRandomDiceImage();
        } while (dice1Number == dice2Number)

        dice1Image.setImageResource(dice1Number)
        dice2Image.setImageResource(dice2Number)
    }

    private fun getRandomDiceImage(): Int {
        val randomInt: Int = (1..6).random()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }

}