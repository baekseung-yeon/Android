package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    EditText memoEdit;
    Button saveBtn, loadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        memoEdit = findViewById(R.id.memoEdit);
        saveBtn = findViewById(R.id.saveBtn);
        loadBtn = findViewById(R.id.loadBtn);

        saveBtn.setOnClickListener(v -> saveMemo());
        loadBtn.setOnClickListener(v -> loadMemo());
    }

    private void saveMemo() {
        String text = memoEdit.getText().toString();
        try (FileOutputStream fos = openFileOutput("memo.txt", MODE_PRIVATE)) {
            fos.write(text.getBytes());
            Toast.makeText(this, "저장 완료", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "저장 실패", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadMemo() {
        try (FileInputStream fis = openFileInput("memo.txt")) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while ((i = fis.read()) != -1) {
                baos.write(i);
            }
            memoEdit.setText(baos.toString());
            Toast.makeText(this, "불러오기 완료", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "불러오기 실패", Toast.LENGTH_SHORT).show();
        }
    }
}
