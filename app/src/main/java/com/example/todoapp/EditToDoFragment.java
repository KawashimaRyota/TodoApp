package com.example.todoapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ToDo編集画面のフラグメント
 */
public class EditToDoFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_edit_to_do, container, false);
        return view;
    }

    @Override
    public void onResume() {
        //アクションバーのタイトルを変更
        _parentActivity.setTitle(R.string.title_edit_todo);
        super.onResume();
    }
}