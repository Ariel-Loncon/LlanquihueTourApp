package com.LlanquihueTourApp.data;
import com.LlanquihueTourApp.model.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase encargada de gestionar los datos de ServicioTuristico, RutaGastronomica, PaseoLacustre y ExcursionCultural
 */

public class GestorServicios {
    private List<ServicioTuristico> listaServicios;

    public GestorServicios() {
        listaServicios = new ArrayList<>();

        listaServicios.add(new RutaGastronomica("Ruta Sabores", 5, 2));
        listaServicios.add(new RutaGastronomica("Ruta licores", 3, 1));
        listaServicios.add(new PaseoLacustre("Ruta peninsula", 1, "Barco"));
        listaServicios.add(new PaseoLacustre("Ruta Laguna", 3, "Eléctrico"));
        listaServicios.add(new ExcursionCultural("Puerto Octay", 3, "Casa Werner"));
    }

        public void mostrarServicios() {
            for (ServicioTuristico servicio : listaServicios) {
                servicio.mostrarInformacion();
            }
        }
    }



