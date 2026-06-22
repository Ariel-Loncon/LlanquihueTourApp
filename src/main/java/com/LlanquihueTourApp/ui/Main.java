package com.LlanquihueTourApp.ui;

import com.LlanquihueTourApp.data.*;
import com.LlanquihueTourApp.model.*;
import com.LlanquihueTourApp.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Se crea un objeto de la clase gestorDatos
        GestorDatos gestor = new GestorDatos();
        String filePath = "resources/tours.txt";
        ArrayList<Tours> fullList = gestor.readToursText(filePath);

        GestorGuias gestorGuias = new GestorGuias();
        String pathGuias = "resources/guias.txt";
        ArrayList<Guia> listaGuias = gestorGuias.readGuiasText(pathGuias);

        GestorOperadores gestorOperadores = new GestorOperadores();
        String pathOpLocal = "resources/operadores.txt";
        ArrayList<Operadores> listaOp = gestorOperadores.readOpLocalText(pathOpLocal);

        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n--- MENÚ DE CONSULTAS ---");
            System.out.println("1. Listar todos los Tours");
            System.out.println("2. Filtrar Tours por producción (> 10000)");
            System.out.println("3. Filtrar Tours por tipo (Gastronomía, etc.)");
            System.out.println("4. Listar todos los Guías");
            System.out.println("5. Listar todos los Operadores locales");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("---LISTA DE TOURS---");
                    for (Tours t : fullList) {
                        System.out.println(t);
                    }
                    break;
                case 2:
                    fullList.stream()
                            .filter(t -> t.getProduction() > 10000)
                            .forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Ingrese el tipo de tour a buscar: ");
                    String tipo = sc.nextLine();
                    fullList.stream()
                            .filter(t -> t.getType().equalsIgnoreCase(tipo))
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("---LISTA DE GUIAS---");
                    for (Guia t : listaGuias) {
                        System.out.println(t);
                    }
                    break;
                case 5:
                    System.out.println("---LISTA DE OPERADORES LOCALES---");
                    for (Operadores t : listaOp) {
                        System.out.println(t);
                    }
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        }
        sc.close();

    }
}