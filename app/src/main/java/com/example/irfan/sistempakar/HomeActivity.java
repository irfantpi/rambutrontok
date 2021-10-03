package com.example.irfan.sistempakar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irfan.sistempakar.activity_diagnosa.DiagnosaActivity;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout menuDiagnosa, menuHistory, menuPengenalan, menuTentang;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        menuDiagnosa = findViewById(R.id.diagnosa_menu);
        menuHistory = findViewById(R.id.history_diagnosa_menu);
        menuPengenalan = findViewById(R.id.pengenalan_penyakit_menu);
        menuTentang = findViewById(R.id.tentang_menu);

        menuDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Diagnosa Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DiagnosaActivity.class);
                startActivity(intent);
            }
        });

        menuHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "History Menu", Toast.LENGTH_SHORT).show();
            }
        });

        menuPengenalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Pengenalan Penyakit Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), PengenalanPenyakit.class);
                startActivity(intent);
            }
        });

        menuTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Tentang Menu", Toast.LENGTH_SHORT).show();
            }
        });

    }

}