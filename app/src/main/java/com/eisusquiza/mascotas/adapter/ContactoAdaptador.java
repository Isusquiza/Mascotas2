package com.eisusquiza.mascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
    public void onBindViewHolder(final ContactoViewHolder holder, int position) { //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW

        final Mascota m = mascotas.get(position);
        Picasso.with(activity)
                .load(m.getPicture())
                .placeholder(R.drawable.monkeyhead)
                .into(holder.foto);
        //mascotaViewHolder.imgFotoContacto.setImageResource(mascota.getFoto());
        //mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        //mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));

        if(position%2==0)
            holder.foto.setBackgroundResource(R.color.fondo1);
        else
            holder.foto.setBackgroundResource(R.color.fondo2);
        Calendar c=Calendar.getInstance();
        c.setTimeInMillis(Long.parseLong(m.getFecha())*1000);
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        holder.fecha.setText(sdf.format(c.getTime()));
        holder.nombre.setText(m.getNombre());
        holder.votos.setText(m.getVotos()+"");
    }


       /* mascotaViewHolder.btnHueso.setOnClickListener(new View.OnClickListener() {
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
        });*/



    @Override
    public int getItemCount () { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA de CONTACTOS
        return mascotas.size();
    }

public static class ContactoViewHolder extends RecyclerView.ViewHolder{
    private ImageView foto;
    private TextView nombre,votos,fecha;


    public ContactoViewHolder(View itemView) {
        super(itemView);
        foto=(ImageView) itemView.findViewById(R.id.imgFotoContacto);
        nombre=(TextView)itemView.findViewById(R.id.tvNombreCV);
        votos=(TextView)itemView.findViewById(R.id.votos);
        fecha=(TextView)itemView.findViewById(R.id.fecha);
    }
}
}


