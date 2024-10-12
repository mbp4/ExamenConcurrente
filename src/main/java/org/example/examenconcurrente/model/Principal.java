package org.example.examenconcurrente.model;

import org.example.examenconcurrente.model.VentanaSensores.VentanaSensores;

public class Principal {

    public static void main(String[] args) {
        /*
        Sensor sensorH = new Sensor("Humedad", 10);

        ScheduledExecutorService ejecutorH = Executors.newScheduledThreadPool(8);

        ejecutorH.scheduleAtFixedRate(() -> sensorH.medir(ejecutorH), 0, 2, TimeUnit.SECONDS);
         */

        VentanaSensores vs = new VentanaSensores();
        vs.setVisible(true);

    }

}
