package com.LlanquihueTourApp.model;

public class ExcursionCultural extends ServicioTuristico{

    private String lugarHistorico;

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


    @Override
    public String toString() {
        return "---EXCURSION CULTURAL---" + super.toString() +
                " |Lugar histórico: " + lugarHistorico;
    }
}
