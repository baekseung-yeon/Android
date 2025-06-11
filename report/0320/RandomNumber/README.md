# 🎲 난수 생성기 앱

이 프로젝트는 안드로이드(Java) 기반의 간단한 **난수 생성기 앱**입니다. 사용자가 버튼을 누르면 **0부터 99 사이의 정수 난수**가 생성되어 화면에 출력됩니다. 

---

## ✅ 주요 기능

- 버튼 클릭 시 0~99 사이의 정수 난수를 랜덤으로 생성
- 생성된 난수는 텍스트 뷰에 실시간으로 표시
- 직관적인 사용자 인터페이스 제공

---

## 🛠️ 개발 환경

- **언어**: Java  
- **IDE**: Android Studio  
- **지원 기기**: Android 스마트폰

---

## 📦 코드 구성

### 🔹 XML 레이아웃 (`res/layout/activity_main.xml`)
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <TextView
        android:id="@+id/textViewRandomNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="난수를 생성하세요!"
        android:textSize="24sp"
        android:padding="16dp"/>

    <Button
        android:id="@+id/buttonGenerate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="난수 생성"
        android:onClick="generateRandomNumber"/>
</LinearLayout>
```
```java
package com.example.random;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);
    }

    public void generateRandomNumber(View view) {
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 0 ~ 99 사이의 난수

        textViewRandomNumber.setText("난수: " + randomNumber);
    }
}

```
