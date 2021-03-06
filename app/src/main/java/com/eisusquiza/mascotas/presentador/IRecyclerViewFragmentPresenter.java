package com.eisusquiza.mascotas.presentador;

import com.eisusquiza.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 13/12/2016.
 */

public interface IRecyclerViewFragmentPresenter {

    public void getMascotas();
    public void showMascotas(ArrayList<Mascota> mascotas);
    public void getFavoritos();
    public void getMascotasRest();
}
