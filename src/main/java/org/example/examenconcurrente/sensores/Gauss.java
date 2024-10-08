package org.example.examenconcurrente.sensores;

import java.util.Random;

public class Gauss {
    private double min;
    private double max;
    private double stdDev;

    public Gauss(double min, double max, double stdDev){
        this.min = min;
        this.max = max;
        this.stdDev = stdDev;
    }

    public int gaussianRandom() {

        Random random = new Random();
        double value;
        /*
        Random random = new Random();

        // Genera un número aleatorio gaussiano con media 0 y desviación estándar 1
        double gaussian = random.nextGaussian();

        // Escala el valor gaussiano usando la desviación estándar dada
        double value = gaussian * stdDev;

        // Ajusta la media del valor generado para que esté dentro del rango
        double mean = (max + min) / 2;
        value += mean;

        // Asegúrate de que el valor esté dentro del rango [min, max]
        if (value < min) {
            value = min;
        } else if (value > max) {
            value = max;
        }

        return (int)value;

         */

        do {
            double medio = (max - min)/2;
            value = medio + stdDev * random.nextGaussian();
        } while(value < min || value > max);

        return (int)value;
    }
}
