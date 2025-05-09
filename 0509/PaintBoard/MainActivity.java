package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = findViewById(R.id.drawingView);
        SeekBar seekBar = findViewById(R.id.brushSizeSeekBar);

        Button btnBlack = findViewById(R.id.btnBlack);
        Button btnRed = findViewById(R.id.btnRed);
        Button btnBlue = findViewById(R.id.btnBlue);
        Button btnEraser = findViewById(R.id.btnEraser);
        Button btnClear = findViewById(R.id.btnClear);

        btnBlack.setOnClickListener(v -> {
            drawingView.setColor(Color.BLACK);
            drawingView.setEraserMode(false);
        });

        btnRed.setOnClickListener(v -> {
            drawingView.setColor(Color.RED);
            drawingView.setEraserMode(false);
        });

        btnBlue.setOnClickListener(v -> {
            drawingView.setColor(Color.BLUE);
            drawingView.setEraserMode(false);
        });

        btnEraser.setOnClickListener(v -> {
            drawingView.setEraserMode(true);
        });

        btnClear.setOnClickListener(v -> {
            drawingView.clearCanvas();
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                drawingView.setStrokeWidth(progress);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }
}
