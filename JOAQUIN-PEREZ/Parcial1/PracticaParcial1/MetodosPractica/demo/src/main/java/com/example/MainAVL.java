public class MainAVL {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            Comparable etiqueta = datos[0];
            String valor = datos.length > 1 ? datos[1] : "";
            arbol.insertar(etiqueta, valor);
        }

        System.out.println("Recorrido inorden: " + arbol.inOrden());
        System.out.println("Cantidad de hojas: " + arbol.contarHojas());
        System.out.println("Altura del árbol: " + arbol.obtenerAltura());
        System.out.println("Trayectoria interna media: " + arbol.longTrayIntMedia());

        String[] salida = {
            "inOrden: " + arbol.inOrden(),
            "Hojas: " + arbol.contarHojas(),
            "Altura: " + arbol.obtenerAltura(),
            "Trayectoria Interna Media: " + arbol.longTrayIntMedia()
        };
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt", salida);
    }


    /*public class MainParcialAVL {
    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Entrada: leer desde archivo
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            Comparable clave = partes[0];
            String valor = partes.length > 1 ? partes[1] : "";
            arbol.insertar(clave, valor);
        }

        // Aplicar método del parcial (ejemplo: longTrayIntMedia)
        double resultado = arbol.longTrayIntMedia();

        // Salida: escribir a archivo
        String[] salida = new String[]{"Trayectoria media: " + resultado};
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt", salida);
    }
}
 */
}
