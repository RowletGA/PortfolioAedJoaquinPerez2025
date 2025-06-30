public class MainNodoHojaYProfundidad {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            arbol.insertar(partes[0], partes[1]);
        }

        String[] busqueda = ManejadorArchivosGenerico.leerArchivo("./src/busqueda.txt");
        String claveBuscada = busqueda[0];

        TElementoAB<String> nodo = arbol.buscar(claveBuscada);

        String[] salida;
        if (nodo != null) {
            boolean esHoja = nodo.getHijoIzq() == null && nodo.getHijoDer() == null;
            int profundidad = arbol.obtenerProfundidad(claveBuscada); // este método lo definimos aparte

            salida = new String[]{
                "Clave: " + claveBuscada,
                "¿Es hoja? " + esHoja,
                "Profundidad: " + profundidad
            };
        } else {
            salida = new String[]{"El nodo no se encontró."};
        }

        ManejadorArchivosGenerico.escribirArchivo("./src/datos_nodo.txt", salida);
    }
}
