package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private Button btnAddTask, btnSelectDate, btnSelectTime;
    private ListView listViewTasks;

    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;

    private String selectedDate = "";
    private String selectedTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        btnAddTask = findViewById(R.id.btnAddTask);
        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnSelectTime = findViewById(R.id.btnSelectTime);
        listViewTasks = findViewById(R.id.listViewTasks);

        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter();
        listViewTasks.setAdapter(taskAdapter);

        // 날짜 선택 버튼 클릭
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

        // 시간 선택 버튼 클릭
        btnSelectTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, selectedHour, selectedMinute) -> {
                selectedTime = selectedHour + ":" + (selectedMinute < 10 ? "0" + selectedMinute : selectedMinute);
            }, hour, minute, true);
            timePickerDialog.show();
        });

        // 할 일 추가 버튼 클릭
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
    }

    private class TaskAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return taskList.size();
        }

        @Override
        public Object getItem(int position) {
            return taskList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.task_item, null);
            CheckBox checkBox = view.findViewById(R.id.checkBoxTask);
            Button btnDelete = view.findViewById(R.id.btnDelete);
            TextView textViewDateTime = view.findViewById(R.id.textViewDateTime);

            Task task = taskList.get(position);
            checkBox.setText(task.getTaskText());
            textViewDateTime.setText(task.getDate() + " " + task.getTime());

            checkBox.setChecked(false); // 초기 상태

            // 체크박스 스타일 적용
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

            // 삭제 버튼 클릭
            btnDelete.setOnClickListener(v -> {
                taskList.remove(position);
                notifyDataSetChanged();
            });

            return view;
        }
    }

    // 할 일 데이터 모델
    private class Task {
        private String taskText;
        private String date;
        private String time;

        public Task(String taskText, String date, String time) {
            this.taskText = taskText;
            this.date = date;
            this.time = time;
        }

        public String getTaskText() {
            return taskText;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }
    }
}
