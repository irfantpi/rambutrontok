package com.example.irfan.sistempakar.activity_diagnosa;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irfan.sistempakar.R;
import com.example.irfan.sistempakar.helper.DBHelper;
import com.example.irfan.sistempakar.model.Diagnosa;
import com.example.irfan.sistempakar.model.DiagnosaModel;
import com.example.irfan.sistempakar.model.Gejala;
import com.example.irfan.sistempakar.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DiagnosaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tvNo, tvKuesioner;
    Button btnYa, btnTidak;
    private int noQ = 1;

    private ArrayList<Gejala> gejalas;

    private DBHelper dbHelper;

    private User user;

    private ArrayList<Diagnosa> penyakit1 = new ArrayList<Diagnosa>();
    private ArrayList<Diagnosa> penyakit2 = new ArrayList<Diagnosa>();
    private ArrayList<Diagnosa> penyakit3 = new ArrayList<Diagnosa>();
    private ArrayList<Diagnosa> penyakit4 = new ArrayList<Diagnosa>();
    private ArrayList<Diagnosa> penyakit5 = new ArrayList<>();
    private ArrayList<Diagnosa> diagnosa = new ArrayList<Diagnosa>();

    private int totalPenyakit1=0, totalPenyakit2=0, totalPenyakit3=0, totalPenyakit4=0, totalPenyakit5=0;

    public DiagnosaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diagnosa, container, false);


        tvNo = view.findViewById(R.id.dg_no);
        tvKuesioner = view.findViewById(R.id.dg_kuesioner);
        btnYa = view.findViewById(R.id.dg_btn_ya);
        btnTidak = view.findViewById(R.id.dg_btn_tidak);

        dbHelper = new DBHelper(view.getContext());
        gejalas = dbHelper.getAllGejala();

        user = dbHelper.getLastRecordUser();

        tvKuesioner.setText(gejalas.get(noQ-1).getNamaGejala());

        for (int i=0; i<gejalas.size(); i++){
            if (gejalas.get(i).getPenyakitId() == 1){
                Diagnosa diagnosa = new Diagnosa(gejalas.get(i).getPenyakitId(), gejalas.get(i).getIdGejala());
                penyakit1.add(diagnosa);
            } else if (gejalas.get(i).getPenyakitId() == 2){
                Diagnosa diagnosa = new Diagnosa(gejalas.get(i).getPenyakitId(), gejalas.get(i).getIdGejala());
                penyakit2.add(diagnosa);
            }else if (gejalas.get(i).getPenyakitId() == 3){
                Diagnosa diagnosa = new Diagnosa(gejalas.get(i).getPenyakitId(), gejalas.get(i).getIdGejala());
                penyakit3.add(diagnosa);
            }else if (gejalas.get(i).getPenyakitId() == 4){
                Diagnosa diagnosa = new Diagnosa(gejalas.get(i).getPenyakitId(), gejalas.get(i).getIdGejala());
                penyakit4.add(diagnosa);
            }else if (gejalas.get(i).getPenyakitId() == 5){
                Diagnosa diagnosa = new Diagnosa(gejalas.get(i).getPenyakitId(), gejalas.get(i).getIdGejala());
                penyakit5.add(diagnosa);
            }
        }

        btnYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Diagnosa diagnosadata = new Diagnosa(gejalas.get(noQ-1).getPenyakitId(), gejalas.get(noQ-1).getIdGejala());
                diagnosa.add(diagnosadata);
                if(noQ == gejalas.size()){
                    diagnosa(view);
                }else{
                    tvKuesioner.setText(gejalas.get(noQ).getNamaGejala());
                    tvNo.setText(noQ+1 + " / "+gejalas.size());
                    noQ++;
                }
            }
        });

        btnTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noQ == gejalas.size()){
                    diagnosa(view);
                }else{
                    tvKuesioner.setText(gejalas.get(noQ).getNamaGejala());
                    tvNo.setText(noQ+1 + " / "+gejalas.size());
                    noQ++;
                }
            }
        });

        return view;
    }

    private void diagnosa(View view){
        for(int i=0; i<diagnosa.size(); i++){
            if(diagnosa.get(i).getId_penyakit() == 1){
                totalPenyakit1++;
            }else if(diagnosa.get(i).getId_penyakit() == 2){
                totalPenyakit2++;
            }else if(diagnosa.get(i).getId_penyakit() == 3){
                totalPenyakit3++;
            }else if(diagnosa.get(i).getId_penyakit() == 4){
                totalPenyakit4++;
            }else if(diagnosa.get(i).getId_penyakit() == 5){
                totalPenyakit5++;
            }
        }

        if(totalPenyakit1 == penyakit1.size()){
            //Toast.makeText(view.getContext(), "Anda Terkena Penyakit 1", Toast.LENGTH_SHORT).show();
            addRecord(view, 1);
        }

        if(totalPenyakit2 == penyakit2.size()){
            //Toast.makeText(view.getContext(), "Anda Terkena Penyakit 2", Toast.LENGTH_SHORT).show();
            addRecord(view, 2);
        }

        if(totalPenyakit3 == penyakit3.size()){
            //Toast.makeText(view.getContext(), "Anda Terkena Penyakit 3", Toast.LENGTH_SHORT).show();
            addRecord(view, 3);
        }

        if(totalPenyakit4 == penyakit4.size()){
            //Toast.makeText(view.getContext(), "Anda Terkena Penyakit 4", Toast.LENGTH_SHORT).show();
            addRecord(view, 4);
        }

        if(totalPenyakit5 == penyakit5.size()){
            //Toast.makeText(view.getContext(), "Anda Terkena Penyakit 5, ", Toast.LENGTH_SHORT).show();
            addRecord(view, 5);
        }

        if(totalPenyakit1 != penyakit1.size()
        && totalPenyakit2 != penyakit2.size()
        && totalPenyakit3 != penyakit3.size()
        && totalPenyakit4 != penyakit4.size()
        && totalPenyakit5 != penyakit5.size()
        ){
            addRecord(view, 6);
        }

        Intent intent = new Intent(view.getContext(), DiagnosaActivity.class);
        intent.putExtra("layout_diagnosa", 3);
        intent.putExtra("id_user_diagnosa", user.getIdUser());
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void addRecord(View view, int idPenyakit){
        DiagnosaModel diagnosaModel = new DiagnosaModel(0, idPenyakit, user.getIdUser());
        dbHelper.addRecordDiagnosa(diagnosaModel);
    }
}