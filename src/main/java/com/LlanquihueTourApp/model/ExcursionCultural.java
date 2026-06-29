package com.LlanquihueTourApp.model;

/**
 * SubClase que gestiona los datos de ExcursionCultural
 */

public class ExcursionCultural extends ServicioTuristico{

    private String lugarHistorico;

    /**
     *
     * @param nombre nombre sel servicio de la Excursion cultural
     * @param duracionHoras duración en horas de la excursion
     * @param lugarHistorico lugar histórico de la zona, punto de interés de la ruta
     */

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }


    /**
     * Devuelve los datos en forma de texto de los datos de ExcursionCultural
     * @return Una cadena de texto estructurada con todos los datos heredados de ServicioTuristico más los datos de ExcursionCultural
     */

    @Override
    public String toString() {
        return "---EXCURSION CULTURAL---" + super.toString() +
                " |Lugar histórico: " + lugarHistorico;
    }
}
