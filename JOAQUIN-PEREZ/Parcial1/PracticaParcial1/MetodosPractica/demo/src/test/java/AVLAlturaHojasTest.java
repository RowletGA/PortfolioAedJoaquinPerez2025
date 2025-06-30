import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AVLAlturaHojasTest {

    @Test
    public void testAlturaYHojas() {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Insertamos nodos con etiquetas que generen ramas izquierda y derecha
        arbol.insertar(100, "Zanahorias");
        arbol.insertar(50, "Manzanas");
        arbol.insertar(150, "Bananas");
        arbol.insertar(25, "Tomates");
        arbol.insertar(75, "Papas");
        arbol.insertar(125, "Peras");
        arbol.insertar(175, "Naranjas");

        // Verificamos que la altura sea 2 (balanceado AVL)
        assertEquals(2, arbol.obtenerAltura());

        // Verificamos que tiene 4 hojas (sin hijos)
        assertEquals(4, arbol.contarHojas());
    }
}
