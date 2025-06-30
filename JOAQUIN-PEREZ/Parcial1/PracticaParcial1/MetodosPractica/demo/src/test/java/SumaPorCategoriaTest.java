import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumaPorCategoriaTest {

    @Test
    public void testSumaPreciosPorCategoria() {
        TArbolAVL<String> arbol = new TArbolAVL<>();
        arbol.insertar(100, "Detergente,Limpieza,250");
        arbol.insertar(101, "Jabón,Limpieza,180");
        arbol.insertar(102, "Arroz,Alimentos,300");
        arbol.insertar(103, "Fideos,Alimentos,200");

        int totalLimpieza = arbol.sumarPreciosPorCategoria("Limpieza");
        assertEquals(430, totalLimpieza);

        int totalAlimentos = arbol.sumarPreciosPorCategoria("Alimentos");
        assertEquals(500, totalAlimentos);
    }
}
