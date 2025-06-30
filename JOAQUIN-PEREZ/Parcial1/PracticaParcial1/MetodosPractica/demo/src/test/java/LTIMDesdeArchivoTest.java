import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LTIMDesdeArchivoTest {

    @Test
    public void testTrayectoriaInternaMediaDesdeArchivo() {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Simulamos el archivo "productos.txt" con una estructura balanceada
        String[] productos = {
            "100,Pan",
            "50,Leche",
            "150,Queso",
            "25,Tomate",
            "75,Fideos"
        };

        // Insertamos todos los productos en el árbol
        for (String linea : productos) {
            String[] partes = linea.split(",");
            arbol.insertar(partes[0], partes[1]);
        }

        // Verificamos que el árbol tenga los 5 nodos
        assertEquals(5, arbol.contarNodos());

        // Calculamos la trayectoria interna media
        double resultado = arbol.longTrayIntMedia();

        // Para este caso, sabemos que debe dar un promedio entre 1.0 y 2.0
        assertTrue(resultado > 1.0 && resultado < 2.0);  // margen de verificación razonable

        // (Opcional) Mostrar por consola si estamos debuggeando
        System.out.println("LTIM: " + resultado);
    }
}
