package com.example.irfan.sistempakar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.irfan.sistempakar.adapter.PenyakitAdapter;
import com.example.irfan.sistempakar.helper.DBHelper;
import com.example.irfan.sistempakar.model.Penyakit;

import java.util.ArrayList;

public class PengenalanPenyakit extends AppCompatActivity {

    RecyclerView rvPenyakit;
    DBHelper dbHelper;
    ArrayList<Penyakit> getPenyakit = new ArrayList<>();
    PenyakitAdapter penyakitAdapter;
    ImageView iconBack;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan_penyakit);

        rvPenyakit = findViewById(R.id.rv_penyakit);
        iconBack = findViewById(R.id.btn_back_penyakit);

        getAllData();

        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getAllData(){
        dbHelper = new DBHelper(getApplicationContext());

        getPenyakit = dbHelper.getAllPenyakit();
        penyakitAdapter = new PenyakitAdapter(getPenyakit, getApplicationContext());
        rvPenyakit.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvPenyakit.setAdapter(penyakitAdapter);
    }

}