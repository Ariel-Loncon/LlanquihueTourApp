package com.LlanquihueTourApp.data;

import com.LlanquihueTourApp.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorGlobal {
    private ArrayList<Registrable> baseDeDatos = new ArrayList<>();

    public void cargarTodo() {

        baseDeDatos.clear();

        // Carga centralizada
        baseDeDatos.addAll(new GestorDatos().readToursText("resources/tours.txt"));
        baseDeDatos.addAll(new GestorGuias().readGuiasText("resources/guias.txt"));
        baseDeDatos.addAll(new GestorOperadores().readOpLocalText("resources/operadores.txt"));
        baseDeDatos.addAll(new GestorServicios().readServiciosText("resources/Servicios.txt"));
    }

    public ArrayList<Registrable> getBaseDeDatos() {
        return baseDeDatos;
    }
}