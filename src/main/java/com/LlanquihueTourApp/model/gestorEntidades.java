package com.LlanquihueTourApp.model;
import java.util.ArrayList;

public class gestorEntidades {
    private ArrayList<Registrable> listaRegistros = new ArrayList<>();

    public void agregar(Registrable item) {
        listaRegistros.add(item);
    }

    public void mostrarTodo() {
        for (Registrable item : listaRegistros) {
            // Llamada polimórfica (se ejecuta el método de la clase real)
            item.mostrarResumen();

            // Diferenciación por tipo usando instanceof [cite: 204]
            if (item instanceof Guia) {
                System.out.println("-> Es un guía, verificar credenciales.");
            } else if (item instanceof Tours) {
                System.out.println("-> Es un tour, verificar disponibilidad de cupos.");
            }
        }
    }
}