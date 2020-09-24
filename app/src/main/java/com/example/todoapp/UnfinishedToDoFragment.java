package com.example.todoapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 未完了ToDoリストのフラグメント
 */
public class UnfinishedToDoFragment extends Fragment {

    /**
     * このフラグメントが所属するアクティビティオブジェクト
     */
    private Activity _parentActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //親クラスのonCreate()を呼び出し
        super.onCreate(savedInstanceState);
        //所属するアクティビティオブジェクトの取得
        _parentActivity = getActivity();
        //オプションメニューの有効化
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // フラグメントで使うレイアウトをxmlからインフレート
        View view = inflater.inflate(R.layout.fragment_unfinished_to_do, container, false);
        //オプションメニューの有効化
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.sort_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);

        //アクションバーのタイトルを変更
        _parentActivity.setTitle(R.string.title_unfinished);
    }
}