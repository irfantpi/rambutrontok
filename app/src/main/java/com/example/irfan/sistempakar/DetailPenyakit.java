package com.example.irfan.sistempakar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irfan.sistempakar.adapter.GejalaListAdapter;
import com.example.irfan.sistempakar.adapter.PenyakitAdapter;
import com.example.irfan.sistempakar.adapter.SolusiListAdapter;
import com.example.irfan.sistempakar.helper.DBHelper;
import com.example.irfan.sistempakar.model.Gejala;
import com.example.irfan.sistempakar.model.Penyakit;
import com.example.irfan.sistempakar.model.Solusi;

import java.util.ArrayList;

public class DetailPenyakit extends AppCompatActivity {

    LinearLayout imagePenyakit;
    ImageView btnBackPenyakit;
    TextView tvNama, tvDetail;
    RecyclerView rvListGejala, rvListSolusi;

    Penyakit penyakit;
    ArrayList<Gejala> gejala;
    ArrayList<Solusi> solusi;

    DBHelper dbHelper;

    GejalaListAdapter gejalaListAdapter;
    SolusiListAdapter solusiListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        imagePenyakit = findViewById(R.id.image_penyakit_detail);
        btnBackPenyakit = findViewById(R.id.btn_back_detail_penyakit);
        tvNama = findViewById(R.id.nama_penyakit_detail);
        tvDetail = findViewById(R.id.deskripsi_penyakit_detail);
        rvListGejala = findViewById(R.id.rv_list_gejala);
        rvListSolusi = findViewById(R.id.rv_list_solusi);

        Bundle bundle = getIntent().getExtras();
        int idPenyakit = bundle.getInt("id_penyakit");

        dbHelper = new DBHelper(getApplicationContext());
        penyakit = dbHelper.getRecordPenyakit(idPenyakit);

        gejala = dbHelper.getGejala(idPenyakit);
        gejalaListAdapter = new GejalaListAdapter(gejala, getApplicationContext());
        rvListGejala.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListGejala.setAdapter(gejalaListAdapter);

        solusi = dbHelper.getSolusi(idPenyakit);
        solusiListAdapter = new SolusiListAdapter(solusi, getApplicationContext());
        rvListSolusi.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListSolusi.setAdapter(solusiListAdapter);

        Resources res = getApplication().getResources();
        int resID = res.getIdentifier(penyakit.getImagePenyakit() , "drawable", getApplication().getPackageName());
        Drawable drawable = res.getDrawable(resID );
        imagePenyakit.setBackground(drawable);
        tvNama.setText(penyakit.getNamaPenyakit());
        tvDetail.setText(penyakit.getDefinisiPenyakit());

        btnBackPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PengenalanPenyakit.class);
                startActivity(intent);
            }
        });
    }

}