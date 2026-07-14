package com.LlanquihueTourApp.ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VentanaAgregar extends JDialog {

    private JComboBox<String> comboOpciones;
    private JPanel panelFormularios; // Contenedor dinámico
    private CardLayout cardLayout;

    // --- CAMPOS PARA TOURS ---
    private JTextField txtTourId, txtTourNombre, txtTourTipo, txtTourProd;

    // --- CAMPOS PARA GUIA ---
    private JTextField txtGuiaRut, txtGuiaNombre, txtGuiaEmail;

    // --- CAMPOS PARA OPERADORES ---
    private JTextField txtOpNombre, txtOpArea;

    // --- CAMPOS PARA RUTA GASTRONOMICA ---
    private JTextField txtRutaNombre, txtRutaValor, txtRutaAtracciones;

    // --- CAMPOS PARA PASEO LACUSTRE ---
    private JTextField txtPaseoNombre, txtPaseoValor, txtPaseoDestino;

    // --- CAMPOS PARA EXCURSION CULTURAL ---
    private JTextField txtExcurNombre, txtExcurValor, txtExcurDetalle;

    private JButton btnGuardar;
    private JButton btnCancelar;

    public VentanaAgregar(Frame padre) {
        super(padre, "Agregar Nuevo Registro", true);
        setSize(450, 350);
        setLocationRelativeTo(padre);
        setLayout(new BorderLayout(10, 10));

        // Margen de la ventana
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // 1. Selector Superior
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(new JLabel("Seleccione Tipo: "));
        comboOpciones = new JComboBox<>(new String[]{
                "Tours", "Guia", "Operadores", "RutaGastronomica", "PaseoLacustre", "ExcursionCultural"
        });
        panelSuperior.add(comboOpciones);
        add(panelSuperior, BorderLayout.NORTH);

        // 2. Inicializar el contenedor dinámico con CardLayout
        cardLayout = new CardLayout();
        panelFormularios = new JPanel(cardLayout);

        inicializarFormularios(); // Crea todas las "tarjetas" de formularios
        add(panelFormularios, BorderLayout.CENTER);

        // 3. Botones Inferiores
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panelInferior.add(btnGuardar);
        panelInferior.add(btnCancelar);
        add(panelInferior, BorderLayout.SOUTH);

        // 4. Listeners y Eventos
        configurarEventos();
    }

    private void inicializarFormularios() {
        // --- FORMULARIO TOURS ---
        JPanel pTours = new JPanel(new GridLayout(4, 2, 5, 5));
        pTours.add(new JLabel("ID (Numérico):")); txtTourId = new JTextField(); pTours.add(txtTourId);
        pTours.add(new JLabel("Nombre:")); txtTourNombre = new JTextField(); pTours.add(txtTourNombre);
        pTours.add(new JLabel("Tipo:")); txtTourTipo = new JTextField(); pTours.add(txtTourTipo);
        pTours.add(new JLabel("Producción ($):")); txtTourProd = new JTextField(); pTours.add(txtTourProd);
        panelFormularios.add(pTours, "Tours");

        // --- FORMULARIO GUIA ---
        JPanel pGuia = new JPanel(new GridLayout(3, 2, 5, 5));
        pGuia.add(new JLabel("RUT (ej: 12345678-9):")); txtGuiaRut = new JTextField(); pGuia.add(txtGuiaRut);
        pGuia.add(new JLabel("Nombre Completo:")); txtGuiaNombre = new JTextField(); pGuia.add(txtGuiaNombre);
        pGuia.add(new JLabel("Email:")); txtGuiaEmail = new JTextField(); pGuia.add(txtGuiaEmail);
        panelFormularios.add(pGuia, "Guia");

        // --- FORMULARIO OPERADORES ---
        JPanel pOperadores = new JPanel(new GridLayout(2, 2, 5, 5));
        pOperadores.add(new JLabel("Nombre Operador:")); txtOpNombre = new JTextField(); pOperadores.add(txtOpNombre);
        pOperadores.add(new JLabel("Área / Cobertura:")); txtOpArea = new JTextField(); pOperadores.add(txtOpArea);
        panelFormularios.add(pOperadores, "Operadores");

        // --- FORMULARIO RUTA GASTRONOMICA ---
        JPanel pRuta = new JPanel(new GridLayout(3, 2, 5, 5));
        pRuta.add(new JLabel("Nombre Local:")); txtRutaNombre = new JTextField(); pRuta.add(txtRutaNombre);
        pRuta.add(new JLabel("Valor ($):")); txtRutaValor = new JTextField(); pRuta.add(txtRutaValor);
        pRuta.add(new JLabel("Cantidad Atracciones:")); txtRutaAtracciones = new JTextField(); pRuta.add(txtRutaAtracciones);
        panelFormularios.add(pRuta, "RutaGastronomica");

        // --- FORMULARIO PASEO LACUSTRE ---
        JPanel pPaseo = new JPanel(new GridLayout(3, 2, 5, 5));
        pPaseo.add(new JLabel("Nombre Embarcación:")); txtPaseoNombre = new JTextField(); pPaseo.add(txtPaseoNombre);
        pPaseo.add(new JLabel("Tarifa ($):")); txtPaseoValor = new JTextField(); pPaseo.add(txtPaseoValor);
        pPaseo.add(new JLabel("Destino / Ruta:")); txtPaseoDestino = new JTextField(); pPaseo.add(txtPaseoDestino);
        panelFormularios.add(pPaseo, "PaseoLacustre");

        // --- FORMULARIO EXCURSION CULTURAL ---
        JPanel pExcur = new JPanel(new GridLayout(3, 2, 5, 5));
        pExcur.add(new JLabel("Lugar Histórico:")); txtExcurNombre = new JTextField(); pExcur.add(txtExcurNombre);
        pExcur.add(new JLabel("Precio Guía ($):")); txtExcurValor = new JTextField(); pExcur.add(txtExcurValor);
        pExcur.add(new JLabel("Detalles:")); txtExcurDetalle = new JTextField(); pExcur.add(txtExcurDetalle);
        panelFormularios.add(pExcur, "ExcursionCultural");
    }

    private void configurarEventos() {
        // Al cambiar el ComboBox, alternamos el formulario mostrado
        comboOpciones.addActionListener(e -> {
            String seleccion = (String) comboOpciones.getSelectedItem();
            // Controlamos si el combo usa "ExcursionCultural" internamente para llamarlo igual que la tarjeta
            if (seleccion.equals("ExcursionCultural") || seleccion.equals("ExcursionCultural")) {
                cardLayout.show(panelFormularios, "ExcursionCultural");
            } else {
                cardLayout.show(panelFormularios, seleccion);
            }
        });

        // Botón Cancelar
        btnCancelar.addActionListener(e -> dispose());

        // Botón Guardar
        btnGuardar.addActionListener(e -> guardarRegistro());
    }

    private void guardarRegistro() {
        String seleccion = (String) comboOpciones.getSelectedItem();

        try {
            switch (seleccion) {
                case "Tours":
                    // Validación básica
                    if(txtTourId.getText().isEmpty() || txtTourNombre.getText().isEmpty()) {
                        throw new IllegalArgumentException("Debe completar los campos del Tour.");
                    }
                    // Formato: id; name; type; production
                    String lineaTour = String.format("%s;%s;%s;%s",
                            txtTourId.getText().trim(),
                            txtTourNombre.getText().trim(),
                            txtTourTipo.getText().trim(),
                            txtTourProd.getText().trim());

                    escribirEnArchivo("resources/tours.txt", lineaTour);
                    break;

                case "Guia":
                    if(txtGuiaRut.getText().isEmpty() || txtGuiaNombre.getText().isEmpty()) {
                        throw new IllegalArgumentException("Debe completar los campos del Guía.");
                    }
                    // Formato: rut; nombre; email
                    String lineaGuia = String.format("%s;%s;%s",
                            txtGuiaRut.getText().trim(),
                            txtGuiaNombre.getText().trim(),
                            txtGuiaEmail.getText().trim());

                    escribirEnArchivo("resources/guias.txt", lineaGuia);
                    break;

                case "Operadores":
                    if(txtOpNombre.getText().isEmpty() || txtOpArea.getText().isEmpty()) {
                        throw new IllegalArgumentException("Debe completar los campos del Operador.");
                    }
                    // Formato: nombre; area
                    String lineaOp = String.format("%s;%s",
                            txtOpNombre.getText().trim(),
                            txtOpArea.getText().trim());

                    escribirEnArchivo("resources/operadores.txt", lineaOp);
                    break;

                case "RutaGastronomica":
                    if(txtRutaNombre.getText().isEmpty() || txtRutaValor.getText().isEmpty()) {
                        throw new IllegalArgumentException("Debe completar los campos.");
                    }
                    // Formato en servicios: Tipo, Nombre, Valor, Atracciones/Detalle
                    String lineaRuta = String.format("RutaGastronomica,%s,%s,%s",
                            txtRutaNombre.getText().trim(),
                            txtRutaValor.getText().trim(),
                            txtRutaAtracciones.getText().trim());

                    escribirEnArchivo("resources/Servicios.txt", lineaRuta);
                    break;

                case "PaseoLacustre":
                    if(txtPaseoNombre.getText().isEmpty() || txtPaseoValor.getText().isEmpty()) {
                        throw new IllegalArgumentException("Debe completar los campos.");
                    }
                    // Formato: PaseoLacustre, Nombre, Valor, Destino
                    String lineaPaseo = String.format("PaseoLacustre,%s,%s,%s",
                            txtPaseoNombre.getText().trim(),
                            txtPaseoValor.getText().trim(),
                            txtPaseoDestino.getText().trim());

                    escribirEnArchivo("resources/Servicios.txt", lineaPaseo);
                    break;

                //case "ExcursionCultural":
                case "ExcursionCultural":
                    if(txtExcurNombre.getText().isEmpty() || txtExcurValor.getText().isEmpty()) {
                        throw new IllegalArgumentException("Debe completar los campos.");
                    }
                    // Formato: ExcursionCultural, Nombre, Valor, Detalles
                    String lineaExcur = String.format("ExcursionCultural,%s,%s,%s",
                            txtExcurNombre.getText().trim(),
                            txtExcurValor.getText().trim(),
                            txtExcurDetalle.getText().trim());

                    escribirEnArchivo("resources/Servicios.txt", lineaExcur);
                    break;
            }

            JOptionPane.showMessageDialog(this, "¡Datos agregados correctamente al archivo .txt!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cierra la ventana emergente

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Error de formato numérico: por favor verifique los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Escribe en el archivo de texto especificado haciendo un append (añadiendo al final)
     */
    private void escribirEnArchivo(String ruta, String linea) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            bw.write(linea);
            bw.newLine();
        }
    }
}
