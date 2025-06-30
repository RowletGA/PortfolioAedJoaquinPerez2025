@Test
public void testExportarPreorden() {
    TArbolAVL<String> arbol = new TArbolAVL<>();
    arbol.insertar(100, "Zapatos");
    arbol.insertar(50, "Remera");
    arbol.insertar(150, "Jean");

    LinkedList<String> salida = new LinkedList<>();
    arbol.exportarPreorden(salida);

    assertEquals("Zapatos", salida.get(0));
    assertEquals("Remera", salida.get(1));
    assertEquals("Jean", salida.get(2));
}
