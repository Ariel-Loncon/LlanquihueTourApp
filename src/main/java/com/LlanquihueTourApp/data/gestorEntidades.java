package com.LlanquihueTourApp.data;
import com.LlanquihueTourApp.model.*;
import com.LlanquihueTourApp.ui.*;


import java.util.ArrayList;

/**
 * Clase encargada de gestionar de forma polimórfica la colección de entidades registrables.
 * Aplica la verificación de tipos mediante instanceof para diferenciar comportamientos.
 */
public class gestorEntidades {
    private ArrayList<Registrable> baseDeDatos = new ArrayList<>();

    public void cargarTodo() {

        baseDeDatos.clear();

        baseDeDatos.addAll(new GestorDatos().readToursText("resources/tours.txt"));
        baseDeDatos.addAll(new GestorGuias().readGuiasText("resources/guias.txt"));
        baseDeDatos.addAll(new GestorOperadores().readOpLocalText("resources/operadores.txt"));
        baseDeDatos.addAll(new GestorServicios().readServiciosText("resources/Servicios.txt"));
    }

    public void agregar(Registrable item) {
        baseDeDatos.add(item);
    }

    public ArrayList<Registrable> getBaseDeDatos() {
        return baseDeDatos;
    }


    public void mostrarTodo() {
        for (Registrable item : baseDeDatos) {

            item.mostrarResumen();

            if (item instanceof Guia) {
                Guia g = (Guia) item;
                System.out.println(" Email: : " + g.getEmail());

            } else if (item instanceof Tours) {
                Tours t = (Tours) item;
                System.out.println(" Tipo " + t.getType() + "Producción:" + t.getProduction());

            } else if (item instanceof Operadores) {
                Operadores o = (Operadores) item;
                System.out.println(" Area: " + o.getArea());

            } else if (item instanceof ServicioTuristico) {
                System.out.print("   [Verificación] -> Rol: Servicio Turístico Activo. ");

                if (item instanceof RutaGastronomica) {
                    RutaGastronomica rg = (RutaGastronomica) item;
                    System.out.println("Paradas:" + rg.getNumeroDeParadas());
                } else if (item instanceof PaseoLacustre) {
                    PaseoLacustre pl = (PaseoLacustre) item;
                    System.out.println("Embarcación: " + pl.getTipoEmbarcacion());
                } else if (item instanceof ExcursionCultural) {
                    ExcursionCultural ec = (ExcursionCultural) item;
                    System.out.println("Lugar: " + ec.getLugarHistorico());
                }
            }
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

}