package com.florenciaolivieri.petgrammascotas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {


    ArrayList<Mascota> mascotas;

    /**
     *método constructor de MascotaAdaptador
     * construye la lista de mascotas
     */

    public MascotaAdaptador(ArrayList<Mascota> mascotas) {

        this.mascotas = mascotas;
    };



    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar el layout y lo pasará al viewholder para que obtenga los views
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota ,parent, false);
        return new MascotaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        //asocia cada elemento de la lista con cada view
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascotaCV.setText(mascota.getNombre());
        mascotaViewHolder.tvNLikesCV.setText(mascota.getNumeroLikes());


    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    //clase estática le da vida a los views
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{


        private ImageView imgMascota;
        private TextView tvNombreMascotaCV;
        private TextView tvNLikesCV;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMascota        = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombreMascotaCV = (TextView) itemView.findViewById(R.id.tvNombreMascotaCV);
            tvNLikesCV        = (TextView) itemView.findViewById(R.id.tvNLikesCV);

        }
    }
}

