package org.example.examenconcurrente;

import org.example.examenconcurrente.model.VentanaSensores.VentanaSensores;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamenConcurrenteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenConcurrenteApplication.class, args);
        VentanaSensores vs = new VentanaSensores();
        vs.setVisible(true);
    }

}
