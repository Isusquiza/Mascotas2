package com.eisusquiza.mascotas.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;
import com.eisusquiza.mascotas.RockyAdaptador;
import com.eisusquiza.mascotas.Rockys;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    ArrayList<Rockys> rockys;
    RecyclerView listaRockys;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);

        View q = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaRockys = (RecyclerView) q.findViewById(R.id.rvRocky);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);

        listaRockys.setLayoutManager(glm);
        inicializarListaContactos_Rocky();
        inicializarAdaptadorRocky();

        return q;


    }

    public void inicializarAdaptadorRocky(){
        RockyAdaptador adaptardorRocky = new RockyAdaptador(rockys);
        listaRockys.setAdapter(adaptardorRocky);

    }

    public void inicializarListaContactos_Rocky() {

        rockys = new ArrayList<Rockys>();

        rockys.add(new Rockys(R.drawable.rocky_png, "5"));
        rockys.add(new Rockys(R.drawable.rocky_png, "8"));
        rockys.add(new Rockys(R.drawable.rocky_png, "10"));
        rockys.add(new Rockys(R.drawable.rocky_png, "0"));
        rockys.add(new Rockys(R.drawable.rocky_png, "2"));
        rockys.add(new Rockys(R.drawable.rocky_png, "1"));
        rockys.add(new Rockys(R.drawable.rocky_png, "3"));
        rockys.add(new Rockys(R.drawable.rocky_png, "6"));
        rockys.add(new Rockys(R.drawable.rocky_png, "15"));


    }

}
