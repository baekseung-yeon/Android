# 📝 To-Do List(CheckList)

이 프로젝트는 간단한 **할 일 목록(To-Do List)** 안드로이드 앱입니다. 사용자는 할 일을 입력하고 버튼을 눌러 목록에 추가할 수 있으며, 추가된 항목은 체크박스로 표시됩니다.

## 📱 주요 기능

- 할 일 입력창 제공
- `추가하기` 버튼으로 할 일을 리스트에 추가
- `ListView`에 할 일 목록이 체크박스 형태로 표시
- 여러 항목을 동시에 선택 가능

## 🧩 UI 구성 (activity_main.xml)

```xml
<EditText />     // 할 일 입력란
<Button />       // 추가 버튼
<ListView />     // 체크박스 형태의 할 일 목록
```
## 🧠 주요 코드 설명 (MainActivity.java)

- ArrayList<String> tasks : 할 일 데이터를 저장
- ArrayAdapter<String> adapter : 리스트에 데이터를 표시하는 어댑터
- ListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE) : 다중 선택 가능한 체크박스 모드 설정
- 버튼 클릭 시 입력값을 리스트에 추가하고 화면 갱신
  
```java
EditText etTask;
Button btnAdd;
ListView listView;
ArrayList<String> tasks;
ArrayAdapter<String> adapter;
```
## 🧠 동작 설명

##1. 초기화 
- ArrayList<String>를 이용해 할 일 목록을 저장
- ArrayAdapter로 리스트뷰에 데이터 연결
- 리스트뷰는 CHOICE_MODE_MULTIPLE로 설정하여 여러 항목 체크 가능

  ##2. 버튼 클릭 시
- 입력창(etTask)에 내용이 있을 경우:
  - tasks 리스트에 추가
  - notifyDataSetChanged()로 리스트뷰 업데이트
  - 
```java
 btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String newTask = etTask.getText().toString().trim();
        if (!newTask.isEmpty()) {
            tasks.add(newTask);
            adapter.notifyDataSetChanged();
            etTask.setText("");
        }
    }
});
```
