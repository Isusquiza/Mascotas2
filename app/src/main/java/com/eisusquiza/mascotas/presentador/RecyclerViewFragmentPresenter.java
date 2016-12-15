package com.eisusquiza.mascotas.presentador;

import android.content.Context;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.db.ConstructorContactos;
import com.eisusquiza.mascotas.fragments.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 13/12/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactoBaseDatos();
    }

    @Override
    public void obtenerContactoBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        mascotas = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
