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


    @Override
    public void mostrarResumen() {
        System.out.print("---EXCURSION CULTURAL---");
        super.mostrarInformacion();
        System.out.println(" | Lugar histórico: " + lugarHistorico);
    }
    @Override
    public String[] getRowData() {
        return new String[]{"Excursion Cultural", this.getNombre(), String.valueOf(this.getDuracionHoras()), this.getLugarHistorico()};
    }
}
