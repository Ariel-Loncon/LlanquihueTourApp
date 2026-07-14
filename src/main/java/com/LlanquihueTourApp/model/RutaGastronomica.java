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



    @Override
    public void mostrarResumen() {
        System.out.print("---RUTA GASTRONÓMICA---");
        super.mostrarInformacion();
        System.out.println(" | Paradas: " + numeroDeParadas);
    }

    @Override
    public String[] getRowData() {
        return new String[]{"Ruta Gastronomica", this.getNombre(),String.valueOf(this.getDuracionHoras()), String.valueOf(this.getNumeroDeParadas())};
    }
}

