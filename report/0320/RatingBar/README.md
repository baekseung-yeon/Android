# ⭐ 영화 별점 평가 앱 (Android Java)

이 앱은 사용자가 시청한 영화에 대해 별점(0.5점 단위, 최대 5점)을 매긴 후 "제출하기" 버튼을 누르면, 해당 별점을 Toast 메시지로 표시하는 간단한 **영화 평가 앱**입니다.

---

## ✅ 주요 기능

- **RatingBar**를 이용한 별점 평가 UI 제공 (0.5점 단위)
- 별점 선택 후 "제출하기" 버튼을 누르면, 선택한 별점을 Toast 메시지로 출력
- 사용자에게 친숙한 UI 구성 (텍스트, 별점, 버튼 중심)

---

## 🛠️ 개발 환경

- **언어**: Java  
- **IDE**: Android Studio 

---

## 📱 UI 구성

### 🔹 XML 레이아웃 (`res/layout/activity_main.xml`)
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:gravity="center">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="시청한 영화에 대한\n여러분의 평가를 기다립니다."
        android:textSize="24sp"
        android:textStyle="bold"
        android:gravity="center"
        android:paddingBottom="20dp"/>

    <RatingBar
        android:id="@+id/ratingBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:numStars="5"
        android:stepSize="0.5"
        android:rating="3.0"
        android:paddingBottom="20dp"/>

    <Button
        android:id="@+id/btnSubmit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="제출하기"/>
</LinearLayout>
```
```java
package com.example.scope;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML 요소 연결
        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);

        // 버튼 클릭 이벤트 처리
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                Toast.makeText(MainActivity.this, "별점: " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

