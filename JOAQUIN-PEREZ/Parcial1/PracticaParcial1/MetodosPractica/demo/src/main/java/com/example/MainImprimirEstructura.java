import java.util.LinkedList;

public class MainImprimirEstructura {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();
        String[] datos = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");

        for (String l : datos) {
            String[] p = l.split(",");
            arbol.insertar(p[0], p[1]);
        }

        LinkedList<String> estructura = new LinkedList<>();
        arbol.imprimirEstructura(estructura, 0);

        ManejadorArchivosGenerico.escribirArchivo("./src/estructura.txt", estructura.toArray(new String[0]));
    }
}
/*public void imprimirEstructura(LinkedList<String> salida, int nivel) {
    if (raiz != null) {
        raiz.imprimirEstructura(salida, nivel);
    }
}
 */
/*public void imprimirEstructura(LinkedList<String> salida, int nivel) {
    // Generamos sangría con espacios
    String indentacion = "  ".repeat(nivel);
    salida.add(indentacion + this.etiqueta);

    if (hijoIzq != null) {
        hijoIzq.imprimirEstructura(salida, nivel + 1);
    }
    if (hijoDer != null) {
        hijoDer.imprimirEstructura(salida, nivel + 1);
    }
}
 */

  