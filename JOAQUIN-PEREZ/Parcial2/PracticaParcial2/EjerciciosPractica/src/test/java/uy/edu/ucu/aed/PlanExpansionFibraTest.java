package uy.edu.ucu.aed;

import org.junit.jupiter.api.Test;
import uy.edu.ucu.aed.parcial.PlanExpansionFibra;
import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.Ruta;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlanExpansionFibraTest {

    @Test
    public void testRedDesdeCapital() {
        PlanExpansionFibra red = new PlanExpansionFibra();
        Ciudad mvd = new Ciudad("Montevideo");
        Ciudad c1 = new Ciudad("Canelones");
        Ciudad c2 = new Ciudad("Florida");
        Ciudad c3 = new Ciudad("Rivera");

        red.insertarVertice(mvd);
        red.insertarVertice(c1);
        red.insertarVertice(c2);
        red.insertarVertice(c3);

        red.insertarArista(new Ruta("Montevideo", "Canelones", 5, false));
        red.insertarArista(new Ruta("Montevideo", "Florida", 10, false));
        red.insertarArista(new Ruta("Canelones", "Rivera", 3, false));
        red.insertarArista(new Ruta("Florida", "Rivera", 2, false));

        List<Ruta> resultado = red.construirRedFibraDesde("Montevideo");

        assertEquals(3, resultado.size());
        double costoTotal = resultado.stream().mapToDouble(Ruta::getCosto).sum();
        assertEquals(10.0, costoTotal, 0.001);
    }

    @Test
    public void testCapitalInexistente() {
        PlanExpansionFibra red = new PlanExpansionFibra();
        red.insertarVertice(new Ciudad("A"));
        red.insertarVertice(new Ciudad("B"));

        red.insertarArista(new Ruta("A", "B", 5, false));

        List<Ruta> resultado = red.construirRedFibraDesde("Z");
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testSoloCapital() {
        PlanExpansionFibra red = new PlanExpansionFibra();
        red.insertarVertice(new Ciudad("Montevideo"));
        List<Ruta> resultado = red.construirRedFibraDesde("Montevideo");
        assertEquals(0, resultado.size());
    }
}
