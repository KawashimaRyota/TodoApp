package com.example.todoapp;

import android.app.ActionBar;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * 新規ToDo追加フラグメント
 */
public class AddToDoFragment extends Fragment {

    /**
     * このフラグメントが所属するアクティビティオブジェクト
     */
    private Activity _parentActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //所属するアクティビティオブジェクトの取得
        _parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // フラグメントで使うレイアウトをxmlからインフレート
        View view = inflater.inflate(R.layout.fragment_add_to_do, container, false);
        return view;
    }

    public void onSaveButtonClick(View view) {
        EditText etTaskName = view.findViewById(R.id.etTaskName);
        String taskName = etTaskName.getText().toString();

        DatePicker dpLimit = view.findViewById(R.id.dpLimit);
        int day = dpLimit.getDayOfMonth();
        int month = dpLimit.getMonth();
        int year = dpLimit.getYear();

        EditText etMemo = view.findViewById(R.id.etMemo);
        String memo = etMemo.getText().toString();

        //データベースヘルパーオブジェクト生成
        DatabaseHelper helper = new DatabaseHelper(_parentActivity);
        //データベース接続オブジェクト取得
        SQLiteDatabase db = helper.getWritableDatabase();

        //＊＊＊＊＊＊実装中＊＊＊＊＊＊＊
    }
}