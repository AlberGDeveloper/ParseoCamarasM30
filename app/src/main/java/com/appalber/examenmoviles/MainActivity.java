package com.appalber.examenmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PeticionRetrofit.Actualizacion{

    List<Posicion> listaDePosiciones;
    WebView web;
    Button lanzar;
    MainActivity a = this;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lanzar = (Button) findViewById(R.id.btn_lanzar);
        web = (WebView) findViewById(R.id.wb_camaras);
        progressBar = (ProgressBar) findViewById(R.id.pb);


        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PeticionRetrofit.pedirCamaras(a);
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }



    @Override
    public void recuperarDatosCamaras(Camaras cam) {
        web.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        String tabla = PintarHTML.crearTabla(cam);
        web.getSettings().setLoadsImagesAutomatically(true);
        Log.d("HTML", tabla);
        web.getSettings().setDomStorageEnabled(true);
        web.loadData(tabla,"text/html","UTF-8");
        lanzar.setVisibility(View.INVISIBLE);

    }


}