package com.LlanquihueTourApp.model;
import com.LlanquihueTourApp.util.*;

/**
 * Clase en cargada de gestionar los datos de los Guias
 *
 */

public class Guia {

    private rut    rut;
    private String name;
    private email  email;

    /**
     *
     * @param rut   RUT(Rol único tributario) número de identificación usado en Chile
     * @param name  nombre para la persona que hará de guía
     * @param email Dirección de correo electrónico del cliente
     */


    public Guia(rut rut, String name, email email) {
        this.rut = rut;
        setName(name);
        this.email = email;
    }

    public rut getRut() {
        return rut;
    }

    public void setRut(rut rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del guía no puede estar vacío.");
        }
        this.name = name;
    }

    public email getEmail() {
        return email;
    }

    public void setEmail(email email) {
        this.email = email;
    }

    /**
     * Devuelve una representación de los datos en forma de texto de la información del guía
     * incluye las etiquetas de nombre, RUT y Email
     * @return
     */

    @Override
    public String toString() {
        return " " +
                "| RUT: " + rut +
                "| Nombre: " + name +
                "| Email: " + email +
                '|';
    }
}
