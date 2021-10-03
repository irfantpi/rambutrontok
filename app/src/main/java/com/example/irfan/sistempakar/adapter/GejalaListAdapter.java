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
import com.example.irfan.sistempakar.model.Penyakit;

import java.util.ArrayList;

public class GejalaListAdapter  extends RecyclerView.Adapter<GejalaListAdapter.ViewHolder> {

    ArrayList<Gejala> modelGejala = new ArrayList<>();
    Context context;

    public GejalaListAdapter(ArrayList<Gejala> modelGejala, Context context) {
        this.modelGejala = modelGejala;
        this.context = context;
    }

    @NonNull
    @Override
    public GejalaListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_gejala,parent, false);
        return new GejalaListAdapter.ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull GejalaListAdapter.ViewHolder holder, int position) {
        holder.tvNama.setText(modelGejala.get(position).getNamaGejala());
    }

    @Override
    public int getItemCount() {
        return modelGejala.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.list_nama_gejala);
        }
    }
}
