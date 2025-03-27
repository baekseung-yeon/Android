package com.example.dice; 

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageDice; 
    private Button buttonRoll; 
    private Random random = new Random(); 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageDice = findViewById(R.id.imageDice);
        buttonRoll = findViewById(R.id.buttonRoll);

        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        int diceNumber = random.nextInt(6) + 1; // 1~6 랜덤 숫자 생성
        int diceImageId = getResources().getIdentifier("dice" + diceNumber, "drawable", getPackageName());
        imageDice.setImageResource(diceImageId); // 이미지 변경
    }
}
