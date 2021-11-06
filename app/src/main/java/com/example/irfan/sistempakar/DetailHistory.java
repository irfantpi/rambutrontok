package com.example.irfan.sistempakar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irfan.sistempakar.adapter.SolusiListAdapter;
import com.example.irfan.sistempakar.helper.DBHelper;
import com.example.irfan.sistempakar.model.DiagnosaModel;
import com.example.irfan.sistempakar.model.Penyakit;
import com.example.irfan.sistempakar.model.Solusi;
import com.example.irfan.sistempakar.model.User;

import java.util.ArrayList;

public class DetailHistory extends AppCompatActivity {

    private int idUser;

    private User user;
    private DBHelper dbHelper;

    private TextView tvNama, tvUmur, tvAlamat, tvNoTlp, tvJk, tvDiagnosa;
    private RecyclerView rvSolusi;

    ArrayList<DiagnosaModel> diagnosaModels = new ArrayList<>();
    Penyakit penyakit;
    ImageView imageUser;

    ArrayList<Solusi> solusi = new ArrayList<>();

    SolusiListAdapter solusiListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        Bundle bundle = getIntent().getExtras();
        int idUser = bundle.getInt("id_user");

        tvNama = findViewById(R.id.rh_nama);
        tvUmur = findViewById(R.id.rh_umur);
        tvJk = findViewById(R.id.rh_jk);
        tvAlamat = findViewById(R.id.rh_alamat);
        tvNoTlp = findViewById(R.id.rh_notelepon);
        tvDiagnosa = findViewById(R.id.rh_diagnosa);
        rvSolusi = findViewById(R.id.rh_solusi);
        imageUser = findViewById(R.id.rh_img_user);

        dbHelper = new DBHelper(this);
        user = dbHelper.getUser(idUser);

        tvNama.setText(user.getNamaUser());
        tvUmur.setText(user.getUmurUser());
        tvJk.setText(user.getJenisKelaminUser());
        tvAlamat.setText(user.getAlamat());
        tvNoTlp.setText(user.getNoTelepon());

        if(user.getJenisKelaminUser().toString().equals("Perempuan")){
            imageUser.setImageDrawable(getResources().getDrawable(R.drawable.girl));
        }else{
            imageUser.setImageDrawable(getResources().getDrawable(R.drawable.boy));
        }

        diagnosaModels = dbHelper.getDiagnosaByUser(user.getIdUser());

        if(diagnosaModels.size() == 0){
            tvDiagnosa.setText("Rambut Anda Sehat, Jaga Selalu Kesehatan Rambut Anda");
        }else if (diagnosaModels.size() == 1){
            penyakit = dbHelper.getPenyakit(diagnosaModels.get(0).getIdPenyakit());
            tvDiagnosa.setText("Anda terkena Penyakit "+penyakit.getNamaPenyakit());

            solusi = dbHelper.getSolusi(diagnosaModels.get(0).getIdPenyakit());
            solusiListAdapter = new SolusiListAdapter(solusi, this);
            rvSolusi.setLayoutManager(new LinearLayoutManager(this));
            rvSolusi.setAdapter(solusiListAdapter);
        }else{
            String textDiagnosa = "Anda Terkena Penyakit:";
            for(int i=0;i<diagnosaModels.size();i++){
                penyakit = dbHelper.getPenyakit(diagnosaModels.get(i).getIdPenyakit());
                textDiagnosa = textDiagnosa+"\n"+penyakit.getNamaPenyakit();

                ArrayList<Solusi> dataSolusi = new ArrayList<Solusi>();
                dataSolusi = dbHelper.getSolusi(diagnosaModels.get(i).getIdPenyakit());
                if(!solusi.isEmpty()){
                    solusi.addAll(dataSolusi);
                }else{
                    solusi = dataSolusi;
                }
            }
            tvDiagnosa.setText(textDiagnosa);

            solusiListAdapter = new SolusiListAdapter(solusi, this);
            rvSolusi.setLayoutManager(new LinearLayoutManager(this));
            rvSolusi.setAdapter(solusiListAdapter);
        }
    }
}