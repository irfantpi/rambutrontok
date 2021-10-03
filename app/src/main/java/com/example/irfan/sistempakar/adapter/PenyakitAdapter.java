package com.example.irfan.sistempakar.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irfan.sistempakar.DetailPenyakit;
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

        Resources res = context.getResources();
        int resID = res.getIdentifier(modelPenyakit.get(position).getImagePenyakit() , "drawable", context.getPackageName());
        Drawable drawable = res.getDrawable(resID );
        holder.imagePenyakit.setImageDrawable(drawable);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idPenyakit = modelPenyakit.get(position).getIdPenyakit();
                Intent intent = new Intent(context, DetailPenyakit.class);
                intent.putExtra("id_penyakit", idPenyakit);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelPenyakit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNamaPenyakit;
        private ImageView imagePenyakit;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaPenyakit = itemView.findViewById(R.id.nama_penyakit_list);
            imagePenyakit = itemView.findViewById(R.id.image_penyakit);
            linearLayout = itemView.findViewById(R.id.content_list_penyakit);
        }
    }
}
