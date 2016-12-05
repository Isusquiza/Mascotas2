package com.eisusquiza.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eisusquiza.mascotas.adapter.ContactoAdaptador;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 27/11/2016.
 */

public class DetalleMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas2;
    private RecyclerView listaMascotas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallemascotas);

        Intent intent = getIntent();
        //Bundle recibirParametro = thisform.getExtras();

        //Button btnHueso = (Button) findViewById(R.id.btnHueso);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas2 = (RecyclerView) findViewById(R.id.rvMascotas2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas2.setLayoutManager(llm);
        inicializarListaContactos();
     //   inicializarAdaptador2();
    }


    public ContactoAdaptador adaptador;

   // public void inicializarAdaptador2() {
   //     ContactoAdaptador adaptador = new ContactoAdaptador2(mascotas2, this);
   //     listaMascotas2.setAdapter(adaptador);
   // }

    public void inicializarListaContactos() {

        mascotas2 = new ArrayList<Mascota>();

        mascotas2.add(new Mascota(R.drawable.chase_png, "Chase",5));
        mascotas2.add(new Mascota(R.drawable.everest_png, "Everest",4));
        mascotas2.add(new Mascota(R.drawable.rocky_png, "Rocky",6));
        mascotas2.add(new Mascota(R.drawable.rubble_png, "Rubble",8));
        mascotas2.add(new Mascota(R.drawable.marshall_png, "Marshall",7));

    }






}
