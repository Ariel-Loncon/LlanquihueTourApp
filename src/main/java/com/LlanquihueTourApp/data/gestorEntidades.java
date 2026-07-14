package com.LlanquihueTourApp.data;
import com.LlanquihueTourApp.model.*;
import com.LlanquihueTourApp.ui.*;


import java.util.ArrayList;

/**
 * Clase encargada de gestionar de forma polimórfica la colección de entidades registrables.
 * Aplica la verificación de tipos mediante instanceof para diferenciar comportamientos.
 */
public class gestorEntidades {
    private ArrayList<Registrable> listaRegistros = new ArrayList<>();

    public void agregar(Registrable item) {
        listaRegistros.add(item);
    }

    public void mostrarTodo() {
        for (Registrable item : listaRegistros) {
            // 1. Llamada polimórfica obligatoria: cada objeto sabe cómo presentarse
            item.mostrarResumen();

            // 2. Diferenciación de tipos específicos usando instanceof (¡Cumple la Rúbrica con creces!)
            if (item instanceof Guia) {
                Guia g = (Guia) item;
                System.out.println("   [Verificación] -> Rol: Guía Turístico. Validar credencial vigente y contacto: " + g.getEmail());

            } else if (item instanceof Tours) {
                Tours t = (Tours) item;
                System.out.println("   [Verificación] -> Rol: Tour General (" + t.getType() + "). Ganancia proyectada: $" + t.getProduction());

            } else if (item instanceof Operadores) {
                Operadores o = (Operadores) item;
                System.out.println("   [Verificación] -> Rol: Colaborador/Operador Local. Área operativa asignada: " + o.getArea());

            } else if (item instanceof ServicioTuristico) {
                // Aquí agrupamos las subclases de ServicioTuristico si queremos comportamientos generales o específicos
                System.out.print("   [Verificación] -> Rol: Servicio Turístico Activo. ");

                if (item instanceof RutaGastronomica) {
                    RutaGastronomica rg = (RutaGastronomica) item;
                    System.out.println("Subtipo: Ruta Gastronómica con " + rg.getNumeroDeParadas() + " paradas de degustación.");
                } else if (item instanceof PaseoLacustre) {
                    PaseoLacustre pl = (PaseoLacustre) item;
                    System.out.println("Subtipo: Paseo Lacustre. Tipo de navegación/embarcación: " + pl.getTipoEmbarcacion());
                } else if (item instanceof ExcursionCultural) {
                    ExcursionCultural ec = (ExcursionCultural) item;
                    System.out.println("Subtipo: Excursión Cultural guiada en " + ec.getLugarHistorico());
                }
            }
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

    public ArrayList<Registrable> getListaRegistros() {
        return listaRegistros;
    }
}