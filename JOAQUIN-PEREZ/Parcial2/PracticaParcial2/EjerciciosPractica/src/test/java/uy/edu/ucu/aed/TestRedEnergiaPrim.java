// Archivo: TestEvacuacionArchivos.java
package uy.edu.ucu.aed;
import org.junit.jupiter.api.Test;
import uy.edu.ucu.aed.parcial.RedEnergiaPrim;
import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.Ruta;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase RedEnergiaPrim.
 * Verifica que el algoritmo de Prim modificado:
 * - Incluya rutas preinstaladas obligatoriamente.
 * - Conecte todas las ciudades.
 * - Seleccione conexiones adicionales con costo mínimo.
 */
public class TestRedEnergiaPrim {

    @Test
    public void redIncluyePreinstaladasYConectaTodo() {
        // Crear lista de rutas preinstaladas (obligatorias en el resultado)
        List<Ruta> preinstaladas = new ArrayList<>();
        preinstaladas.add(new Ruta("Montevideo", "Canelones", 2, true));

        // Crear instancia de RedEnergiaPrim con las rutas obligatorias
        RedEnergiaPrim red = new RedEnergiaPrim(preinstaladas);

        // Insertar las ciudades involucradas en la red
        red.insertarVertice(new Ciudad("Montevideo"));
        red.insertarVertice(new Ciudad("Canelones"));
        red.insertarVertice(new Ciudad("Florida"));
        red.insertarVertice(new Ciudad("Rivera"));

        // Insertar rutas adicionales que serán evaluadas por el algoritmo
        red.insertarArista(new Ruta("Montevideo", "Florida", 5, false));
        red.insertarArista(new Ruta("Florida", "Rivera", 3, false));
        red.insertarArista(new Ruta("Canelones", "Rivera", 4, false));

        // Ejecutar el algoritmo modificado de Prim
        List<Ruta> resultado = red.construirRedEnergiaConPrim();

        // Se esperan 3 rutas: 1 preinstalada + 2 necesarias para conectar todo
        assertEquals(3, resultado.size(), "La red debe contener 3 rutas");

        // Confirmar que la ruta preinstalada está en el resultado
        assertTrue(
            resultado.stream().anyMatch(
                r -> r.getEtiquetaOrigen().equals("Montevideo") && r.getEtiquetaDestino().equals("Canelones")
            ), "La ruta preinstalada Montevideo-Canelones debe estar incluida."
        );

        // Confirmar que existe una conexión con Rivera (por alguna de las dos posibles)
        boolean conectaRivera = resultado.stream().anyMatch(
            r -> (r.getEtiquetaOrigen().equals("Canelones") && r.getEtiquetaDestino().equals("Rivera")) ||
                 (r.getEtiquetaOrigen().equals("Florida") && r.getEtiquetaDestino().equals("Rivera"))
        );

        assertTrue(conectaRivera, "Rivera debe estar conectada mediante alguna ruta.");
    }
}
