package com.LlanquihueTourApp.model;

/**
 * Clase encargada de gestionar los datos del operador local
 */

public class Operadores{
    private String nombre;
    private String area;


    /**
     *
     * @param nombre Nombre del operador local de la zona
     * @param area   Aréa en el que se desempeña el operador local
     */

    public Operadores(String nombre, String area) {
        setNombre(nombre);
        setArea(area);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del operador no puede estar vacío.");
        }
        this.nombre = nombre;
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
    public String toString() {
        return "|" +
                "| NOMBRE: " + nombre +
                "| AREA: " + area +
                '|';
    }
}
