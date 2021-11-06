package com.example.irfan.sistempakar.activity_diagnosa;

import android.content.res.Resources;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irfan.sistempakar.R;
import com.example.irfan.sistempakar.adapter.SolusiListAdapter;
import com.example.irfan.sistempakar.helper.DBHelper;
import com.example.irfan.sistempakar.model.DiagnosaModel;
import com.example.irfan.sistempakar.model.Penyakit;
import com.example.irfan.sistempakar.model.Solusi;
import com.example.irfan.sistempakar.model.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
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

    public ResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        tvNama = view.findViewById(R.id.r_nama);
        tvUmur = view.findViewById(R.id.r_umur);
        tvJk = view.findViewById(R.id.r_jk);
        tvAlamat = view.findViewById(R.id.r_alamat);
        tvNoTlp = view.findViewById(R.id.r_notelepon);
        tvDiagnosa = view.findViewById(R.id.r_diagnosa);
        rvSolusi = view.findViewById(R.id.r_solusi);
        imageUser = view.findViewById(R.id.r_img_user);

        idUser = getArguments().getInt("id_user");

        dbHelper = new DBHelper(view.getContext());
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
            solusiListAdapter = new SolusiListAdapter(solusi, view.getContext());
            rvSolusi.setLayoutManager(new LinearLayoutManager(view.getContext()));
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

            solusiListAdapter = new SolusiListAdapter(solusi, view.getContext());
            rvSolusi.setLayoutManager(new LinearLayoutManager(view.getContext()));
            rvSolusi.setAdapter(solusiListAdapter);
        }

        Toast.makeText(view.getContext(), String.valueOf(idUser), Toast.LENGTH_SHORT).show();
        return view;
    }
}