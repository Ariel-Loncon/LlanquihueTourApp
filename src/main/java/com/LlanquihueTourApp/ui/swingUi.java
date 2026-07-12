package com.LlanquihueTourApp.ui;

import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class swingUi {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JTable tablaDatos;
    private JButton salirButton;

    public swingUi() {
        tablaDatos.addComponentListener(new ComponentAdapter() {
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("swingUi");
        frame.setContentPane(new swingUi().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

