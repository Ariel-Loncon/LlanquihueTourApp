package com.LlanquihueTourApp.data;

import com.LlanquihueTourApp.model.Guia;
import com.LlanquihueTourApp.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorGuias {
    public ArrayList<Guia> readGuiasText(String filePath) {
        //lista donde se almacenara la información
        ArrayList<Guia> guiasList = new ArrayList<>();
        //Se abre el archivo para la lectura

        if (!GestorArchivo.Archivo(filePath)) {
            System.out.println("El archivo no existe o no se puede acceder: " + filePath);
            return guiasList;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty())
                    continue;

                //Se separa la línea con ";"
                String[] data = line.split(";");

                if (data.length != 3){
                    System.out.println("Error en línea " + lineNumber + ": Estructura incorrecta de Guias (Se esperaban 3 campos, se encontraron " + data.length + ").");
                    continue;
                }

                try {
                    //Se transforman los datos al tipo correspondiente
                    rut r = new rut(data[0].trim());
                    String nombre = data[1].trim();
                    email e = new email(data[2].trim());
                    //Se crea un objeto NewTour con los datos leidos

                    Guia newGuia = new Guia(r,nombre,e);
                    guiasList.add(newGuia);

                } catch (IllegalArgumentException ex) {
                    System.out.println("Error de validación de Guias en linea: " + lineNumber + ": "+ ex.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo de guías: "+ e.getMessage());
        }
        return guiasList;
    }
}
