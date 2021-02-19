package com.appalber.examenmoviles;


import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PeticionRetrofit {
   static Camaras cam = null;
   static String base = "http://www.mc30.es/components/";
   static Retrofit retrofit = new Retrofit.Builder().baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create()).build();
   static ServicioM30 service = retrofit.create(ServicioM30.class);

    public static void pedirCamaras(Actualizacion a) {

       Call<Camaras> llamada = service.mostrarCamaras();
       llamada.enqueue(new Callback<Camaras>() {
           @Override
           public void onResponse(Call<Camaras> call, Response<Camaras> response) {
               cam = response.body();
               List<Camara> lista_camaras = cam.getCamara();
               Log.d("OKEY", lista_camaras.toString());
               a.recuperarDatosCamaras(cam);
               Log.d("OKEY", "todo okey");



           }

           @Override
           public void onFailure(Call<Camaras> call, Throwable t) {
               Log.d("FALLO", "Ha habido un fallo"+t.getLocalizedMessage());
           }
       });
    }
    public interface Actualizacion {
        public void recuperarDatosCamaras(Camaras cam);

    }
}