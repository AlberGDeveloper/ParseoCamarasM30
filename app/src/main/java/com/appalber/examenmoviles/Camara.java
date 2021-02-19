package com.appalber.examenmoviles;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Camara {
    @Element(name="Posicion", required = false)
    private Posicion posicion;
    @Element (name = "URL", required = false)
    private String URL;

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }




    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Camara{" +
                "posicion=" + posicion +
                ", Nombre='" +  '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
}
