package org.example.examenconcurrente.VentanaSensores;


import org.example.examenconcurrente.sensores.Sensor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VentanaSensores extends JFrame{
    private JButton botonTemperatura;
    private JPanel panel1;
    private JTable tablaTemperatura;
    private JScrollPane scrollPaneTemperatura;

    public VentanaSensores(){
        this.setSize(new Dimension(3000, 2000));
        this.getContentPane().setLayout(null);
        botonTemperatura = new JButton("Botón Temperatura");
        botonTemperatura.setBounds(10, 10, 300, 30);
        this.add(botonTemperatura);
        crearTablaTemperatura();
    }

    private void crearTablaTemperatura() {
        String[] nombresColumnas = {"Valor", "Mediciones", "Gráfica"};
        Object[][] datos = new Object[21][3];

        for (int i = 0; i < 21; i++){
            datos[i][0] = i;
            datos[i][1] = 0;
            datos[i][2] = "";
        }

        tablaTemperatura = new JTable(datos, nombresColumnas);
        tablaTemperatura.getColumnModel().getColumn(0).setMaxWidth(50);
        tablaTemperatura.getColumnModel().getColumn(1).setMaxWidth(50);
        scrollPaneTemperatura = new JScrollPane();

        scrollPaneTemperatura.setViewportView(tablaTemperatura);
        scrollPaneTemperatura.setBounds(10, 50, 1000, 500);
        this.add(scrollPaneTemperatura);

        botonTemperatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empezarMedicionTemperatura();
            }
        });
    }

    private void empezarMedicionTemperatura() {
        Sensor sensorT = new Sensor("Temperatura", 2000, this);
        ScheduledExecutorService ejecutorT = Executors.newScheduledThreadPool(8);
        ejecutorT.scheduleAtFixedRate(() -> sensorT.medir(ejecutorT), 0, 100, TimeUnit.MILLISECONDS);
    }

    public void muestraTemperatura(int medida) {

        if (medida >= 0 && medida < tablaTemperatura.getRowCount()){
            int valorActual = (int)tablaTemperatura.getValueAt(medida, 1);
            int nuevoValor = valorActual + 1;
            tablaTemperatura.setValueAt(nuevoValor, medida,1);
            String nuevaGrafica = generarGrafico(nuevoValor);
            tablaTemperatura.setValueAt(nuevaGrafica, medida, 2);
        }
    }

    private String generarGrafico(int nuevoValor) {
        StringBuilder grafico = new StringBuilder();

        for (int i = 0; i < nuevoValor; i++){
            grafico.append("|");
        }

        return grafico.toString();
    }
}
