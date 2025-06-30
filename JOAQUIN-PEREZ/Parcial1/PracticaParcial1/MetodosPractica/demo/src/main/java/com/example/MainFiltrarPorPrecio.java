public class MainFiltrarPorPrecio {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Cargar productos
        String[] productos = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");
        for (String linea : productos) {
            String[] partes = linea.split(",");
            Comparable clave = partes[0];
            String nombre = partes[1];
            String precio = partes[2];
            arbol.insertar(clave, nombre + "," + precio);
        }

        // Leer umbral
        int umbral = Integer.parseInt(ManejadorArchivosGenerico.leerArchivo("./src/umbral.txt")[0]);

        // Filtrar por precio
        LinkedList<String> salida = new LinkedList<>();
        arbol.filtrarPorPrecio(umbral, salida); // requiere implementación

        ManejadorArchivosGenerico.escribirArchivo("./src/productos_filtrados.txt",
                salida.toArray(new String[0]));
    }
}

/*TARBOL AVL public void filtrarPorPrecio(int umbral, LinkedList<String> salida) {
    if (raiz != null) {
        raiz.filtrarPorPrecio(umbral, salida);
    }
}
*/

/*TELEMENTO AB 
 * public void filtrarPorPrecio(int umbral, LinkedList<String> salida) {
    // recorrer primero hijo izquierdo
    if (hijoIzq != null) {
        hijoIzq.filtrarPorPrecio(umbral, salida);
    }

    // verificar este nodo
    String[] datos = this.datos.toString().split(",");
    int precio = Integer.parseInt(datos[1]);
    if (precio > umbral) {
        salida.add(this.etiqueta + "," + datos[0] + "," + precio);
    }

    // recorrer hijo derecho
    if (hijoDer != null) {
        hijoDer.filtrarPorPrecio(umbral, salida);
    }
}

 */