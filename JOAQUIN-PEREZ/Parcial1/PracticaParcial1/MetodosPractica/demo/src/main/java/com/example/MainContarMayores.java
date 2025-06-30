public class MainContarMayores {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        String[] productos = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");
        for (String linea : productos) {
            String[] partes = linea.split(",");
            arbol.insertar(partes[0], partes[1]);
        }

        int umbral = Integer.parseInt(ManejadorArchivosGenerico.leerArchivo("./src/mayor.txt")[0]);
        int cantidad = arbol.contarMayoresA(umbral);

        ManejadorArchivosGenerico.escribirArchivo("./src/mayores_a_X.txt",
                new String[]{"Cantidad de claves mayores a " + umbral + ": " + cantidad});
    }
}
/*public int contarMayoresA(int umbral) {
    return (raiz != null) ? raiz.contarMayoresA(umbral) : 0;
}
 */

 /*public int contarMayoresA(int umbral) {
    int total = 0;

    if (Integer.parseInt(etiqueta.toString()) > umbral) {
        total++;
    }

    if (hijoIzq != null) {
        total += hijoIzq.contarMayoresA(umbral);
    }
    if (hijoDer != null) {
        total += hijoDer.contarMayoresA(umbral);
    }

    return total;
}
 */