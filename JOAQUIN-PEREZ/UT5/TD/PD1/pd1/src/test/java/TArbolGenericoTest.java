import com.example.TArbolGenerico;
import com.example.TElementoAG;
package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals.*;
import org.junit.Test; 
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TArbolGenericoTest {
    public TArbolGenericoTest() {
    }

    @Test
    public void testInsertarRaiz() {
        TArbolGenerico arbol = new TArbolGenerico();
        arbol.insertar(1, 1);
        TElementoAG expected = new TElementoAG(1,1);
        assertEquals(arbol.getRaiz().getEtiqueta(),expected.getEtiqueta());
    }

    @Test
    public void testInsertarUnHijoRaiz(){
        TArbolGenerico arbol = new TArbolGenerico();
        arbol.insertar(1, 1);
        arbol.insertar(2, 1);
        TElementoAG expected = new TElementoAG(2,1);
        assertEquals(arbol.getRaiz().getPrimerHijo().getEtiqueta(),expected.getEtiqueta());
    }
    
    @Test
    public void testInsertarOtroHijoRaiz(){
        TArbolGenerico arbol = new TArbolGenerico();
        arbol.insertar(1, 1);
        arbol.insertar(2, 1);
        arbol.insertar(3, 1);
        String expectedPreOrder = "1 2 3 ";
        assertEquals(arbol.preOrden(),expectedPreOrder);
        
    }
    @Test
    public void testBuscarUnElemento(){
        TArbolGenerico arbol = new TArbolGenerico();
        arbol.insertar(1, 1);
        arbol.insertar(2, 1);
        arbol.insertar(3, 1);
        arbol.insertar(4, 2);
        Comparable expectedEtiqueta = 4;
        assertEquals(expectedEtiqueta,arbol.buscar(4).getEtiqueta());
        
        
    }
    
    
}
