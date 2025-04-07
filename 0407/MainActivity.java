package com.example.calculator1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView textViewInput;
    StringBuilder expression = new StringBuilder();
    ScriptEngine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewInput = findViewById(R.id.textViewInput);

        // 자바스크립트 엔진 (계산용)
        engine = new ScriptEngineManager().getEngineByName("rhino");

        // 숫자 & 연산 버튼 설정
        int[] btnIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv, R.id.btnDot
        };

        String[] btnValues = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "+", "-", "*", "/", "."
        };

        for (int i = 0; i < btnIds.length; i++) {
            final String value = btnValues[i];
            Button btn = findViewById(btnIds[i]);
            btn.setOnClickListener(v -> {
                expression.append(value);
                textViewInput.setText(expression.toString());
            });
        }

        // = 버튼 (계산)
        findViewById(R.id.btnEqual).setOnClickListener(v -> {
            try {
                Object result = engine.eval(expression.toString());
                textViewInput.setText("= " + result.toString());
                expression.setLength(0); // 초기화
            } catch (ScriptException e) {
                textViewInput.setText("오류");
                expression.setLength(0);
            }
        });

        // C 버튼 (초기화)
        findViewById(R.id.btnClear).setOnClickListener(v -> {
            expression.setLength(0);
            textViewInput.setText("");
        });
    }
}
