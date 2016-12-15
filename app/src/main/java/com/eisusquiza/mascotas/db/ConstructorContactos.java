package com.eisusquiza.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 13/12/2016.
 */

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos (){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.chase_png, "Chase", 5));
        mascotas.add(new Mascota(R.drawable.everest_png, "Everest", 3));
        mascotas.add(new Mascota(R.drawable.rocky_png, "Rocky", 3));
        mascotas.add(new Mascota(R.drawable.rubble_png, "Rubble", 4));
        mascotas.add(new Mascota(R.drawable.marshall_png, "Marshall", 7));
        mascotas.add(new Mascota(R.drawable.skye_png, "Skye", 8));
        mascotas.add(new Mascota(R.drawable.zuma_png, "Zuma", 5));
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarSieteContactos(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarSieteContactos (BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Chase");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.chase_png);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Everest");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.everest_png);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Rocky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.rocky_png);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Rubble");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.rubble_png);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Marshall");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.marshall_png);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Skye");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.skye_png);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Zuma");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.zuma_png);
        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_ID_CONTACTO, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(mascota);
    }
}
