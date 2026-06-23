package com.LlanquihueTourApp.data;

import com.LlanquihueTourApp.model.Tours;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Clase encargada de gestionar los datos de Tours guardada enn el archivo de texto mediante Arraylist
 */

public class GestorDatos {

    public ArrayList<Tours> readToursText(String filePath){
        //lista donde se almacenara la información
        ArrayList<Tours> toursList = new ArrayList<>();
        //Se abre el archivo para la lectura

        if (!GestorArchivo.Archivo(filePath)){
            System.out.println("El archivo no existe o no se puede acceder: " + filePath);
            return toursList;
        }


        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int lineNumber = 0;

            //Se lee el archivo linea a linea
            while((line = br.readLine()) != null){
                lineNumber++;

                if(line.trim().isEmpty()){
                    continue;
                }

                //Se separa la línea con ";"
                String[] data = line.split(";");
                //Cantidad de espacios separados por ";", se valida que tenga 4 espacios
                if(data.length != 4) {
                    System.out.println("Error en línea " + lineNumber + ": Estructura incorrecta de Tours (Se esperaban 4 campos, se encontraron " + data.length + ").");
                    continue;
                }
                try{
                    //Se transforman los datos al tipo correspondiente
                    int id      = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String type = data[2].trim();
                    double production   = Double.parseDouble(data[3].trim());

                    //Se crea un objeto NewTour con los datos leidos
                    Tours newTour = new Tours(id, name, type, production);
                    //Se carga el objeto a la lista
                    toursList.add(newTour);
                }catch (NumberFormatException nfe) {
                    // Captura errores específicos de conversión numérica sin tumbar la lectura completa
                    System.out.println("Error de formato numérico en línea " + lineNumber + ": " + nfe.getMessage());
                }catch (IllegalArgumentException iae) {
                    System.out.println("Error de validación Tours en línea " + lineNumber + ": " + iae.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo" + e.getMessage());
        }
        return toursList;
    }
}

