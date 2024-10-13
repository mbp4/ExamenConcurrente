package org.example.examenconcurrente.model.sensores;


import org.example.examenconcurrente.model.VentanaSensores.VentanaSensores;

import java.util.concurrent.ScheduledExecutorService;

public class Sensor {
    private int maxMediciones;
    private String tipo;
    private Gauss gauss;
    private int contador;
    private VentanaSensores vs;

    public Sensor(String tipo, int maxMediciones, VentanaSensores vs){
        this.maxMediciones = maxMediciones;
        this.tipo = tipo;
        gauss = new Gauss(0,20,7);
        contador = 0;
        this.vs = vs;
    }

    // Genera una medición y la muestra en la ventana de sensores
    public void medir(ScheduledExecutorService ejecutor){
        int medida = gauss.gaussianRandom();
        vs.muestraPelotas(medida);
        contador++;
        if (contador == maxMediciones){
            ejecutor.shutdown();
        }
    }
}
