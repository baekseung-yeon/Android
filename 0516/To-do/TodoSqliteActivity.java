package com.example.myapplication;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TodoSqliteActivity extends AppCompatActivity {

    EditText todoEditText;
    Button addButton;
    ListView todoListView;
    TodoDatabaseHelper dbHelper;
    ArrayAdapter<String> adapter;
    ArrayList<String> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_sqlite);

        todoEditText = findViewById(R.id.todoEditText);
        addButton = findViewById(R.id.addButton);
        todoListView = findViewById(R.id.todoListView);

        dbHelper = new TodoDatabaseHelper(this);
        todoList = dbHelper.getAllTodos();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);
        todoListView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            String task = todoEditText.getText().toString().trim();
            if (!task.isEmpty()) {
                dbHelper.insertTodo(task);
                todoEditText.setText("");
                refreshList();
            }
        });

        todoListView.setOnItemClickListener((parent, view, position, id) -> {
            String task = todoList.get(position);
            dbHelper.deleteTodo(task);
            refreshList();
        });
    }

    private void refreshList() {
        todoList.clear();
        todoList.addAll(dbHelper.getAllTodos());
        adapter.notifyDataSetChanged();
    }
}
