public import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.ManejadorArchivosGenerico;
import com.example.TArbolAVL;
import com.example.TElementoAB;


public class ParcialAVLTest {

    @Test
    public void testTrayectoriaInternaDesdeArchivo() {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/testAVL.txt");
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            arbol.insertar(partes[0], partes.length > 1 ? partes[1] : "");
        }

        double esperado = 1.5;  // valor que esperás para ese caso
        assertEquals(esperado, arbol.longTrayIntMedia(), 0.01); // margen de error
    }
}
 
    
}
