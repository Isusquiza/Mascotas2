package com.eisusquiza.mascotas.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.eisusquiza.mascotas.ActivityAbout;
import com.eisusquiza.mascotas.ActivityContacto;
import com.eisusquiza.mascotas.Main2Activity;
import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;
import com.eisusquiza.mascotas.adapter.ContactoAdaptador;
import com.eisusquiza.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.eisusquiza.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleViewFragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public RecycleViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recycle_view, container, false);

        View v = inflater.inflate(R.layout.fragment_recycle_view, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        //inicializarListaContactos();
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }




    /*public void inicializarListaContactos() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.chase_png, "Chase", 5));
        mascotas.add(new Mascota(R.drawable.everest_png, "Everest", 3));
        mascotas.add(new Mascota(R.drawable.rocky_png, "Rocky", 3));
        mascotas.add(new Mascota(R.drawable.rubble_png, "Rubble", 4));
        mascotas.add(new Mascota(R.drawable.marshall_png, "Marshall", 7));
        mascotas.add(new Mascota(R.drawable.skye_png, "Skye", 8));
        mascotas.add(new Mascota(R.drawable.zuma_png, "Zuma", 5));

    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        ContactoAdaptador adaptador = new ContactoAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}