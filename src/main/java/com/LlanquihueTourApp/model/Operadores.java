package com.LlanquihueTourApp.model;

/**
 * Clase encargada de gestionar los datos del operador local
 */

public class Operadores implements Registrable{
    private String oName;
    private String area;


    /**
     *
     * @param nombre Nombre del operador local de la zona
     * @param area   Aréa en el que se desempeña el operador local
     */

    public Operadores(String nombre, String area) {
        setoName(nombre);
        setArea(area);
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        if (oName == null || oName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del operador no puede estar vacío.");
        }
        this.oName = oName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if (area == null || area.trim().isEmpty()) {
            throw new IllegalArgumentException("El área del operador no puede estar vacía.");
        }
        this.area = area;
    }

    /**
     * Devuelve una representación de los datos en forma de texto de la información del operador local.
     * incluye las etiquetas de nombre y arèa.
     * @return
     */

    @Override
    public void mostrarResumen() {
        System.out.println("OPERADORES: " + oName + area);

    }
    @Override
    public String[] getRowData() {
        return new String[]{"Operadores", this.getoName(), this.getArea()};
    }
}
