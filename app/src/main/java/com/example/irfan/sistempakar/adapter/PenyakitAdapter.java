package com.example.irfan.sistempakar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irfan.sistempakar.R;
import com.example.irfan.sistempakar.model.Penyakit;

import java.util.ArrayList;

public class PenyakitAdapter extends RecyclerView.Adapter<PenyakitAdapter.ViewHolder> {

    ArrayList<Penyakit> modelPenyakit = new ArrayList<>();
    Context context;

    public PenyakitAdapter(ArrayList<Penyakit> modelKarakters, Context context) {
        this.modelPenyakit = modelKarakters;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_penyakit,parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNamaPenyakit.setText(modelPenyakit.get(position).getNamaPenyakit());
    }

    @Override
    public int getItemCount() {
        return modelPenyakit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNamaPenyakit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaPenyakit = itemView.findViewById(R.id.nama_penyakit_list);
        }
    }
}
