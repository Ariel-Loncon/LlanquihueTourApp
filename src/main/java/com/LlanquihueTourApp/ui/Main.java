package com.LlanquihueTourApp.ui;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {

                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                // Si falla el look and feel nativo, el programa igual abrirá con el diseño por defecto
                System.err.println("No se pudo establecer el Look and Feel nativo: " + e.getMessage());
            }


            JFrame ventana = new JFrame("Llanquihue Tour App - Sistema de Gestión");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(800, 500); // Dimensiones de la ventana principal
            ventana.setMinimumSize(new java.awt.Dimension(600, 400)); // Evita que la achiquen demasiado


            PanelPrincipal panelPrincipal = new PanelPrincipal();


            ventana.add(panelPrincipal);


            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}