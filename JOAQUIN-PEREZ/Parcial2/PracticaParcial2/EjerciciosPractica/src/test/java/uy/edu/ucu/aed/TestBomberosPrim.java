// Archivo: TestEvacuacionArchivos.java
package uy.edu.ucu.aed;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import uy.edu.ucu.aed.parcial.RedBomberosPrim;
import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.Ruta;

public class TestBomberosPrim {

    @Test
    public void testCoberturaCriticaCumplida() {
        Set<Comparable> zonasCriticas = Set.of("Rivera", "Florida");
        RedBomberosPrim red = new RedBomberosPrim(zonasCriticas);

        red.insertarVertice(new Ciudad("Montevideo"));
        red.insertarVertice(new Ciudad("Canelones"));
        red.insertarVertice(new Ciudad("Florida"));
        red.insertarVertice(new Ciudad("Rivera"));

        red.insertarArista(new Ruta("Montevideo", "Canelones", 3, false));
        red.insertarArista(new Ruta("Montevideo", "Florida", 5, false));
        red.insertarArista(new Ruta("Florida", "Rivera", 2, false));
        red.insertarArista(new Ruta("Rivera", "Canelones", 6, false));
        red.insertarArista(new Ruta("Rivera", "Montevideo", 4, false));

        List<Ruta> resultado = red.construirRedConCoberturaCritica();

        // Verificar conexión total
        assertTrue(resultado.size() >= 3, "Debe haber al menos 3 rutas para conectar las ciudades");

        // Verificar que cada ciudad crítica tiene al menos 2 conexiones
        Map<Comparable, Integer> grado = new HashMap<>();
        for (Ruta r : resultado) {
            grado.put(r.getEtiquetaOrigen(), grado.getOrDefault(r.getEtiquetaOrigen(), 0) + 1);
            grado.put(r.getEtiquetaDestino(), grado.getOrDefault(r.getEtiquetaDestino(), 0) + 1);
        }

        for (Comparable critico : zonasCriticas) {
            assertTrue(grado.getOrDefault(critico, 0) >= 2, "La ciudad crítica " + critico + " debe tener al menos 2 conexiones");
        }
    }
}

