# ❄️ Snowy Scene Android App

눈이 내리는 장면을 `SurfaceView`로 구현한 안드로이드 앱입니다. 배경 이미지 위에 여러 개의 눈송이가 떨어지는 애니메이션을 실시간으로 렌더링합니다.

---

## 📁 구성 파일

### 1. `MainActivity.java`

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 레이아웃에 SnowView 포함
    }
}
```
- SnowView라는 커스텀 뷰를 화면에 표시하는 역할만 수행합니다.

---

### 2. `SnowView.java`
```java
public class SnowView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    ...
}
```
### 핵심 역할

- SurfaceView를 상속받아 별도의 쓰레드에서 그림을 반복적으로 그립니다.
- 눈송이 100개를 생성하고, 매 프레임마다 위치를 업데이트해 아래로 떨어지게 만듭니다.
- drawScene() 메서드에서 배경 이미지와 눈송이를 그림.

### 주요 메서드

- surfaceCreated: 뷰가 준비되면 눈송이 초기화 및 쓰레드 시작
- run: 60fps 속도로 반복적으로 drawScene() 호출
- drawScene: 배경과 눈을 Canvas에 그림
- surfaceDestroyed: 쓰레드 종료 처리

--- 

### 3. `Snowflake.java`
```java
public class Snowflake {
    public float x, y, radius, speedY;

    public Snowflake(float x, float y, float radius, float speedY) {
        ...
    }

    public void update(float screenHeight) {
        y += speedY;
        if (y > screenHeight) {
            y = 0;
            x = (float)(Math.random() * 1080);
        }
    }
}

```
- 각 눈송이의 위치, 반지름, 속도를 관리합니다.
- 아래로 떨어지다가 화면을 벗어나면 위로 재배치됩니다.

---

### 4. `activity_main.xml`
```xml
<RelativeLayout>
    <com.example.snowyscene.SnowView
        android:id="@+id/snowView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</RelativeLayout>
- /res/drawable/snow.png 또는 snow.jpg
  - 눈 내리는 배경 이미지가 필요
  - 코드에서 BitmapFactory.decodeResource(getResources(), R.drawable.snow)로 로드됩니다.
```
---

## 실행 결과 
- 눈 내리는 애니메이션이 전체 화면에 실시간으로 그려집니다. 
- 눈송이는 랜덤한 크기, 속도로 떨어집니다.
- 성능을 위해 SurfaceView를 사용하고, 60fps에 맞춰 Thread.sleep(16)을 사용합니다.





