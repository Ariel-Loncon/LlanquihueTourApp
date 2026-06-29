package com.LlanquihueTourApp.model;

public class PaseoLacustre extends ServicioTuristico{
    private String tipoEmbarcacion;

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
    public String toString() {
        return "---PASEO LA CUSTRE---" + super.toString() +
                " |Tipo de Embarcación: " + tipoEmbarcacion;
    }
}
