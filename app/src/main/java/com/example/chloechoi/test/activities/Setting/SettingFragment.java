package com.example.chloechoi.test.activities.Setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;
import com.example.chloechoi.test.R;



public class SettingFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    RelativeLayout profilelayout;
    RelativeLayout themelayout;

    Switch alarmswitch;

    FragmentManager fm;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_setting, container, false);


        fm = getFragmentManager();

        profilelayout = view.findViewById(R.id.setting_profile_layout);
        //profilelayout.setOnClickListener(this);

        themelayout = view.findViewById(R.id.setting_theme_layout);
        themelayout.setOnClickListener((View.OnClickListener) getActivity());

        alarmswitch = view.findViewById(R.id.setting_alarm_switch);
        alarmswitch.setOnCheckedChangeListener(this);



        return view;

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fm.beginTransaction();

        if(v == profilelayout){  //학번 및 비밀번호 수정 시  -> SettiingProfileFragment 로 교체
            fragmentTransaction.replace(R.id.main_header, new SettingHeaderFragment());
            fragmentTransaction.replace(R.id.main_body, new SettingProfileFragment());
            fragmentTransaction.commit();

        }else if(v==themelayout){  //테마 수정 시 -> SettingThemeFragment 로 교체
            fragmentTransaction.replace(R.id.main_body, new SettingThemeFragment());
            fragmentTransaction.commit();
        }

    }


    //--------------------알람 on off----------------------
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked == true){
            //alarm on
            Toast.makeText(this.getContext(),"alarm on",Toast.LENGTH_SHORT).show();

        }else if(isChecked == false){
            //alarm off
            Toast.makeText(this.getContext(),"alarm off",Toast.LENGTH_SHORT).show();
        }
    }
}
