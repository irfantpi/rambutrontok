package com.example.irfan.sistempakar.activity_diagnosa;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
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
import com.example.irfan.sistempakar.model.Gejala;
import com.example.irfan.sistempakar.model.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataDiriFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataDiriFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText edtNama, edtUmur, edtAlamat, edtNotlp;
    private Spinner spJk;
    private Button btnSubmit;

    private DBHelper dbHelper;

    public DataDiriFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataDiriFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataDiriFragment newInstance(String param1, String param2) {
        DataDiriFragment fragment = new DataDiriFragment();
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
        View view = inflater.inflate(R.layout.fragment_data_diri, container, false);

        edtNama = view.findViewById(R.id.dd_nama);
        edtUmur = view.findViewById(R.id.dd_umur);
        edtAlamat = view.findViewById(R.id.dd_alamat);
        edtNotlp = view.findViewById(R.id.dd_notlp);
        spJk = view.findViewById(R.id.dd_jk);
        btnSubmit = view.findViewById(R.id.dd_btn);

        dbHelper = new DBHelper(view.getContext());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNama.getText().length() > 0 &&
                        edtNotlp.getText().length() > 0 &&
                        edtAlamat.getText().length() > 0 &&
                        edtUmur.getText().length() > 0 &&
                        spJk.getSelectedItem().toString().length() > 0){

                    User user = new User(0, edtNama.getText().toString(), edtUmur.getText().toString(), spJk.getSelectedItem().toString(), edtAlamat.getText().toString(), edtNotlp.getText().toString());
                    dbHelper.addRecordUser(user);

                    Intent intent = new Intent(view.getContext(), DiagnosaActivity.class);
                    intent.putExtra("layout_diagnosa", 2);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }else {
                    Toast.makeText(view.getContext(), "Form Tidak Boleh Ada Yang Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}