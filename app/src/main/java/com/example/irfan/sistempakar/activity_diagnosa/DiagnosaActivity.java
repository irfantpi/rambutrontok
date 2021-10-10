package com.example.irfan.sistempakar.activity_diagnosa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.irfan.sistempakar.R;

public class DiagnosaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa);

        Bundle bundle = getIntent().getExtras();
        int layoutDiagnosa = bundle.getInt("layout_diagnosa");

        if(layoutDiagnosa == 2){
            setFragment(new DiagnosaFragment(), 0);
        }else if(layoutDiagnosa == 3){
            int id_user = bundle.getInt("id_user_diagnosa");
            setFragment(new ResultFragment(), id_user);
        }else{
            setFragment(new DataDiriFragment(), 0);
        }
    }

    public void setFragment(Fragment fragment, int idUser){
        if(idUser != 0){
            Bundle bundle = new Bundle();
            bundle.putInt("id_user", idUser);
            fragment.setArguments(bundle);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_diagnosa, fragment).commit();
    }
}