package com.LlanquihueTourApp.model;

/**
 * SuperClase que gestiona los datos de los servicios (subclases)
 */

public class ServicioTuristico {
    private String nombre;
    private int duracionHoras;

    /**
     *
     * @param nombre        nombre del servicio
     * @param duracionHoras duración en horas del servicio
     */

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Devuelve los datos en forma de texto de los datos de ServicioTuristico
     * @return Una cadena de texto estructurada con todos los datos de ServicioTuristico
     */

    @Override
    public String toString() {
        return  " |Nombre: " + nombre +
                " |Duración Horas: " + duracionHoras +
                '|';
    }
}
