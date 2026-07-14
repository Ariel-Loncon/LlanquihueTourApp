package com.LlanquihueTourApp.ui;

import com.LlanquihueTourApp.data.*;
import com.LlanquihueTourApp.model.*; // Importamos tus modelos (Tour, Guia, Operador, etc.)

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelPrincipal extends JPanel {

    private JButton btnVer;
    private JButton btnAgregar;
    private JButton btnSalir;
    private JComboBox<String> comboOpciones;
    private JTable tablaDatos;
    private DefaultTableModel modeloTabla;
    private JButton btnEliminar;

    // Instanciamos tu GestorGlobal de datos
    private GestorGlobal gestorGlobal;

    public PanelPrincipal() {
        // Inicializamos tu gestor y cargamos los datos desde los archivos .txt
        gestorGlobal = new GestorGlobal();
        try {
            gestorGlobal.cargarTodo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los archivos .txt iniciales: " + e.getMessage(),
                    "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        crearZonaSuperior();
        crearZonaCentral();
        crearZonaInferior();

        configurarEventos();
    }

    private void crearZonaSuperior() {
        JPanel panelSuperior = new JPanel(new BorderLayout());

        JPanel panelIzquierdo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btnVer = new JButton("Ver");

        // ComboBox con tus opciones exactas
        comboOpciones = new JComboBox<>(new String[]{
                "Seleccione Opción...",
                "Tours",
                "Guia",
                "Operadores",
                "RutaGastronomica",
                "PaseoLacustre",
                "ExcursionCultural"
        });

        panelIzquierdo.add(btnVer);
        panelIzquierdo.add(comboOpciones);

        JPanel panelDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
       // btnEliminar.setBackground(new Color(231, 76, 60)); // Color rojo elegante para advertir peligro
       // btnEliminar.setForeground(Color.WHITE);
        panelDerecho.add(btnAgregar);
        panelDerecho.add(btnEliminar);

        panelSuperior.add(panelIzquierdo, BorderLayout.WEST);
        panelSuperior.add(panelDerecho, BorderLayout.EAST);

        add(panelSuperior, BorderLayout.NORTH);
    }

    private void crearZonaCentral() {
        // Inicializamos el modelo vacío sin columnas fijas (se construirán dinámicamente)
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Bloquea la edición directa por doble clic
            }
        };
        tablaDatos = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaDatos);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void crearZonaInferior() {
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        btnSalir = new JButton("Salir");
        panelInferior.add(btnSalir);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void configurarEventos() {
        // Evento para el botón VER
        btnVer.addActionListener(e -> {
            String seleccion = (String) comboOpciones.getSelectedItem();
            cargarDatosEnTabla(seleccion);
        });

        // Evento para el botón AGREGAR
        btnAgregar.addActionListener(e -> {
            Window ancestro = SwingUtilities.getWindowAncestor(this);
            VentanaAgregar dialogo = new VentanaAgregar((Frame) ancestro);
            dialogo.setVisible(true);

            // Cuando la ventana de agregar se cierre, recargamos la lista desde los archivos
            gestorGlobal.cargarTodo();

            // Refrescamos la tabla con la selección actual para que se vea el nuevo elemento
            cargarDatosEnTabla((String) comboOpciones.getSelectedItem());
        });

        // Acción del botón ELIMINAR
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tablaDatos.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro de la tabla para eliminar.",
                        "Ninguna fila seleccionada", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String opcionActual = (String) comboOpciones.getSelectedItem();

            String claveId = "";
            String nombreElemento = "";

            // Asignación correcta de variables según el diseño exacto de las columnas de cada tabla
            switch (opcionActual) {
                case "Tours":
                    // Columnas: {"ID", "Nombre del Tour", "Valor produccion"}
                    claveId = tablaDatos.getValueAt(filaSeleccionada, 0).toString(); // ID
                    nombreElemento = tablaDatos.getValueAt(filaSeleccionada, 1).toString(); // Nombre
                    break;

                case "Guia":
                    // Columnas: {"Nombre", "RUT", "Correo electrónico"}
                    claveId = tablaDatos.getValueAt(filaSeleccionada, 1).toString(); // El RUT está en la columna 1
                    nombreElemento = tablaDatos.getValueAt(filaSeleccionada, 0).toString(); // El Nombre está en la columna 0
                    break;

                case "Operadores":
                    // Columnas: {"Nombre", "Area de servicio"}
                    claveId = tablaDatos.getValueAt(filaSeleccionada, 0).toString(); // Nombre
                    nombreElemento = tablaDatos.getValueAt(filaSeleccionada, 0).toString(); // Nombre
                    break;

                case "RutaGastronomica":
                case "PaseoLacustre":
                case "ExcursionCultural":
                    // Columnas para Servicios: {"Nombre", "Duración Horas", "..."}
                    claveId = ""; // No se usa ID para servicios
                    nombreElemento = tablaDatos.getValueAt(filaSeleccionada, 0).toString(); // El Nombre está en la columna 0
                    break;
            }

            // Confirmar eliminación con el usuario
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar a: " + nombreElemento + "?",
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (respuesta == JOptionPane.YES_OPTION) {
                boolean exito = false;

                switch (opcionActual) {
                    case "Tours":
                        try {
                            int idTour = Integer.parseInt(claveId);
                            exito = GestorEliminar.eliminarTour(idTour);
                        } catch (NumberFormatException nfe) {
                            exito = false;
                        }
                        break;
                    case "Guia":
                        exito = GestorEliminar.eliminarGuia(claveId);
                        break;
                    case "Operadores":
                        exito = GestorEliminar.eliminarOperador(claveId);
                        break;
                    case "RutaGastronomica":
                        exito = GestorEliminar.eliminarServicio("RutaGastronomica", nombreElemento);
                        break;
                    case "PaseoLacustre":
                        exito = GestorEliminar.eliminarServicio("PaseoLacustre", nombreElemento);
                        break;
                    case "ExcursionCultural":
                        exito = GestorEliminar.eliminarServicio("ExcursionCultural", nombreElemento);
                        break;
                }

                if (exito) {
                    JOptionPane.showMessageDialog(this, "¡Registro eliminado exitosamente!");
                    // Recargamos los datos en memoria del GestorGlobal y actualizamos la tabla
                    gestorGlobal.cargarTodo();
                    cargarDatosEnTabla(opcionActual);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el registro en el archivo de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Evento para el botón SALIR
        btnSalir.addActionListener(e -> System.exit(0));
    }

    /**
     * Filtra los datos usando el GestorGlobal y actualiza dinámicamente
     * tanto las columnas como las filas del JTable.
     */
    private void cargarDatosEnTabla(String opcion) {
        if (opcion == null || opcion.equals("Seleccione Opción...")) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una opción válida.");
            return;
        }

        modeloTabla.setColumnCount(0);
        modeloTabla.setRowCount(0);

        try {
            switch (opcion) {
                case "Tours":
                    // Definimos columnas correspondientes a un Tour
                    modeloTabla.setColumnIdentifiers(new Object[]{"ID", "Nombre del Tour", "Valor produccion"});

                    // Tu método filtrarPorTipo devuelve mágicamente sólo los objetos de tipo Tour
                    List<Tours> tours = gestorGlobal.filtrarPorTipo(Tours.class);
                    for (Tours t : tours) {
                        modeloTabla.addRow(new Object[]{t.getId(), t.gettName(), "$" + t.getProduction()});
                    }
                    break;

                case "Guia":
                    // Columnas de un Guía
                    modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "RUT", "Correo electrónico"});

                    List<Guia> guias = gestorGlobal.filtrarPorTipo(Guia.class);
                    for (Guia g : guias) {
                        modeloTabla.addRow(new Object[]{g.getgName(), g.getRut(), g.getEmail()});
                    }
                    break;

                case "Operadores":
                    // Columnas de un Operador
                    modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Area de servicio"});

                    List<Operadores> operadores = gestorGlobal.filtrarPorTipo(Operadores.class);
                    for (Operadores op : operadores) {
                        modeloTabla.addRow(new Object[]{op.getoName(), op.getArea()});
                    }
                    break;

                case "RutaGastronomica":
                    modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Duración Horas", "Numero de paradas"});

                    List<RutaGastronomica> serviciosG = gestorGlobal.filtrarPorTipo(RutaGastronomica.class);
                    for (RutaGastronomica s : serviciosG) {
                        if (s instanceof RutaGastronomica) {
                            RutaGastronomica rg = (RutaGastronomica) s;
                            modeloTabla.addRow(new Object[]{rg.getNombre(), rg.getDuracionHoras(), rg.getNumeroDeParadas()});
                        }
                    }
                    break;

                case "PaseoLacustre":
                    modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Duración Horas", "Tipo de Embarcacion"});

                    List<PaseoLacustre> serviciosL = gestorGlobal.filtrarPorTipo(PaseoLacustre.class);
                    for (PaseoLacustre s : serviciosL) {
                        if (s instanceof PaseoLacustre) {
                            PaseoLacustre pl = (PaseoLacustre) s;
                            modeloTabla.addRow(new Object[]{pl.getNombre(), pl.getDuracionHoras(), pl.getTipoEmbarcacion()});
                        }
                    }
                    break;

                case "ExcursionCultural":
                    modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Duración Horas", "Lugar histórico"});

                    List<ExcursionCultural> serviciosC = gestorGlobal.filtrarPorTipo(ExcursionCultural.class);
                    for (ExcursionCultural s : serviciosC) {
                        if (s instanceof ExcursionCultural) {
                            ExcursionCultural ec = (ExcursionCultural) s;
                            modeloTabla.addRow(new Object[]{ec.getNombre(), ec.getDuracionHoras(), ec.getLugarHistorico()});
                        }
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(this, "Esta opción aún no cuenta con un mapeo de columnas.");
                    break;
            }

            // Si la tabla quedó vacía, avisar amistosamente
            if (modeloTabla.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron registros para: " + opcion, "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error procesando los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}