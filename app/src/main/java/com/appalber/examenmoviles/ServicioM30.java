package com.appalber.examenmoviles;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioM30 {
    //http://www.mc30.es/components/

    @GET("com_hotspots/datos/camaras.xml")
    Call<Camaras> mostrarCamaras();
}
