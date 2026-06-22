package com.LlanquihueTourApp.model;
import com.LlanquihueTourApp.model.Operadores;

import java.awt.geom.Area;

/**
 * Clase encargada de gestionar los datos del tour
 */

public class Tours{
    private int id;
    private String name;
    private String type;
    private double production;

    /**
     *
     * @param id         numeración para los tipos de tours.
     * @param name       nombre de la actividad realizada.
     * @param type       tipo de actividad realizada en el tour.
     * @param production Ganancia generada por la actividad por persona.
     */



    public Tours(int id, String name, String type, double production) {
        setId(id);
        setName(name);
        setType(type);
        setProduction(production);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del tour no puede estar vacío.");
        }
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getProduction() {
        return production;
    }

    public void setProduction(double production) {
        if (production < 0) {
            throw new IllegalArgumentException("La producción no puede ser negativa.");
        }
        this.production = production;

    }

    /**
     * Devuelve los datos en forma de texto de los datos de tour
     * @return Una cadena de texto estructurada con todos los datos de tour
     */

    @Override
    public String toString() {
        return "TOUR  " +
                " | Id:" + id +
                " | Nombre: " + name +
                " | Tipo: " + type +
                " | Producción: " + production +
                "|";
    }
}

