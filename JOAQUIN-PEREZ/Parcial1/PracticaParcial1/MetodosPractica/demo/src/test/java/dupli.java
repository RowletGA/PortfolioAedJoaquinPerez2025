@Test
public void testDuplicados() {
    TArbolAVL<String> t1 = new TArbolAVL<>();
    TArbolAVL<String> t2 = new TArbolAVL<>();

    t1.insertar("101", "Leche");
    t1.insertar("102", "Pan");
    t1.insertar("103", "Queso");

    t2.insertar("102", "Pan");
    t2.insertar("104", "Manteca");
    t2.insertar("105", "Fideos");

    LinkedList<String> resultado = new LinkedList<>();
    t1.obtenerDuplicadosCon(t2, resultado);

    assertEquals(1, resultado.size());
    assertEquals("102", resultado.get(0)); // único duplicado
}
