package com.example.brian.retrofit.Interface;

import com.example.brian.retrofit.POJO.Usuario;

import java.util.List;

import retrofit.http.GET;


/**
 * Created by Brian on 20/03/2017.
 */

public interface UsuarioService {

    @GET("/jairwsj.json")
    void getUser (retrofit.Callback<List<Usuario>> callback);
    //Retrofit utiliza como parametro un callback y el tipo de informacion
    //que va a traer en este caso es una lista del tipo usuario

    //Call<List<Usuario>> getUsuario();

    //retrofit2.Callback<List<Usuario>> getUser();

}
