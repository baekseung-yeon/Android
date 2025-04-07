# 📱 Android 계산기 앱 개발 기록

안드로이드 스튜디오를 이용해 Java와 XML로 만든 계산기 어플 개발 과정을 ChatGPT와 대화하며 정리한 기록입니다.  
이 앱은 기본적인 사칙연산(`+`, `-`, `*`, `/`) 기능과 버튼 기반의 입력 UI를 포함하고 있습니다.

---

## 💬 사용자 프롬프트 및 개발 과정

```
1. 안드로이드 어플을 만들 예정
2. 계산기 어플을 만들거임
3. xml, java 파일을 이용할 거임
4. -,+,/,*(빼기, 더하기, 나누기, 곱하기) 연산이 가능함
5. 각각 연산 기능은 버튼으로 구현하고
6. 화면 레이아웃은 값 두개를 위에서 받는곳을 배치하고
   그 밑에 버튼이 배치되고 버튼 아래에 결과값이 도출되게 해줘
```

이에 따라 다음과 같은 레이아웃과 기능으로 기본 구조를 구성했습니다.

### 📄 `activity_main.xml`

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp">

    <EditText
        android:id="@+id/editTextNumber1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="숫자 1 입력"
        android:inputType="numberDecimal"/>

    <EditText
        android:id="@+id/editTextNumber2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="숫자 2 입력"
        android:inputType="numberDecimal"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="16dp"
        android:gravity="center">

        <Button android:id="@+id/btnAdd" android:layout_weight="1" android:text="+" />
        <Button android:id="@+id/btnSub" android:layout_weight="1" android:text="-" />
        <Button android:id="@+id/btnMul" android:layout_weight="1" android:text="*" />
        <Button android:id="@+id/btnDiv" android:layout_weight="1" android:text="/" />
    </LinearLayout>

    <TextView
        android:id="@+id/textViewResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="결과:"
        android:textSize="18sp"
        android:layout_marginTop="24dp"
        android:textStyle="bold"/>
</LinearLayout>
```

### 🧠 `MainActivity.java`

```java
public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);

        findViewById(R.id.btnAdd).setOnClickListener(v -> calculate('+'));
        findViewById(R.id.btnSub).setOnClickListener(v -> calculate('-'));
        findViewById(R.id.btnMul).setOnClickListener(v -> calculate('*'));
        findViewById(R.id.btnDiv).setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char op) {
        String n1 = editTextNumber1.getText().toString();
        String n2 = editTextNumber2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            textViewResult.setText("숫자를 모두 입력하세요");
            return;
        }

        double a = Double.parseDouble(n1);
        double b = Double.parseDouble(n2);
        double result = 0;

        switch (op) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/':
                if (b == 0) {
                    textViewResult.setText("0으로 나눌 수 없습니다");
                    return;
                }
                result = a / b; break;
        }

        textViewResult.setText("결과: " + result);
    }
}
```

---

```
기존 구현은 성공적으로 됐어 이제 숫자를 0~9까지 버튼으로 만들어줘
```

기존 `EditText` 입력 대신 숫자 버튼을 추가하여 계산기처럼 동작하도록 수정합니다.

---

```
숫자 1선택, 숫자 2선택은 필요없을 것 같아
키 배치도 기존에 있던 계산기들과 배치를 비슷하게 맞춰줘
```

이에 따라 일반 계산기처럼 입력 필드 하나와 계산기 형태의 키패드를 구성하고  
`=` 버튼으로 계산, `C` 버튼으로 초기화 기능을 구현합니다.

### 🔢 키패드 형태 `activity_main.xml`

```xml
<TextView
    android:id="@+id/textViewInput"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textSize="32sp"
    android:gravity="end"
    android:padding="16dp"
    android:background="#EEEEEE"
    android:text=""/>

<GridLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:columnCount="4"
    android:layout_marginTop="16dp">

    <Button android:id="@+id/btn7" android:text="7"/>
    <Button android:id="@+id/btn8" android:text="8"/>
    <Button android:id="@+id/btn9" android:text="9"/>
    <Button android:id="@+id/btnDiv" android:text="/"/>

    <Button android:id="@+id/btn4" android:text="4"/>
    <Button android:id="@+id/btn5" android:text="5"/>
    <Button android:id="@+id/btn6" android:text="6"/>
    <Button android:id="@+id/btnMul" android:text="*"/>

    <Button android:id="@+id/btn1" android:text="1"/>
    <Button android:id="@+id/btn2" android:text="2"/>
    <Button android:id="@+id/btn3" android:text="3"/>
    <Button android:id="@+id/btnSub" android:text="-"/>

    <Button android:id="@+id/btn0" android:text="0"/>
    <Button android:id="@+id/btnDot" android:text="."/>
    <Button android:id="@+id/btnEqual" android:text="="/>
    <Button android:id="@+id/btnAdd" android:text="+"/>

    <Button android:id="@+id/btnClear"
        android:text="C"
        android:layout_columnSpan="4"
        android:layout_width="match_parent"/>
</GridLayout>
```

### 🧠 수정된 `MainActivity.java` (ScriptEngine 사용)

```java
public class MainActivity extends AppCompatActivity {

    TextView textViewInput;
    StringBuilder expression = new StringBuilder();
    ScriptEngine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewInput = findViewById(R.id.textViewInput);
        engine = new ScriptEngineManager().getEngineByName("rhino");

        int[] btnIds = {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv, R.id.btnDot
        };

        String[] values = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "+", "-", "*", "/", "."
        };

        for (int i = 0; i < btnIds.length; i++) {
            String val = values[i];
            findViewById(btnIds[i]).setOnClickListener(v -> {
                expression.append(val);
                textViewInput.setText(expression.toString());
            });
        }

        findViewById(R.id.btnEqual).setOnClickListener(v -> {
            try {
                Object result = engine.eval(expression.toString());
                textViewInput.setText("= " + result.toString());
                expression.setLength(0);
            } catch (Exception e) {
                textViewInput.setText("오류");
                expression.setLength(0);
            }
        });

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            expression.setLength(0);
            textViewInput.setText("");
        });
    }
}
```

---

## ✅ 향후 추가 가능 기능

- 백스페이스(←) 버튼
- 괄호 `()` 입력 기능
- 음수 처리 및 연산 우선순위 표시
- 다크모드 지원
