package com.appalber.examenmoviles;

import android.util.Log;

import java.util.List;

public class PintarHTML {
    private static String inicioHTML = "<!DOCTYPE html>" + "<html lang='en'>" + "<head>"
            + "    <title>Tabla Covid</title>" + "</head>" + "<body>" + "";
    private static String finalHTML = "</body>" + "</html>";

    public static String crearTabla(Camaras camaraWeb) {
        List<Camara> lista_camaras = camaraWeb.getCamara();
        String tabla = "<table border='2'>";
        tabla += "<tr>" + "<td>" + "Latitud" + "</td>"
                + "<td>" + "Longitud" + "</td>" +

                "<td>" + "FOTO" + "</td></tr>";

        for (Camara camara: lista_camaras) {

            tabla += "<tr>";

            tabla += "<td align='center'>" + camara.getPosicion().getLatitud() + "</td>";
            tabla += "<td align='center'>" + camara.getPosicion().getLongitud() + "</td>";
            tabla += "<td><img src='https://"+camara.getURL()+"'/>Fotos</td>";
            tabla += "</tr>";
        }
        tabla += "</table>";
        return inicioHTML + tabla + finalHTML;
    }
}
