package com.example.irfan.sistempakar.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.irfan.sistempakar.DetailHistory;
import com.example.irfan.sistempakar.HistoryActivity;
import com.example.irfan.sistempakar.R;
import com.example.irfan.sistempakar.helper.DBHelper;
import com.example.irfan.sistempakar.model.Gejala;
import com.example.irfan.sistempakar.model.History;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    ArrayList<History> modelHistory = new ArrayList<>();
    Context context;

    public HistoryAdapter(ArrayList<History> modelHistory, Context context) {
        this.modelHistory = modelHistory;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_history,parent, false);
        return new HistoryAdapter.ViewHolder(rootView);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNama.setText(modelHistory.get(position).getNamaUser());
//        holder.tvPenyakit.setText(modelHistory.get(position).getNamaPenyakit());
        String[] data = modelHistory.get(position).getNamaPenyakit().split("-");
        for(int i=0; i < data.length; i++){
            if(i==0){
                holder.tvP1.setText(data[i]);
                holder.tvP1.setVisibility(View.VISIBLE);
            }else if(i==1){
                holder.tvP2.setText(data[i]);
                holder.tvP2.setVisibility(View.VISIBLE);
            }else if(i==2){
                holder.tvP3.setText(data[i]);
                holder.tvP3.setVisibility(View.VISIBLE);
            }else if(i==3){
                holder.tvP4.setText(data[i]);
                holder.tvP4.setVisibility(View.VISIBLE);
            }else if(i==4){
                holder.tvP5.setText(data[i]);
                holder.tvP5.setVisibility(View.VISIBLE);
            }
        }

        if(modelHistory.get(position).getJenisKelamin().equals("Perempuan")){
            holder.imgUser.setImageDrawable(context.getResources().getDrawable(R.drawable.girl));
        }else{
            holder.imgUser.setImageDrawable(context.getResources().getDrawable(R.drawable.boy));
        }
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, String.valueOf(modelHistory.get(position).getIdUser()), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext(), R.style.Theme_AppCompat_Dialog_Alert);

                builder.setTitle("Peringatan");
                builder.setMessage("Apakah Ingin Menghapus Data History Ini ?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        DBHelper dbHelper;
                        dbHelper = new DBHelper(v.getRootView().getContext());
                        dbHelper.deleteHistory(modelHistory.get(position).getIdUser());
                        Intent intent = new Intent(v.getRootView().getContext(), HistoryActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        v.getRootView().getContext().startActivity(intent);
                    }
                });

                builder.setNegativeButton("NO", null);

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getRootView().getContext(), DetailHistory.class);
                intent.putExtra("id_user", modelHistory.get(position).getIdUser());
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getRootView().getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelHistory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgUser, imgDelete;
        private TextView tvNama, tvP1, tvP2, tvP3, tvP4, tvP5;
        private LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.lh_image);
            tvNama = itemView.findViewById(R.id.lh_name);
            tvP1 = itemView.findViewById(R.id.lh_p1);
            tvP2 = itemView.findViewById(R.id.lh_p2);
            tvP3 = itemView.findViewById(R.id.lh_p3);
            tvP4 = itemView.findViewById(R.id.lh_p4);
            tvP5 = itemView.findViewById(R.id.lh_p5);
            imgDelete = itemView.findViewById(R.id.lh_delete);
            layout = itemView.findViewById(R.id.lh_layout);
        }
    }
}
