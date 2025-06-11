# Android 계산기 예제

간단한 사칙연산 계산기 앱 예제입니다.  
두 숫자를 입력받아 덧셈, 뺄셈, 곱셈, 나눗셈 결과를 보여줍니다.

---

## 주요 기능

- 두 숫자 입력 (`EditText`)  
- 4가지 연산 버튼 (+, -, ×, ÷)  
- 결과 출력 (`TextView`)  
- 입력 값 검증 (빈 칸, 0으로 나누기 방지)

---

## 소스코드 설명

### activity_main.xml

```xml
# Android 계산기 예제

간단한 사칙연산 계산기 앱 예제입니다.  
두 숫자를 입력받아 덧셈, 뺄셈, 곱셈, 나눗셈 결과를 보여줍니다.

---

## 주요 기능

- 두 숫자 입력 (`EditText`)  
- 4가지 연산 버튼 (+, -, ×, ÷)  
- 결과 출력 (`TextView`)  
- 입력 값 검증 (빈 칸, 0으로 나누기 방지)

---

## 소스코드 설명

### MainActivity.java

```java
package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText eText1, eText2;
    TextView textViewResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eText1 = findViewById(R.id.edit1);
        eText2 = findViewById(R.id.edit2);
        textViewResult = findViewById(R.id.textViewResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(view -> calculate('+'));
        btnSub.setOnClickListener(view -> calculate('-'));
        btnMul.setOnClickListener(view -> calculate('*'));
        btnDiv.setOnClickListener(view -> calculate('/'));
    }

    private void calculate(char operator) {
        String s1 = eText1.getText().toString();
        String s2 = eText2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            textViewResult.setText("숫자를 입력하세요.");
            return;
        }

        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);

        if (operator == '/' && num2 == 0) {
            textViewResult.setText("0으로 나눌 수 없습니다.");
            return;
        }

        double result = 0;
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
        }

        textViewResult.setText("결과: " + result);
    }
}
```

### MainActivity.java

```java
package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText eText1, eText2;
    TextView textViewResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eText1 = findViewById(R.id.edit1);
        eText2 = findViewById(R.id.edit2);
        textViewResult = findViewById(R.id.textViewResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(view -> calculate('+'));
        btnSub.setOnClickListener(view -> calculate('-'));
        btnMul.setOnClickListener(view -> calculate('*'));
        btnDiv.setOnClickListener(view -> calculate('/'));
    }

    private void calculate(char operator) {
        String s1 = eText1.getText().toString();
        String s2 = eText2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            textViewResult.setText("숫자를 입력하세요.");
            return;
        }

        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);

        if (operator == '/' && num2 == 0) {
            textViewResult.setText("0으로 나눌 수 없습니다.");
            return;
        }

        double result = 0;
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
        }

        textViewResult.setText("결과: " + result);
    }
}
```
