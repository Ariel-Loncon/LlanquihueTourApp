package com.LlanquihueTourApp.data;

import com.LlanquihueTourApp.model.Operadores;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar los datos de Operadores guardada enn el archivo de texto mediante Arraylist
 */

public class GestorOperadores {
    public ArrayList<Operadores> readOpLocalText(String filePath) {
        //lista donde se almacenara la información
        ArrayList<Operadores> OpLocalList = new ArrayList<>();
        //Se abre el archivo para la lectura

        if (!GestorArchivo.Archivo(filePath)) {
            System.out.println("El archivo no existe o no se puede acceder: " + filePath);
            return OpLocalList;
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

                if (data.length != 2){
                    System.out.println("Error en línea " + lineNumber + ": Estructura incorrecta de Operadores (Se esperaban 2 campos, se encontraron " + data.length + ").");
                    continue;
                }

                try {
                    //Se transforman los datos al tipo correspondiente
                    String oNombre = data[0].trim();
                    String oArea = data[1].trim();

                    Operadores newOpLocal = new Operadores(oNombre,oArea);
                    OpLocalList.add(newOpLocal);

                } catch (IllegalArgumentException ex) {
                    System.out.println("Error de validación de Operadores en linea: " + lineNumber + ": "+ ex.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo de guías: "+ e.getMessage());
        }
        return OpLocalList;
    }
}
