# Android 메모장 앱 (파일 저장/불러오기)

이 앱은 안드로이드 내부 저장소를 사용하여 텍스트 메모를 **파일로 저장**하고, 다시 **불러올 수 있는** 간단한 메모장 기능을 제공합니다.

## 📱 주요 기능

- 메모 입력 (EditText)
- 메모 저장 (내부 저장소에 memo.txt 파일로 저장)
- 메모 불러오기 (저장된 memo.txt 내용을 화면에 표시)

## 📂 파일 구조

MyApplication/
├── java/com/example/myapplication/
│ └── MainActivity.java # 메모장 기능 구현
├── res/layout/
│ └── activity_memo.xml # 메모장 레이아웃
├── AndroidManifest.xml # MemoActivity 등록

## 📸 화면 구성

- EditText: 메모 입력 창 (멀티라인 지원)
- Button 1: "저장" → 입력한 메모를 내부 저장소에 저장
- Button 2: "불러오기" → 저장된 메모를 불러와서 화면에 표시

## 📦 주요 코드 설명

### 메모 저장

```java
FileOutputStream fos = openFileOutput("memo.txt", MODE_PRIVATE);
fos.write(text.getBytes());

MODE_PRIVATE: 앱 내부 전용으로 저장

FileInputStream fis = openFileInput("memo.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(fis));
```

## 사용 방법

앱 실행 <br>
👇 <br>
메모 입력 <br>
👇 <br>
저장 버튼 클릭 → 내부 저장소에 memo.txt 저장 <br>
👇 <br>
불러오기 버튼 클릭 → memo.txt 내용을 EditText에 표시 <br>
