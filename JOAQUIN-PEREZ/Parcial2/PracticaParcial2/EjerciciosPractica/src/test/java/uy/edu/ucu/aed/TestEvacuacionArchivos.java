// Archivo: TestEvacuacionArchivos.java
package uy.edu.ucu.aed;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import uy.edu.ucu.aed.parcial.RedEvacuacion;
import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.tda.Ruta;

public class TestEvacuacionArchivos {

    @Test
    public void evacuarDesdeArchivoMontevideoTest() {
        String[] lineasCiudades = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/ciudades.txt", false);
        String[] lineasRutas = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/rutas.txt", false);

        RedEvacuacion red = new RedEvacuacion();

        for (String ciudad : lineasCiudades) {
            red.insertarVertice(new Ciudad(ciudad));
        }

        for (String linea : lineasRutas) {
            String[] datos = linea.split(",");
            String origen = datos[0];
            String destino = datos[1];
            double costo = Double.parseDouble(datos[2]);
            boolean esPrioritaria = Boolean.parseBoolean(datos[3]);
            red.insertarArista(new Ruta(origen, destino, costo, esPrioritaria));
        }

        Map<Comparable, RedEvacuacion.EstadoNodo> resultado = red.evacuarDesde("Montevideo");

        assertNotNull(resultado);
        assertTrue(resultado.containsKey("Rivera"));
        assertTrue(resultado.get("Rivera").distancia > 0);
    }
}
