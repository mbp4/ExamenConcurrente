# ExamenConcurrente
 
link al repositorio: https://github.com/mbp4/ExamenConcurrente.git
Participantes: Adrián Thierry Puyo Olias, Miriam Blanco Ponce y Daniel Sousa Escudero

## Descripción del Proyecto

Este proyecto es una aplicación Java que simula la medición de datos de sensores utilizando concurrencia. La aplicación utiliza una interfaz gráfica para mostrar los datos medidos por los sensores en una tabla.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y clases:

### Paquete `org.example.examenconcurrente.model`

#### Clase `Principal`

Esta clase contiene el método `main` que inicia la aplicación. Crea una instancia de `VentanaSensores` y la hace visible.

### Paquete `org.example.examenconcurrente.model.sensores`

#### Clase `Sensor`

Esta clase representa un sensor que mide datos utilizando una distribución gaussiana. Los datos medidos se muestran en la interfaz gráfica.

- **Atributos**:
  - `Gauss gauss`: Generador de números aleatorios con distribución gaussiana.
  - `int contador`: Contador de mediciones realizadas.
  - `VentanaSensores vs`: Referencia a la ventana de sensores para mostrar los datos.

- **Métodos**:
  - `Sensor(String tipo, int maxMediciones, VentanaSensores vs)`: Constructor que inicializa el sensor.
  - `void medir(ScheduledExecutorService ejecutor)`: Método que realiza una medición y actualiza la interfaz gráfica.

### Paquete `org.example.examenconcurrente.model.VentanaSensores`

#### Clase `VentanaSensores`

Esta clase representa la interfaz gráfica de la aplicación. Contiene botones y una tabla para mostrar los datos medidos por los sensores.

- **Atributos**:
  - `JButton botonPelotas`: Botón para iniciar la medición de pelotas.
  - `JButton botonReiniciar`: Botón para reiniciar la tabla de mediciones.
  - `JTable tablaPelotas`: Tabla para mostrar los datos medidos.
  - `JScrollPane scrollPanePelotas`: Panel de desplazamiento para la tabla.

- **Métodos**:
  - `VentanaSensores()`: Constructor que inicializa la interfaz gráfica.
  - `void crearTablaPelotas()`: Método que crea y configura la tabla de mediciones.
  - `void empezarMedicionPelotas()`: Método que inicia la medición de pelotas.
  - `void reiniciarTablaPelotas()`: Método que reinicia la tabla de mediciones.
  - `void muestraPelotas(int medida)`: Método que actualiza la tabla con los datos medidos.
  - `String generarGrafico(int nuevoValor)`: Método que genera una representación gráfica de las mediciones.

## Funcionamiento del Programa

1. **Inicio de la Aplicación**: La clase `Principal` inicia la aplicación creando una instancia de `VentanaSensores` y haciéndola visible.
2. **Interfaz Gráfica**: La clase `VentanaSensores` crea la interfaz gráfica con botones y una tabla para mostrar los datos.
3. **Medición de Datos**: Al pulsar el botón "Tirar pelotas", se crea un sensor que mide datos utilizando una distribución gaussiana y actualiza la tabla en la interfaz gráfica.
4. **Actualización de la Tabla**: La tabla se actualiza con los datos medidos y muestra una representación gráfica de las mediciones.
5. **Reinicio de la Tabla**: Al pulsar el botón "Reiniciar tabla", se reinician los valores de la tabla.

