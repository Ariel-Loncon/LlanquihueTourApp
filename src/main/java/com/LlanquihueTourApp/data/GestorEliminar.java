package com.LlanquihueTourApp.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorEliminar {

    private static String limpiarRut(String rut) {
        if (rut == null) return "";
        return rut.replaceAll("[^0-9kK]", "").toLowerCase();
    }

    /**
     * Elimina un Tour de tours.txt buscando por su ID.
     */
    public static boolean eliminarTour(int idAEliminar) {
        String ruta = "resources/tours.txt";
        return eliminarLinea(ruta, ";", (campos) -> {
            // El ID de un Tour está en la posición 0
            try {
                int idActual = Integer.parseInt(campos[0].trim());
                return idActual == idAEliminar;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }

    /**
     * Elimina un Guía de guias.txt buscando por su RUT.
     */
    public static boolean eliminarGuia(String rutAEliminar) {
        String ruta = "resources/guias.txt";
        return eliminarLinea(ruta, ";", (campos) -> {
            // El RUT del Guía está en la posición 0
            String rutActual = campos[0].trim();
            return rutActual.equalsIgnoreCase(rutAEliminar.trim());
        });
    }

    /**
     * Elimina un Operador de operadores.txt buscando por su Nombre.
     */
    public static boolean eliminarOperador(String nombreAEliminar) {
        String ruta = "resources/operadores.txt";
        return eliminarLinea(ruta, ";", (campos) -> {
            // El Nombre del Operador está en la posición 0
            String nombreActual = campos[0].trim();
            return nombreActual.equalsIgnoreCase(nombreAEliminar.trim());
        });
    }

    /**
     * Elimina un Servicio de Servicios.txt buscando por su Tipo y su Nombre.
     */
    public static boolean eliminarServicio(String tipo, String nombreServicioAEliminar) {
        String ruta = "resources/Servicios.txt";

        final String tipoCorregido = tipo.replace("Excurcion", "Excursion");

        return eliminarLinea(ruta, ",", (campos) -> {
            if (campos.length < 2) return false;
            String tipoActual = campos[0].trim();
            String nombreActual = campos[1].trim();

            return tipoActual.equalsIgnoreCase(tipoCorregido) &&
                    nombreActual.equalsIgnoreCase(nombreServicioAEliminar.trim());
        });
    }

    /**
     * Método genérico para procesar la eliminación física en el archivo.
     */
    private static boolean eliminarLinea(String filePath, String separador, CriterioBusqueda criterio) {
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }

        List<String> lineasAConservar = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] campos = line.split(separador);
                if (criterio.debeEliminar(campos)) {
                    encontrado = true; // Se marca como encontrado y NO se añade a la lista (se elimina)
                } else {
                    lineasAConservar.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo para eliminar: " + e.getMessage());
            return false;
        }

        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
                for (String linea : lineasAConservar) {
                    bw.write(linea);
                    bw.newLine();
                }
                return true;
            } catch (IOException e) {
                System.err.println("Error al escribir archivo tras eliminar: " + e.getMessage());
                return false;
            }
        }

        return false;
    }

    @FunctionalInterface
    private interface CriterioBusqueda {
        boolean debeEliminar(String[] campos);
    }
}
