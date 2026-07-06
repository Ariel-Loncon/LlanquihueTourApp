package com.LlanquihueTourApp.model;

/**
 * SubClase que gestiona los datos de PaseoLacustre
 */

public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    /**
     *
     * @param nombre          nombre del servicio del paseo lacustre
     * @param duracionHoras   duración en horas de la ruta
     * @param tipoEmbarcacion tipo de embarcación, modelo material, cantidad de pisos etc.
     */

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }


    /**
     * Devuelve los datos en forma de texto de los datos de PaseoLacustre
     *
     * @return Una cadena de texto estructurada con todos los datos heredados de ServicioTuristico más los datos de PaseoLacustre
     */

    @Override
    public String toString() {
        return "---PASEO LA CUSTRE---" + super.toString() +
                " |Tipo de Embarcación: " + tipoEmbarcacion;
    }

}
