package com.eisusquiza.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eisusquiza.mascotas.adapter.ContactoAdaptador;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Mascota> mascotas2;
    RecyclerView listaMascotas2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listaMascotas2 = (RecyclerView) findViewById(R.id.rvMascotas2);

        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas2.setLayoutManager(llm2);
        inicializarListaContactos2();
        inicializarAdaptador();

        Toolbar miActionBar2 = (Toolbar) findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public ContactoAdaptador adaptador;

    public void inicializarAdaptador() {
        adaptador = new ContactoAdaptador(mascotas2, this);
        listaMascotas2.setAdapter(adaptador);
    }

    public void inicializarListaContactos2() {
        mascotas2 = new ArrayList<Mascota>();

        mascotas2.add(new Mascota(R.drawable.marshall_png, "Marshall", 7));
        mascotas2.add(new Mascota(R.drawable.rocky_png, "Rocky", 6));
        mascotas2.add(new Mascota(R.drawable.rubble_png, "Rubble", 8));
        mascotas2.add(new Mascota(R.drawable.chase_png, "Chase", 5));
        mascotas2.add(new Mascota(R.drawable.everest_png, "Everest", 4));
    }
}
