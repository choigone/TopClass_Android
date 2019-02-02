package com.example.chloechoi.test.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chloechoi.test.R;

public class HeaderFragment extends Fragment {

    public int header_num;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // test용 임의 지정
        header_num = 1;

        switch (header_num){
            case 1:
                return inflater.inflate(R.layout.header_main, container, false);
            case 2:
                return inflater.inflate(R.layout.header_setting_notice, container, false);
            case 3:
                return inflater.inflate(R.layout.header_todolist_add, container, false);
            default:
                return inflater.inflate(R.layout.header_main, container, false);
        }
    }
}