package com.eisusquiza.mascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eisusquiza.mascotas.Main2Activity;
import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 28/11/2016.
 */

public class ContactoAdaptador2 extends RecyclerView.Adapter<ContactoAdaptador2.MascotaViewHolder>{

    public  ContactoAdaptador2(ArrayList<Mascota> mascotas2, Main2Activity main2Activity){
        this.mascotas2= mascotas2;

    }

    ArrayList<Mascota> mascotas2;

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View w= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(w);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascotas = mascotas2.get(position);
        mascotaViewHolder.imgFotoContacto.setImageResource(mascotas.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascotas.getNombre());
        mascotaViewHolder.tvNumeroEstrellasCV.setText(mascotas.getEstrellas());

    }

    @Override
    public int getItemCount() {//cantidad de elementos de la lista
        return mascotas2.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{ //aqui se declaran los views
        private ImageView imgFotoContacto;
        private TextView tvNombreCV;
        private TextView tvNumeroEstrellasCV;
        private ImageButton btnHueso;


        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFotoContacto = (ImageView) itemView.findViewById(R.id.imgFotoContacto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvNumeroEstrellasCV = (TextView) itemView.findViewById(R.id.tvNumeroEstrellasCV);
            btnHueso  = (ImageButton) itemView.findViewById(R.id.btnHueso);
        }
    }

}