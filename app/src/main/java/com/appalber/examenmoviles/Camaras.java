package com.appalber.examenmoviles;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="Camaras")
public class Camaras {
    @ElementList(entry = "Camara", inline = true)
    private List<Camara> Camara;

    public List<Camara> getCamara() {
        return Camara;
    }

    public void setCamara(List<Camara> camara) {
        this.Camara = camara;
    }

    @Override
    public String toString() {
        return "Camaras{" +
                "Camara=" + Camara +
                '}';
    }
}
