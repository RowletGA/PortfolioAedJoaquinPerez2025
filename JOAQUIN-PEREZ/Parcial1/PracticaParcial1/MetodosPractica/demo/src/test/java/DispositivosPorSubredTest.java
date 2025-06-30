import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class DispositivosPorSubredTest {

    @Test
    public void testBuscarSubred() {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        arbol.insertar("172.016.001.056", "A,172.016.001.");
        arbol.insertar("172.016.001.100", "B,172.016.001.");
        arbol.insertar("010.010.200.002", "C,010.010.200.");

        LinkedList<String> salida = new LinkedList<>();
        arbol.buscarDispositivosPorSubred("172.016.001.", salida);

        assertEquals(2, salida.size());
        assertTrue(salida.get(0).contains("A"));
        assertTrue(salida.get(1).contains("B"));
    }
}
