import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodoHojaYProfundidadTest {

    @Test
    public void testNodoHojaYProfundidad() {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Cargamos nodos de forma balanceada
        arbol.insertar(100, "Raíz");
        arbol.insertar(50, "Izquierda");
        arbol.insertar(150, "Derecha");
        arbol.insertar(25, "HojaIzquierda");
        arbol.insertar(75, "HojaDerecha");

        // Buscamos nodo hoja (75)
        TElementoAB<String> nodo = arbol.buscar(75);
        assertNotNull(nodo);                                     // debe existir
        assertNull(nodo.getHijoIzq());                           // no tiene hijo izquierdo
        assertNull(nodo.getHijoDer());                           // no tiene hijo derecho

        // Calculamos profundidad de ese nodo
        int profundidad = arbol.obtenerProfundidad(75);
        assertEquals(2, profundidad);                            // está a 2 niveles de la raíz
    }

    @Test
    public void testNodoInexistente() {
        TArbolAVL<String> arbol = new TArbolAVL<>();
        arbol.insertar(100, "Raíz");
        arbol.insertar(50, "Izquierda");

        assertEquals(-1, arbol.obtenerProfundidad(999));         // nodo no está en el árbol
    }
}
