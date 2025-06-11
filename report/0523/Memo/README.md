# 📝 Android 메모 

## 📌 개요
간단한 메모장 앱으로, `EditText`에 입력한 텍스트를 내부 저장소에 저장하고 다시 불러올 수 있는 기능을 제공합니다.

---
## 🔐 내부 저장소란?

Android에서 앱의 **내부 저장소**는 외부에서 접근할 수 없는 앱 전용 저장 공간입니다.  
- 다른 앱은 해당 파일을 읽을 수 없으므로 **보안성이 높습니다.**
- 앱이 삭제되면 내부 저장소에 저장된 데이터도 함께 삭제됩니다.

---

## 📱 실행 화면 예시

- 앱 시작 시 이전 메모 자동 불러오기
- 입력 후 '저장' → 토스트 메시지 출력
- 앱 종료 후 다시 실행해도 메모 유지됨

---

## ✅ 요약

| 기능           | 설명                                     |
|----------------|------------------------------------------|
| 저장 기능       | 내부 저장소에 텍스트 저장 (`note.txt`)      |
| 불러오기 기능   | 앱 시작 시 자동으로 저장된 텍스트 로드       |
| UI 요소        | 제목, 입력창, 저장/불러오기 버튼 구성         |
| 사용자 편의성   | 텍스트 맨 위 자동 포커싱, 다크모드 대응       |

---

## 💡 주요 설명

| 항목            | 설명                                                         |
|-----------------|--------------------------------------------------------------|
| `EditText`       | 사용자가 메모를 입력하는 입력창                                 |
| `saveNote()`     | `note.txt` 파일에 메모 내용을 내부 저장소에 저장함              |
| `loadNote()`     | 앱 실행 시 `note.txt` 파일에서 저장된 메모 내용을 불러옴        |
| `Toast`          | 저장 또는 불러오기 작업 완료 메시지를 사용자에게 보여줌         |
| 내부 저장소 사용 | 앱 전용 저장소로, 다른 앱에서는 접근 불가능하여 보안성이 높음  |

---

## 🧠 핵심 기능

- 메모 내용 저장 (내부 저장소 `note.txt`)
- 앱 실행 시 자동 불러오기
- 저장 및 불러오기 버튼 UI 제공
- 다크모드 대비 흰 배경 + 검정 텍스트 설정
- 키보드 포커싱 최적화

---

## 📂 MainActivity.java

### 1. 변수 및 초기 설정
```java
private static final String FILE_NAME = "note.txt";
```
- 메모 내용이 저장될 파일 이름을 정의합니다.

### 2. `onCreate()` 메서드
- 레이아웃을 설정하고, `EditText`, `Button` 요소들을 찾아 연결합니다.
- 저장/불러오기 버튼에 클릭 리스너를 연결합니다.
- 앱 시작 시 자동으로 메모를 불러옵니다.
- 키보드가 올라왔을 때 자동으로 텍스트 맨 위에 포커싱되도록 처리합니다.

### 3. 메모 저장 함수
```java
private void saveNote() {
    ...
}
```
- 입력된 텍스트를 내부 저장소에 `note.txt` 파일로 저장합니다.
- 저장 성공/실패에 따라 토스트 메시지를 출력합니다.

### 4. 메모 불러오기 함수

```java
private void loadNote() {
    ...
}
```
- 내부 저장소에서 `note.txt` 파일을 읽고, 그 내용을 `EditText`에 설정합니다.
- 파일이 없거나 처음 실행인 경우 에러는 무시됩니다.

### 5. 포커싱 보정
```java
@Override
protected void onResume() {
    ...
}
```
- 앱 복귀 시에도 자동으로 입력창 맨 위에 포커싱하도록 처리합니다.

---

```java
package com.example.notepad;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText noteEditText;
    private Button saveButton;
    private Button loadButton;
    private static final String FILE_NAME = "note.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteEditText = findViewById(R.id.noteEditText);
        saveButton = findViewById(R.id.saveButton);
        loadButton = findViewById(R.id.loadButton);

        noteEditText.setTextColor(Color.BLACK);
        noteEditText.setHintTextColor(Color.GRAY);

        saveButton.setOnClickListener(v -> saveNote());
        loadButton.setOnClickListener(v -> loadNote());

        loadNote();

        noteEditText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                noteEditText.requestFocus();
                if (noteEditText.getText().length() > 0) {
                    noteEditText.setSelection(0);
                }
                noteEditText.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteEditText.post(() -> {
            noteEditText.requestFocus();
            if (noteEditText.getText().length() > 0) {
                noteEditText.setSelection(0);
            }
        });
    }

    private void saveNote() {
        String text = noteEditText.getText().toString();
        try (FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fos.write(text.getBytes());
            Toast.makeText(this, "메모가 저장되었습니다", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "저장 중 오류가 발생했습니다", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadNote() {
        try (FileInputStream fis = openFileInput(FILE_NAME);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            noteEditText.setText(sb.toString());
            noteEditText.setSelection(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 🧱 activity_main.xml

## 🎨 activity_main.xml 구성 설명

| 요소 ID          | 설명                                                                 |
|------------------|----------------------------------------------------------------------|
| `titleTextView`  | 상단 제목 "메모장"을 표시하는 TextView, 배경색은 짙은 회색, 글씨는 흰색 |
| `noteEditText`   | 사용자가 메모를 작성하는 입력창, 여러 줄 가능, 스크롤 가능              |
| `saveButton`     | 현재 입력된 메모를 내부 저장소에 저장하는 버튼                          |
| `loadButton`     | 저장된 메모를 불러오는 버튼      

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/white"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/titleTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/darker_gray"
        android:padding="16dp"
        android:text="메모장"
        android:textAlignment="center"
        android:textColor="@android:color/white"
        android:textSize="20sp"
        android:textStyle="bold"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

    <EditText
        android:id="@+id/noteEditText"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_margin="16dp"
        android:hint="메모를 입력하세요..."
        android:inputType="textMultiLine"
        android:gravity="top|start"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
        android:textColor="@android:color/black"
        android:textColorHint="@android:color/darker_gray"
        android:textSize="16sp"
        app:layout_constraintTop_toBottomOf="@id/titleTextView"
        app:layout_constraintBottom_toTopOf="@+id/saveButton"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

    <Button
        android:id="@+id/saveButton"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:text="저장"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/loadButton" />

    <Button
        android:id="@+id/loadButton"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:text="불러오기"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toEndOf="@+id/saveButton"
        app:layout_constraintEnd_toEndOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```


