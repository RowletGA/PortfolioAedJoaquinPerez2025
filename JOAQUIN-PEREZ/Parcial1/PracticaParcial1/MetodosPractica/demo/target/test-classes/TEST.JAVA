import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class FiltrarPorPrecioTest {

    @Test
    public void testFiltrarPorPrecio() {
        TArbolAVL<String> arbol = new TArbolAVL<>();
        arbol.insertar(100, "Pan,500");
        arbol.insertar(101, "Leche,900");
        arbol.insertar(102, "Queso,1200");
        arbol.insertar(103, "Jamón,1500");

        LinkedList<String> salida = new LinkedList<>();
        arbol.filtrarPorPrecio(1000, salida);

        assertEquals(2, salida.size());
        assertTrue(salida.get(0).contains("Queso"));
        assertTrue(salida.get(1).contains("Jamón"));
    }
}
