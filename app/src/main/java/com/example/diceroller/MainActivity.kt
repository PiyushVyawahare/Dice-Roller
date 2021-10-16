package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll)
        val resultImageView: ImageView = findViewById(R.id.imageView)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            rollDice(resultImageView)
        }
        rollDice(resultImageView)
    }
}

// class to create and roll a dice
class Dice(private val numSides: Int){

    fun roll(): Int{
        return (1..numSides).random()
    }
}

//Roll the dice and update the screen with the result.
private fun rollDice(diceImage: ImageView) {
    // Create new Dice object with 6 sides and roll it
    val dice = Dice(6)
    val diceRoll = dice.roll()

    // Determine which drawable resource ID to use based on the dice roll
    val drawableResource = when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // Update the ImageView with the correct drawable resource ID
    diceImage.setImageResource(drawableResource)

    // Update the content description
    diceImage.contentDescription = diceRoll.toString()
}