import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class FiltradoPorCategoriaTest {

    @Test
    public void testFiltradoConCategoria() {
        // Creamos el árbol AVL vacío
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Simulamos el archivo productos.txt (no hace falta leerlo si es un test unitario)
        String[] productos = {
            "001,Panaderia,C1",
            "002,Galletitas,",       // sin categoría
            "003,Lacteos,C2",
            "004,SinCategoria,",     // sin categoría
            "005,Fiambres,C3"
        };

        // Insertamos solo los que tienen categoría válida (3 columnas)
        for (String linea : productos) {
            String[] partes = linea.split(",");
            if (partes.length >= 3 && !partes[2].isEmpty()) {       // chequeo de categoría
                arbol.insertar(partes[0], partes[1] + "," + partes[2]); // clave = código, datos = nombre + categoría
            }
        }

        // Verificamos que sólo hayan entrado 3 productos al árbol
        assertEquals(3, arbol.contarNodos());

        // Verificamos que contiene uno de los válidos
        assertNotNull(arbol.buscar("003")); // Lacteos

        // Verificamos que no contiene un producto sin categoría
        assertNull(arbol.buscar("002")); // Galletitas
    }
}
