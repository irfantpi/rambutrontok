package com.example.irfan.sistempakar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irfan.sistempakar.R;
import com.example.irfan.sistempakar.model.Gejala;
import com.example.irfan.sistempakar.model.Solusi;

import java.util.ArrayList;

public class SolusiListAdapter extends RecyclerView.Adapter<SolusiListAdapter.ViewHolder> {

    ArrayList<Solusi> modelSolusi = new ArrayList<>();
    Context context;

    public SolusiListAdapter(ArrayList<Solusi> modelSolusi, Context context) {
        this.modelSolusi = modelSolusi;
        this.context = context;
    }

    @NonNull
    @Override
    public SolusiListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_gejala,parent, false);
        return new SolusiListAdapter.ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull SolusiListAdapter.ViewHolder holder, int position) {
        holder.tvNama.setText(modelSolusi.get(position).getKeteranganSolusi());
    }

    @Override
    public int getItemCount() {
        return modelSolusi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.list_nama_gejala);
        }
    }
}
