package com.example.diceroller;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;


/*
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the Button in the layout
        Button rollButton = (Button) findViewById(R.id.button);

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener (v-> rollDice() );
        // Do a dice roll when the app starts
        rollDice();
    }
    public void rollDice(){
        // Create new Dice object with 6 sides and roll it
        Dice side = new Dice(6);
        int diceRoll = side.roll();

        // Find the ImageView in the layout
        ImageView diceImage = (ImageView) findViewById(R.id.imageView);

        // Determine which drawable resource ID to use based on the dice roll
        int drawableResource;
        switch(diceRoll){
            case 1:
                drawableResource = R.drawable.dice_1;
                break;
            case 2:
                drawableResource = R.drawable.dice_2;
                break;
            case 3:
                drawableResource = R.drawable.dice_3;
                break;
            case 4:
                drawableResource = R.drawable.dice_4;
                break;
            case 5:
                drawableResource = R.drawable.dice_5;
                break;
            default:
                drawableResource = R.drawable.dice_6;
                break;
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource);

        // Update the content description
        diceImage.setContentDescription(Integer.toString(diceRoll));


    }
}

/*
 * Dice with a fixed number of sides.
 */
class Dice{
    int side;
    /*
     * Do a random dice roll and return the result.
     */
    public Dice(int numSide){
        side =  numSide;
    }
    public int roll() {

        return (int) (Math.random() * (side)) + 1;
    }
}