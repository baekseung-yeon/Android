# 🖼️ 이미지 레이아웃

이 예제는 Android 앱에서 `ImageView`를 사용해 이미지를 표시하고, Java 코드로 동적으로 이미지를 설정하는 기본적인 방법을 보여줍니다.  
앱에서 로고, 사진, 아이콘 등을 표시할 때 활용할 수 있는 실용적인 예제입니다.

---

## ✅ 기능 요약

- XML에서 `ImageView`를 정의하고 이미지를 지정
- Java 코드에서 `findViewById`로 `ImageView`를 연결
- `setImageResource()`를 통해 이미지 리소스를 동적으로 변경

---

## 🛠️ 개발 환경

- **언어**: Java  
- **IDE**: Android Studio 

---

## 📂 리소스 구성

res/<nbr>
 └── drawable/<nbr>
      └── example_image.png<nbr>

---

## 🧩 레이아웃 코드 (`res/layout/activity_main.xml`)

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical"
    android:padding="16dp">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/example_image"
        android:contentDescription="img_android_png"/>
</LinearLayout>
```
```java
package com.example.myapp;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML에 선언된 ImageView와 연결
        imageView = findViewById(R.id.imageView);

        // 동적으로 이미지 리소스 변경
        imageView.setImageResource(R.drawable.example_image);
    }
}
```
