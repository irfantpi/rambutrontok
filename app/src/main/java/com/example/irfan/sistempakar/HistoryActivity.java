package com.example.irfan.sistempakar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.irfan.sistempakar.adapter.GejalaListAdapter;
import com.example.irfan.sistempakar.adapter.HistoryAdapter;
import com.example.irfan.sistempakar.helper.DBHelper;
import com.example.irfan.sistempakar.model.DiagnosaModel;
import com.example.irfan.sistempakar.model.History;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvList;

    ArrayList<History> diagnosa = new ArrayList<>();

    DBHelper dbHelper;

    HistoryAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvList = findViewById(R.id.h_list);

        dbHelper = new DBHelper(getApplicationContext());
        diagnosa = dbHelper.dataForHistory();
        for(int i=0;i<diagnosa.size();i++){
            for(int j=0;j<diagnosa.size();j++){
                if (diagnosa.get(i).getIdUser() == diagnosa.get(j).getIdUser()) {
                    if (diagnosa.get(i).getIdPenyakit() != diagnosa.get(j).getIdPenyakit()) {
                        diagnosa.get(i).setNamaPenyakit(diagnosa.get(i).getNamaPenyakit() + "-" + diagnosa.get(j).getNamaPenyakit());
                        diagnosa.remove(j);
                    }
                }
            }
        }
        for(int i=0;i<diagnosa.size();i++){
            for(int j=0;j<diagnosa.size();j++){
                if (diagnosa.get(i).getIdUser() == diagnosa.get(j).getIdUser()) {
                    if (diagnosa.get(i).getIdPenyakit() != diagnosa.get(j).getIdPenyakit()) {
                        diagnosa.get(i).setNamaPenyakit(diagnosa.get(i).getNamaPenyakit() + "-" + diagnosa.get(j).getNamaPenyakit());
                        diagnosa.remove(j);
                    }
                }
            }
        }
        historyAdapter = new HistoryAdapter(diagnosa, getApplicationContext());
        rvList.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rvList.setAdapter(historyAdapter);

    }
}