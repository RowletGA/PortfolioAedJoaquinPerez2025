public class MainExportarPreorden {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");

        for (String l : lineas) {
            String[] partes = l.split(",");
            arbol.insertar(partes[0], partes[1]);
        }

        LinkedList<String> salida = new LinkedList<>();
        arbol.exportarPreorden(salida);  // método recorre el árbol y llena la lista

        ManejadorArchivosGenerico.escribirArchivo("./src/preorden.txt", salida.toArray(new String[0]));
    }
}

/*public void exportarPreorden(LinkedList<String> salida) {
    if (raiz != null) {
        raiz.exportarPreorden(salida);
    }
}

public void exportarPreorden(LinkedList<String> salida) {
    salida.add(datos.toString()); // primero este nodo
    if (hijoIzq != null) {
        hijoIzq.exportarPreorden(salida);
    }
    if (hijoDer != null) {
        hijoDer.exportarPreorden(salida);
    }
}

 */