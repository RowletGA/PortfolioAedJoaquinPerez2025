public class MainAlturaHojas {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Leemos el archivo
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");

        // Insertamos en el árbol
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            arbol.insertar(partes[0], partes[1]);
        }

        // Calculamos altura y cantidad de hojas
        int altura = arbol.obtenerAltura();
        int hojas = arbol.contarHojas();

        // Preparamos salida
        String[] salida = {
            "Altura del árbol: " + altura,
            "Cantidad de hojas: " + hojas
        };

        // Guardamos en archivo
        ManejadorArchivosGenerico.escribirArchivo("./src/estadisticas_avl.txt", salida);
    }
}
/*public int contarHojas() {
    if (raiz == null) return 0;
    return raiz.contarHojas();
} TARBOL
 */

 /*Telemento 
  * 
public int contarHojas() {
    // Si no tiene hijos, es hoja
    if (hijoIzq == null && hijoDer == null) {
        return 1;
    }

    int izq = (hijoIzq != null) ? hijoIzq.contarHojas() : 0;
    int der = (hijoDer != null) ? hijoDer.contarHojas() : 0;

    return izq + der;
}


  */