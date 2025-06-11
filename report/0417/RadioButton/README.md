# RadioButton

이 앱은 사용자가 안드로이드 버전을 선택하면, 그에 해당하는 이미지를 보여주는 **간단한 이미지 전환 앱**입니다. `RadioButton`으로 버전을 선택하고 `Button`을 클릭하면 해당 이미지가 `ImageView`에 표시됩니다.

---

## RadioButton이란?

**RadioButton**은 안드로이드에서 **여러 항목 중 하나만 선택할 수 있게 해주는 UI 요소**입니다. 사용자는 한 번에 하나의 옵션만 선택할 수 있으며, 보통 `RadioGroup` 안에 묶어서 사용합니다.

---

## 예시

```xml
<RadioGroup android:id="@+id/radioGroup">
    <RadioButton android:id="@+id/radio1" android:text="옵션 1"/>
    <RadioButton android:id="@+id/radio2" android:text="옵션 2"/>
    <RadioButton android:id="@+id/radio3" android:text="옵션 3"/>
</RadioGroup>
```

## 📱 주요 기능

- 안드로이드 버전 선택 (`RadioButton`)
- 버튼 클릭 시 이미지 전환 (`ImageView`)
- 간단한 사용자 인터페이스

---

## XML 레이아웃 (`activity_main.xml`)

```xml
<LinearLayout>
    <TextView
        android:text="현재 사용중인 안드로이드 버전은?" />

    <RadioGroup android:id="@+id/radioGroup">
        <RadioButton android:id="@+id/radio233" android:text="2.3.3" android:checked="true"/>
        <RadioButton android:id="@+id/radio41" android:text="4.1"/>
        <RadioButton android:id="@+id/radio44" android:text="4.4"/>
    </RadioGroup>

    <Button android:id="@+id/btnDisplay" android:text="DISPLAY IMAGE"/>

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:src="@drawable/image0"/>
</LinearLayout>
```
## Java 코 (`MainActivity.java`)

```java 
public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button btnDisplay;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        btnDisplay = findViewById(R.id.btnDisplay);
        imageView = findViewById(R.id.imageView);

        btnDisplay.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == R.id.radio233) {
                imageView.setImageResource(R.drawable.image0);
            } else if (selectedId == R.id.radio41) {
                imageView.setImageResource(R.drawable.image1);
            } else if (selectedId == R.id.radio44) {
                imageView.setImageResource(R.drawable.image2);
            }
        });
    }
}
```
---

## 📱 이미지 리소스 

res/drawable/에 아래 이미지 파일 추가:

- image0.png
- image1.png
- image2.png
