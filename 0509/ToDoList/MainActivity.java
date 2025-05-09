package com.example.myapplication;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private Button btnAddTask;
    private ListView listViewTasks;

    private ArrayList<String> taskList;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        btnAddTask = findViewById(R.id.btnAddTask);
        listViewTasks = findViewById(R.id.listViewTasks);

        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter();
        listViewTasks.setAdapter(taskAdapter);

        btnAddTask.setOnClickListener(v -> {
            String task = editTextTask.getText().toString().trim();
            if (!task.isEmpty()) {
                taskList.add(task);
                taskAdapter.notifyDataSetChanged();
                editTextTask.setText("");
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

            String taskText = taskList.get(position);
            checkBox.setText(taskText);
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
}
