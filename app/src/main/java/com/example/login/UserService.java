package com.example.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @POST("user/")
    Call<usuario> Registro (@Body usuario usuario);

    @GET("user/{id}")
    Call<usuario> getUsuario (@Path("id") String id);

    @DELETE("user/{id}")
    Call<Void>  Eliminar (@Path("id") String id);

    @PUT("user/")
    Call<Void> Actualizar(@Body usuario usuario);

}
