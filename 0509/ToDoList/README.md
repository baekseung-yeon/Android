# 할 일 목록 앱 (To-Do List App)

이 앱은 사용자가 할 일을 추가하고, 각 할 일에 날짜와 시간을 설정할 수 있도록 도와주는 간단한 투두 리스트 애플리케이션입니다. 사용자는 할 일을 추가하고, 할 일이 완료되면 체크박스를 선택하여 완료 상태로 변경할 수 있습니다. 또한 각 항목은 삭제할 수 있습니다.

## 기능

- **할 일 추가**: 텍스트 입력란에 할 일을 작성하고 추가 버튼을 눌러 할 일을 목록에 추가할 수 있습니다.
- **날짜 선택**: 버튼을 클릭하여 날짜를 선택하고 할 일에 날짜를 추가할 수 있습니다.
- **시간 선택**: 버튼을 클릭하여 시간을 선택하고 할 일에 시간을 추가할 수 있습니다.
- **완료된 할 일 표시**: 체크박스를 클릭하면 할 일이 완료된 것으로 표시됩니다. 체크된 할 일은 글씨가 회색으로 바뀌고 가운데에 선이 그어집니다.
- **할 일 삭제**: 할 일 항목 옆에 있는 "❌" 버튼을 클릭하여 해당 할 일을 삭제할 수 있습니다.

## 사용 방법

1. **할 일 입력**: 화면 상단의 텍스트 입력란에 할 일을 입력합니다.
2. **날짜 선택**: 날짜 선택 버튼을 눌러 날짜를 설정합니다.
3. **시간 선택**: 시간 선택 버튼을 눌러 시간을 설정합니다.
4. **할 일 추가**: "추가하기" 버튼을 눌러 할 일을 목록에 추가합니다.
5. **완료 상태로 표시**: 할 일 항목 옆의 체크박스를 클릭하여 할 일을 완료 상태로 표시합니다.
6. **할 일 삭제**: 할 일 항목 옆의 "❌" 버튼을 클릭하여 해당 할 일을 삭제합니다.

## UI 구성

- **텍스트 입력란**: 사용자가 할 일을 입력할 수 있는 필드입니다.
- **날짜 선택 버튼**: 날짜를 선택할 수 있는 버튼입니다.
- **시간 선택 버튼**: 시간을 선택할 수 있는 버튼입니다.
- **할 일 추가 버튼**: 사용자가 입력한 할 일을 목록에 추가하는 버튼입니다.
- **체크박스**: 할 일이 완료되었을 때 체크하는 기능을 합니다. 체크된 항목은 글씨가 회색으로 바뀌며, 글자에 선이 그어집니다.
- **삭제 버튼**: 각 할 일 항목을 삭제하는 버튼입니다.

## 코드 설명

### 날짜 선택 

```java
btnSelectDate.setOnClickListener(v -> {
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
        selectedDate = selectedYear + "/" + (selectedMonth + 1) + "/" + selectedDay;
    }, year, month, day);
    datePickerDialog.show();
});

```

### 시간 선택 

```java
btnSelectTime.setOnClickListener(v -> {
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);

    TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, selectedHour, selectedMinute) -> {
        selectedTime = selectedHour + ":" + (selectedMinute < 10 ? "0" + selectedMinute : selectedMinute);
    }, hour, minute, true);
    timePickerDialog.show();
});
```

### 리스트 추가 

```java
btnAddTask.setOnClickListener(v -> {
    String task = editTextTask.getText().toString().trim();
    if (!task.isEmpty()) {
        taskList.add(new Task(task, selectedDate, selectedTime));
        taskAdapter.notifyDataSetChanged();
        editTextTask.setText("");
        selectedDate = "";
        selectedTime = "";
    }
});
```

### 리스트 체크박스

```java
checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
    if (isChecked) {
        checkBox.setPaintFlags(checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        checkBox.setTextColor(Color.GRAY);
        checkBox.setEnabled(false); // 체크 후 비활성화
    } else {
        checkBox.setPaintFlags(checkBox.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        checkBox.setTextColor(Color.BLACK);
    }
});
```

### 리스트 삭제

```java
btnDelete.setOnClickListener(v -> {
    taskList.remove(position);
    notifyDataSetChanged();
});
```
