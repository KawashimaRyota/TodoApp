package com.example.todoapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AddTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        //戻るメニューの配置
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //タイトル変更
        setTitle(R.string.title_add_todo);
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