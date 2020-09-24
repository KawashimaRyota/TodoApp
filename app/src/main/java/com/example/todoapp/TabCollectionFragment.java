package com.example.todoapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * タブ切り替えの親フラグメント
 */
public class TabCollectionFragment extends Fragment {

    /**
     * このフラグメントが所属するアクティビティオブジェクト
     */
    Activity _parentActivity;

    ViewPager2 viewPager;
    ToDoFragmentStateAdapter toDoFragmentStateAdapter;

    int[] tabTitles = {
            R.drawable.ic_baseline_format_list_bulleted_24,
            R.drawable.ic_baseline_check_circle_24_black,
            R.drawable.ic_baseline_settings_24
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //親クラスのonCreate()を呼び出し
        super.onCreate(savedInstanceState);
        //所属するアクティビティオブジェクトの取得
        _parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // フラグメントで使うレイアウトをxmlからインフレート
        View view = inflater.inflate(R.layout.fragment_tab_collection, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toDoFragmentStateAdapter = new ToDoFragmentStateAdapter(this);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(toDoFragmentStateAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setIcon(tabTitles[position])).attach();
    }

    private class ToDoFragmentStateAdapter extends FragmentStateAdapter {

        public ToDoFragmentStateAdapter(Fragment fragment) {
            super(fragment);
        }

        @Override
        public Fragment createFragment(int position) {
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = new UnfinishedToDoFragment();
                    return fragment;
                case 1:
                    fragment = new FinishedToDoFragment();
                    return fragment;
                case 2:
                    fragment = new SettingFragment();
                    return fragment;
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}