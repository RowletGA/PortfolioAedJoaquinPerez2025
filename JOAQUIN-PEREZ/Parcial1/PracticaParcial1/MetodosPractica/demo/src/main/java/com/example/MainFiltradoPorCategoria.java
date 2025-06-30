public class MainFiltradoPorCategoria {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Leemos el archivo de productos
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");

        // Recorremos línea por línea
        for (String linea : lineas) {
            String[] partes = linea.split(","); // partes[0] = código, partes[1] = nombre, partes[2] = categoría

            // Solo insertamos si tiene categoría (partes[2] no está vacío)
            if (partes.length >= 3 && !partes[2].isEmpty()) {
                arbol.insertar(partes[0], partes[1] + "," + partes[2]); // clave = código, dato = nombre+cat
            }
        }

        // Guardamos las claves de los productos filtrados en una lista
        LinkedList<String> claves = new LinkedList<>();
        arbol.obtenerClaves(claves); // suponiendo que TArbolAVL tiene este método

        // Escribimos la salida al archivo
        String[] salida = claves.toArray(new String[0]);
        ManejadorArchivosGenerico.escribirArchivo("./src/productos_filtrados.txt", salida);
    }
}
/*
 * TARBOL AVL public void filtrarPorCategoria(LinkedList<String> salida) {
    if (raiz != null) {
        raiz.filtrarPorCategoria(salida);
    }
}
TELEMENTO AB

public void filtrarPorCategoria(LinkedList<String> salida) {
    if (hijoIzq != null) {
        hijoIzq.filtrarPorCategoria(salida);
    }

    // Verificamos si tiene categoría (dato con al menos 3 campos)
    String[] partes = this.datos.toString().split(",");
    if (partes.length >= 3 && !partes[2].isEmpty()) {
        salida.add(etiqueta + "," + partes[0] + "," + partes[2]); // código,nombre,categoría
    }

    if (hijoDer != null) {
        hijoDer.filtrarPorCategoria(salida);
    }
}

 */
