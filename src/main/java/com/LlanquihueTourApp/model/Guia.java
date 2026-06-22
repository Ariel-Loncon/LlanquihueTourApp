package com.LlanquihueTourApp.model;
import com.LlanquihueTourApp.util.*;

public class Guia {

    private rut    rut;
    private String name;
    private email  email;


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

    @Override
    public String toString() {
        return " " +
                "| RUT: " + rut +
                "| Nombre: " + name +
                "| Email: " + email +
                '|';
    }
}
