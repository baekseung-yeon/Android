# ✅ SQLite 기반 To-Do 리스트 앱

## 📌 개요
이 앱은 Android의 **SQLite 데이터베이스**를 활용하여 할 일을 추가하고 삭제할 수 있는 **간단한 To-Do 리스트 앱**입니다.  
할 일 목록은 앱을 종료해도 데이터베이스에 저장되어 유지되며, 체크(완료)하면 자동으로 삭제됩니다.

---

## 🗂️ 구성 파일

| 파일명                       | 역할 설명                          |
|----------------------------|----------------------------------|
| `MainActivity.java`        | 메인 UI 및 기능 컨트롤러              |
| `TaskDBHelper.java`        | SQLite 데이터베이스 헬퍼 클래스       |
| `activity_main.xml`        | 앱의 메인 화면 레이아웃              |
| `task_item.xml`            | RecyclerView의 할 일 항목 레이아웃     |

---

## 🧠 핵심 기능

- 할 일 추가 (`EditText` + `ImageButton`)
- 할 일 목록 표시 (`RecyclerView`)
- SQLite에 항목 저장 (`TaskDBHelper`)
- 체크하면 삭제 처리 및 DB에서도 제거
- 데이터는 앱을 종료해도 유지됨

---

## 🧱 TaskDBHelper.java 설명

### ✅ 역할: SQLite 데이터베이스를 생성하고 조작

```java
public class TaskDBHelper extends SQLiteOpenHelper
```

- `tasks.db`라는 SQLite DB 파일을 생성하며, 테이블 구조는 다음과 같음:

| 컬럼명        | 타입     | 설명              |
|---------------|----------|-------------------|
| `_id`         | INTEGER  | 자동 증가 기본 키   |
| `task_text`   | TEXT     | 할 일 내용         |
| `checked`     | INTEGER  | 완료 여부 (0 또는 1) |

### 주요 메서드

- `onCreate()`: 테이블 생성
- `insertTask(String text)`: 할 일 추가
- `getAllTasks()`: 전체 항목 조회 (ArrayList 반환)
- `deleteTask(String text)`: 텍스트 기준 항목 삭제

---

## 🧩 MainActivity.java 설명

### 🏗️ 주요 멤버

```java
private TaskDBHelper dbHelper;
private ArrayList<TaskItem> taskList;
private TaskAdapter taskAdapter;
```

- `TaskDBHelper`를 통해 DB 연결
- 저장된 할 일 목록을 불러와 `RecyclerView`로 출력

### 📝 할 일 추가 처리

```java
imageButton.setOnClickListener(v -> {
    ...
    dbHelper.insertTask(taskText);
    ...
});
```

- 입력한 텍스트가 비어 있지 않으면 DB에 저장하고 리스트에 추가함

### ✅ 할 일 항목 클래스

```java
public static class TaskItem {
    String taskText;
    boolean isChecked;
}
```

- 각 할 일 항목의 텍스트와 체크 상태를 표현

---

## 📦 RecyclerView 어댑터 설명 (TaskAdapter)

### 기능 요약
- 항목 레이아웃은 `task_item.xml`을 사용
- 체크박스(RadioButton)를 체크하면 항목 제거
- 제거 시 DB에서도 같이 삭제 처리

### 핵심 코드

```java
holder.radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
    if (isChecked) {
        dbHelper.deleteTask(task.taskText); // DB 삭제
        taskList.remove(position);          // 리스트 삭제
        notifyItemRemoved(position);        // UI 갱신
    }
});
```

---

## 🧱 activity_main.xml 구성

### 🧭 레이아웃 구성

| 구성 요소           | 설명                                |
|---------------------|-------------------------------------|
| `RecyclerView`      | 전체 할 일 목록 표시                   |
| `EditText`          | 새 할 일을 입력하는 입력 필드            |
| `ImageButton`       | 입력한 내용을 할 일로 추가하는 버튼       |
| `LinearLayout`      | 입력 필드와 버튼을 묶는 하단 고정 레이아웃 |

### 주요 속성

- `RecyclerView`는 화면 상단 전체를 차지하고,
- 하단에 고정된 `LinearLayout`은 할 일 추가 UI를 담당

---

## 📑 task_item.xml 설명

- 각 할 일 항목은 `RadioButton + TextView`로 구성됨

| 뷰 ID         | 설명              |
|---------------|-------------------|
| `radioButton` | 체크 여부 표시      |
| `taskText`    | 할 일 텍스트 내용   |

```xml
<RadioButton android:id="@+id/radioButton" ... />
<TextView android:id="@+id/taskText" ... />
```

---

## 💡 SQLite 사용 요약

| 기능           | 구현 방법                      |
|----------------|-------------------------------|
| 저장           | `db.insert()` 사용              |
| 불러오기       | `Cursor`를 이용한 `db.query()`  |
| 삭제           | `db.delete()` 사용              |
| 데이터 유지     | SQLite DB는 앱 종료 후에도 유지됨 |

---

## 🧪 실행 흐름

1. 앱 실행 시 DB에서 모든 할 일을 불러옴
2. 사용자가 텍스트 입력 후 추가 버튼 클릭 시 DB에 저장됨
3. RecyclerView에 항목이 실시간으로 갱신됨
4. 항목을 체크하면 DB와 화면 모두에서 삭제됨

---

## ✅ 마무리

이 앱은 Android에서 SQLite를 사용하는 가장 기본적인 예제입니다.  
데이터의 저장, 조회, 삭제 등 핵심 DB 연산을 `SQLiteOpenHelper`를 통해 처리하며,  
UI와 데이터가 연결되는 구조(RecyclerView + Adapter)를 잘 보여줍니다.

