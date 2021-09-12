package com.example.irfan.sistempakar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.irfan.sistempakar.adapter.PenyakitAdapter;
import com.example.irfan.sistempakar.helper.DBHelper;
import com.example.irfan.sistempakar.model.Penyakit;

import java.util.ArrayList;

public class PengenalanPenyakit extends AppCompatActivity {

    RecyclerView rvPenyakit;
    DBHelper dbHelper;
    ArrayList<Penyakit> getPenyakit = new ArrayList<>();
    PenyakitAdapter penyakitAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan_penyakit);

        rvPenyakit = findViewById(R.id.rv_penyakit);

        dbHelper = new DBHelper(getApplicationContext());

        getPenyakit = dbHelper.getAllPenyakit();
        penyakitAdapter = new PenyakitAdapter(getPenyakit, getApplicationContext());
        rvPenyakit.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvPenyakit.setAdapter(penyakitAdapter);
    }

}