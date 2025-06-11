# App

---

## 프로젝트 개요

안드로이드 기본 UI와 화면 전환을 연습하기 위한 간단한 앱입니다.  
메인 화면에서 3개의 버튼(Introduction, Settings, Start)을 통해 각각 다른 화면으로 이동할 수 있도록 구성되어 있습니다.

---

## 주요 기능

## 📱 주요 기능

- **메인 화면 (`MainActivity`)**
  - 배경 이미지와 함께 세 개의 버튼 제공:
    - `INTRODUCTION`: 앱 소개 페이지로 이동
    - `SETTINGS`: 설정 페이지로 이동
    - `START`: 시작 페이지로 이동

- **소개 페이지 (`MainActivity2`)**
  - 텍스트 `"Introduction Page"` 표시

- **설정 페이지 (`MainActivity3`)**
  - 텍스트 `"Settings Page"` 표시

- **시작 페이지 (`MainActivity4`)**
  - 텍스트 `"Start Page"` 표시

---

## 화면 구성

| 화면명           | 액티비티 클래스           | 레이아웃 파일               | 설명                          |
|------------------|--------------------------|----------------------------|-------------------------------|
| MainActivity     | `MainActivity.java`       | `activity_main.xml`         | 배경 이미지 + 3개의 버튼 구성  |
| Introduction     | `MainActivity2.java`| `activity_main2.xml` | 소개 페이지, 텍스트 출력       |
| Settings         | `MainActivity3.java`    | `activity_main3.xml`     | 설정 페이지, 텍스트 출력       |
| Start            | `MainActivity4.java`       | `activity_main4.xml`        | 시작 페이지, 텍스트 출력       |

---

## 주요 코드 설명

### activity_main.xml

- `FrameLayout`을 사용해 배경 이미지(`ImageView`)를 전체 화면에 배치  
- 그 위에 `LinearLayout`으로 3개의 버튼을 수직 정렬하여 배치  
- 각 버튼에 ID 부여하여 클릭 이벤트 처리 가능

```xml
<!-- 배경 이미지 -->
<ImageView
    android:id="@+id/mainImage"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:scaleType="centerCrop"
    android:src="@drawable/background" />

<!-- 버튼 3개 수직 배치 -->
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:gravity="center"
    android:layout_marginTop="100dp">
    
    <Button
        android:id="@+id/btnIntroduction"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="INTRODUCTION"
        android:layout_margin="8dp"/>
        
    <Button
        android:id="@+id/btnSettings"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="SETTINGS"
        android:layout_margin="8dp"/>
        
    <Button
        android:id="@+id/btnStart"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="START"
        android:layout_margin="8dp"/>
</LinearLayout>
```

### MainActivity.java

- 각 버튼 클릭 시 해당 액티비티로 이동하는 인텐트 처리
- findViewById로 버튼 연결 후 setOnClickListener 설정

```java
btnIntroduction.setOnClickListener(v ->
    startActivity(new Intent(this, MainActivity2.class))
);

btnSettings.setOnClickListener(v ->
    startActivity(new Intent(this, MainActivity3.class))
);

btnStart.setOnClickListener(v ->
    startActivity(new Intent(this, MainActivity4.class))
);
```

### 각 기능 화면 액티비티

- 각 액티비티는 AppCompatActivity를 상속받아 onCreate에서 해당 레이아웃을 호출
- 예시 텍스트(TextView)를 중앙에 표시

### AndroidManifest.xml

- 앱 패키지명: com.example.codingchallenge
- 메인 액티비티에 LAUNCHER 인텐트 필터 설정
- 각 액티비티 선언 포함

```xml
<activity android:name=".MainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN"/>
        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
</activity>

<activity android:name=".MainActivity2" />
<activity android:name=".MainActivity3" />
<activity android:name=".MainActivity4" />
```

