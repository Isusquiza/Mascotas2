package com.eisusquiza.mascotas.restApiServer.modelServer;

/**
 * Created by eisusquiza on 06/02/2017.
 */

public class UsuarioResponseServer {

    private String id;
    private String token;
    private String id_instagram;

    public UsuarioResponseServer(String id, String token, String id_instagram) {
        this.id = id;
        this.token = token;
        this.id_instagram = id_instagram;
    }

    public UsuarioResponseServer(){};

    public String getId_instagram() {
        return id_instagram;
    }

    public void setId_instagram(String id_instagram) {
        this.id_instagram = id_instagram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
