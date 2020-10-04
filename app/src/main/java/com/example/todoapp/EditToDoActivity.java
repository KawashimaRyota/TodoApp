package com.example.todoapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class EditToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_todo);

        //戻るメニューの配置
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setTitle(R.string.title_edit_todo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 選択されたメニューのIDを取得
        int itemId = item.getItemId();
        //戻るボタンの処理
        if(itemId == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}