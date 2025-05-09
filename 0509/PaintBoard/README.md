<h1>🎨그림판 앱</h1>

<p>이 앱은 <strong>안드로이드</strong>로 구현된 <strong>간단한 그림판 앱</strong>입니다. 사용자는 펜 색상, 굵기 조절, 지우개 등을 사용하여 그림을 그릴 수 있습니다. 기본적인 그림 그리기, 색상 변경, 지우개 기능 외에도 초기화 버튼을 통해 그림을 초기화할 수 있습니다.</p>

<h2>📌기능</h2>
<ul>
    <li><strong>펜 색상 변경</strong>: 검정, 빨강, 파랑 색상 선택</li>
    <li><strong>펜 굵기 조절</strong>: <strong>SeekBar</strong>를 사용하여 펜 굵기를 실시간으로 조정할 수 있습니다.</li>
    <li><strong>지우개 기능</strong>: 지우개 버튼을 클릭하여 지우개 모드로 전환하고, 원하는 부분을 지울 수 있습니다.</li>
    <li><strong>초기화 버튼</strong>: 그린 그림을 초기화하여 새로 시작할 수 있습니다.</li>
</ul>

<h2>📌사용 방법</h2>
<ol>
    <li>앱을 실행하면 화면에 나타나는 <strong>펜 색상 버튼</strong>을 클릭하여 원하는 색상(검정, 빨강, 파랑)을 선택합니다.</li>
    <li><strong>SeekBar</strong>를 사용하여 펜의 굵기를 조정할 수 있습니다.</li>
    <li><strong>지우개 버튼</strong>을 클릭하여 지우개 모드로 변경하고 그림을 지울 수 있습니다.</li>
    <li><strong>초기화 버튼</strong>을 클릭하여 그린 모든 그림을 지우고 새로 시작할 수 있습니다.</li>
</ol>

<h2>📌파일 구조</h2>

 >/app
 > > src
 > > > /main
 > > > > /java
 > > > > > /com
 > > > > > > /example
 > > > > > > > /myapplication
 > > > > > > > > DrawingView.java        
 > > > > > > > > MainActivity.java       
 > > > > > > > /res
 > > > > > > > > > /layout
 > > > > > > > > > >activity_main.xml
------------
### 🎨색상 선택 버튼
#### xml
``` xml
<Button
    android:id="@+id/btnBlack"
    android:text="검정" />
<Button
    android:id="@+id/btnRed"
    android:text="빨강" />
<Button
    android:id="@+id/btnBlue"
    android:text="파랑" />
```
#### java
``` java
// 색상 버튼 클릭 리스너 처리
Button btnBlack = findViewById(R.id.btnBlack);
Button btnRed = findViewById(R.id.btnRed);
Button btnBlue = findViewById(R.id.btnBlue);

btnBlack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        drawingView.setPenColor(Color.BLACK);  // 검정색 설정
    }
});

btnRed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        drawingView.setPenColor(Color.RED);    // 빨간색 설정
    }
});

btnBlue.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        drawingView.setPenColor(Color.BLUE);   // 파란색 설정
    }
});

```
------------
### 🧽지우개 버튼
#### xml
``` xml
<Button
    android:id="@+id/btnEraser"
    android:text="지우개" />
```
#### java
``` java
// 지우개 버튼 클릭 리스너 처리
Button btnEraser = findViewById(R.id.btnEraser);
btnEraser.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        drawingView.setEraserMode(true);  // 지우개 모드 활성화
    }
});
```
#### DrawingView.java
``` java
public void setEraserMode(boolean eraserMode) {
    if (eraserMode) {
        paint.setColor(Color.WHITE);  // 지우개 모드일 때 색을 흰색으로 설정
        paint.setStrokeWidth(30);     // 지우개 크기 설정
    } else {
        paint.setColor(penColor);     // 기존 펜 색상 복구
        paint.setStrokeWidth(penSize); // 기존 펜 크기 복구
    }
}
```
------------
### 🗑️초기화 버튼
#### xml
``` xml
<Button
    android:id="@+id/btnClear"
    android:text="초기화" />
```
#### java
``` java
// 초기화 버튼 클릭 리스너 처리
Button btnClear = findViewById(R.id.btnClear);
btnClear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        drawingView.clearDrawing();  // 그리기 초기화
    }
});
```
#### DrawingView.java
``` java
public void clearDrawing() {
    path.reset();  // 경로 초기화
    invalidate();  // 화면 갱신
}
```
------------
### 🖊️🖊펜 굵기 조정 
#### xml
``` xml
<SeekBar
    android:id="@+id/brushSizeSeekBar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="100"
    android:progress="10" />
```
#### java
``` java
// SeekBar 리스너 추가
SeekBar brushSizeSeekBar = findViewById(R.id.brushSizeSeekBar);
brushSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        drawingView.setPenSize(progress);  // 펜 굵기 설정
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
});
```
#### DrawingView.java
``` java
public void setPenSize(float size) {
    penSize = size;
    paint.setStrokeWidth(penSize);  // 펜 굵기 적용
    invalidate();  // 화면 갱신
}
```
