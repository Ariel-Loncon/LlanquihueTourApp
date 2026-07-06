package com.LlanquihueTourApp.model;

/**
 * SubClase que gestiona los datos de RutaGastronomica
 */

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    /**
     *
     * @param nombre          nombre del servicio de la ruta gastronómica
     * @param duracionHoras   duración en horas de la ruta
     * @param numeroDeParadas numero de veces que se detiene la ruta en sectores
     */

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Devuelve los datos en forma de texto de los datos de RutaGatronomica
     *
     * @return Una cadena de texto estructurada con todos los datos heredados de ServicioTuristico más los datos de RutaGatronomica
     */

    @Override
    public String toString() {
        return "---RUTA GASTRONÓMICA---" + super.toString() +
                " |Numero de paradas: " + numeroDeParadas;
    }
}

