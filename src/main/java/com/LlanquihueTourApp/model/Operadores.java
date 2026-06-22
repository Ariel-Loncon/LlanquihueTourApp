package com.LlanquihueTourApp.model;


public class Operadores{
    private String nombre;
    private String area;


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

    @Override
    public String toString() {
        return "|" +
                "| NOMBRE: " + nombre +
                "| AREA: " + area +
                '|';
    }
}
