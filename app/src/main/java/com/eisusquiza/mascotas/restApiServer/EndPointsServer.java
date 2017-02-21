package com.eisusquiza.mascotas.restApiServer;

import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServer;

import retrofit2.http.Field;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by eisusquiza on 06/02/2017.
 */

public interface EndPointsServer {

    @FormUrlEncoded
    @POST(ConstantesRestApiServer.KEY_POST_ID_TOKEN)
    Call<UsuarioResponseServer> registrarTokenID(@Field("token") String token, @Field("id_instagram") String id_instagram);

}
