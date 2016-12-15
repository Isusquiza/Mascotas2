package com.eisusquiza.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.eisusquiza.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 11/12/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {


    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "("+
                                         ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER"+
                                          ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_CONTACTOS + "(" +
                ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_ID_CONTACTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_ID_CONTACTO + ") " +
                "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")"+
                ")";


        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascota);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_CONTACTOS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas (){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota contactoActual = new Mascota();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_NUMERO_LIKES+")as likes " +
                                " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACTOS +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_ID_CONTACTO + "=" + contactoActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                contactoActual.setLikes(registrosLikes.getInt(0));
            } else {
                contactoActual.setLikes(0);
            }

            mascotas.add(contactoActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarContacto (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();

    }

    public void insertarLikeContacto (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACTOS, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto (Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_NUMERO_LIKES+")"+
                       " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACTOS +
                       " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACTOS_ID_CONTACTO + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }
}
