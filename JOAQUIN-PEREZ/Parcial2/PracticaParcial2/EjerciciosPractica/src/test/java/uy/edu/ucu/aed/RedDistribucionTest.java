package uy.edu.ucu.aed;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import uy.edu.ucu.aed.parcial.RedDistribucion;
import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.Ruta;

public class RedDistribucionTest {

    @Test
    public void testRedSimpleConPrioridad() {
        RedDistribucion red = new RedDistribucion();
        Ciudad a = new Ciudad("A"), b = new Ciudad("B"), c = new Ciudad("C"), d = new Ciudad("D");
        red.insertarVertice(a); red.insertarVertice(b); red.insertarVertice(c); red.insertarVertice(d);
        red.insertarArista(new Ruta("A", "B", 1, true));
        red.insertarArista(new Ruta("B", "C", 2, true));
        red.insertarArista(new Ruta("C", "D", 3, true));
        red.insertarArista(new Ruta("A", "D", 10, false)); // No debería usarse

        List<Ruta> resultado = red.construirRedMinimaConPrioridad();
        assertEquals(3, resultado.size());

        assertTrue(contieneRuta(resultado, "A", "B"));
        assertTrue(contieneRuta(resultado, "B", "C"));
        assertTrue(contieneRuta(resultado, "C", "D"));
    }

    @Test
    public void testRedMixtaConNoPrioritariasNecesarias() {
        RedDistribucion red = new RedDistribucion();
        Ciudad a = new Ciudad("A"), b = new Ciudad("B"), c = new Ciudad("C"), d = new Ciudad("D");
        red.insertarVertice(a); red.insertarVertice(b); red.insertarVertice(c); red.insertarVertice(d);
        red.insertarArista(new Ruta("A", "B", 1, true)); // prioritaria
        red.insertarArista(new Ruta("B", "C", 2, false)); // no prioritaria, pero necesaria
        red.insertarArista(new Ruta("C", "D", 3, false)); // no prioritaria, pero necesaria

        List<Ruta> resultado = red.construirRedMinimaConPrioridad();
        assertEquals(3, resultado.size());

        assertTrue(contieneRuta(resultado, "A", "B"));
        assertTrue(contieneRuta(resultado, "B", "C"));
        assertTrue(contieneRuta(resultado, "C", "D"));
    }

    @Test
    public void testSinPrioritarias() {
        RedDistribucion red = new RedDistribucion();
        Ciudad a = new Ciudad("A"), b = new Ciudad("B"), c = new Ciudad("C");
        red.insertarVertice(a); red.insertarVertice(b); red.insertarVertice(c);
        red.insertarArista(new Ruta("A", "B", 5, false));
        red.insertarArista(new Ruta("B", "C", 2, false));

        List<Ruta> resultado = red.construirRedMinimaConPrioridad();
        assertEquals(2, resultado.size());

        assertTrue(contieneRuta(resultado, "A", "B") || contieneRuta(resultado, "B", "C"));
    }

    @Test
    public void testTodasPrioritariasEligeBaratas() {
        RedDistribucion red = new RedDistribucion();
        Ciudad a = new Ciudad("A"), b = new Ciudad("B"), c = new Ciudad("C");
        red.insertarVertice(a); red.insertarVertice(b); red.insertarVertice(c);
        red.insertarArista(new Ruta("A", "B", 5, true));
        red.insertarArista(new Ruta("A", "C", 2, true));
        red.insertarArista(new Ruta("B", "C", 1, true));

        List<Ruta> resultado = red.construirRedMinimaConPrioridad();
        assertEquals(2, resultado.size());

        // Las dos rutas más baratas
        assertTrue(contieneRuta(resultado, "B", "C"));
        assertTrue(contieneRuta(resultado, "A", "C"));
    }

    @Test
    public void testMismoCostoDistintaPrioridad() {
        RedDistribucion red = new RedDistribucion();
        Ciudad a = new Ciudad("A"), b = new Ciudad("B"), c = new Ciudad("C");
        red.insertarVertice(a); red.insertarVertice(b); red.insertarVertice(c);
        red.insertarArista(new Ruta("A", "B", 1, false));
        red.insertarArista(new Ruta("A", "C", 1, true));
        red.insertarArista(new Ruta("B", "C", 1, false));

        List<Ruta> resultado = red.construirRedMinimaConPrioridad();
        assertEquals(2, resultado.size());

        // Debe contener la prioritaria A-C aunque tenga mismo costo
        assertTrue(contieneRuta(resultado, "A", "C"));
    }

    // Función de ayuda para verificar si una ruta existe en la lista (ambos sentidos)
    private boolean contieneRuta(List<Ruta> rutas, String origen, String destino) {
        return rutas.stream().anyMatch(r ->
                (r.getEtiquetaOrigen().equals(origen) && r.getEtiquetaDestino().equals(destino)) ||
                (r.getEtiquetaOrigen().equals(destino) && r.getEtiquetaDestino().equals(origen))
        );
    }
}
