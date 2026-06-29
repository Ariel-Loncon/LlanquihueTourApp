package com.LlanquihueTourApp.data;
import com.LlanquihueTourApp.model.*;


public class GestorServicios {
    public void mostrarServicio() {

        RutaGastronomica rutaGastronomica1 = new RutaGastronomica("Ruta Sabores", 5, 2);
        RutaGastronomica rutaGastronomica2 = new RutaGastronomica("Ruta licores", 3, 1);

        PaseoLacustre paseoLacustre1 = new PaseoLacustre("Ruta peninsula", 1, "Embarcacion de dos pisos");
        PaseoLacustre paseoLacustre2 = new PaseoLacustre("Ruta Laguna de Rivera", 3, "Barco eléctrico");

        ExcursionCultural excursionCultural1 = new ExcursionCultural("Puerto Octay", 3, "Casa Werner");
        ExcursionCultural excursionCultural2 = new ExcursionCultural("Frutillar Bajo", 3, "Museo Colonial Alemán");

        System.out.println(rutaGastronomica1.toString());
        System.out.println(rutaGastronomica2.toString());
        System.out.println(paseoLacustre1.toString());
        System.out.println(paseoLacustre2.toString());
        System.out.println(excursionCultural1.toString());
        System.out.println(excursionCultural2.toString());
    }
}
