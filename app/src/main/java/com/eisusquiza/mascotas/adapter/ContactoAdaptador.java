package com.eisusquiza.mascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;
import com.eisusquiza.mascotas.db.ConstructorContactos;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 27/11/2016.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    public ContactoAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity= activity;
    }

    ArrayList<Mascota> mascotas;
    Activity activity;

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //INFLAR EL LAYOUT y LO PASARÁ A UN VIEWHOLDER PARA QUE OBTENGA LOS VIEWS
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder mascotaViewHolder, int position) { //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoContacto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));


        mascotaViewHolder.btnHueso.setOnClickListener(new View.OnClickListener() {
           // int contador = 0;
           //TextView tvNumeroEstrellasCV = (TextView) View.OnClickListener.findViewById(R.id.tvNumeroEstrellasCV);
         //   TextView tvNumeroEstrellasCV = (TextView) findViewById(R.id.tvNumeroEstrellasCV);

           @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a :" + mascota.getNombre(), Toast.LENGTH_SHORT).show();
               // contador++;

               ConstructorContactos constructorContactos = new ConstructorContactos(activity);
               constructorContactos.darLikeContacto(mascota);
               mascotaViewHolder.tvLikesCV.setText(constructorContactos.obtenerLikesContacto(mascota)+ " "+ "Likes");

            }
        });

    }

    @Override
    public int getItemCount () { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA de CONTACTOS
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoContacto;
        private TextView tvNombreCV;
        private ImageButton btnHueso;
        private TextView tvLikesCV;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFotoContacto = (ImageView) itemView.findViewById(R.id.imgFotoContacto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnHueso = (ImageButton) itemView.findViewById(R.id.btnHueso);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvLikesCV);
        }
    }


}