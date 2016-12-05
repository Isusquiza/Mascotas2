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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;

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

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

   /* @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mRefresh: //AQUI ESCRIBIR LA ACCION
                Intent tent  = new Intent(getContext(), Main2Activity.class );
                startActivity(tent);
                break;

            case R.id.mContacto:
                Intent ye = new Intent (getContext(), ActivityContacto.class);
                startActivity(ye);
                break;

            case R.id.mAcerca:
                Intent fe = new Intent (getContext(), ActivityAbout.class);
                startActivity(fe);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    public void inicializarAdaptador() {
        adaptador = new ContactoAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public ContactoAdaptador adaptador;

    public void inicializarListaContactos() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.chase_png, "Chase", 5));
        mascotas.add(new Mascota(R.drawable.everest_png, "Everest", 3));
        mascotas.add(new Mascota(R.drawable.rocky_png, "Rocky", 3));
        mascotas.add(new Mascota(R.drawable.rubble_png, "Rubble", 4));
        mascotas.add(new Mascota(R.drawable.marshall_png, "Marshall", 7));
        mascotas.add(new Mascota(R.drawable.skye_png, "Skye", 8));
        mascotas.add(new Mascota(R.drawable.zuma_png, "Zuma", 5));

    }

}