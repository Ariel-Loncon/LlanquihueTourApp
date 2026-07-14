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



    @Override
    public void mostrarResumen() {
        System.out.print("---PASEO LA CUSTRE---");
        super.mostrarInformacion();
        System.out.println(" | Tipo de Embarcación: " + tipoEmbarcacion);
    }
    @Override
    public String[] getRowData() {
        return new String[]{"Paseo la Custre", this.getNombre(), String.valueOf(this.getDuracionHoras()), this.getTipoEmbarcacion().toString()};
    }
}
