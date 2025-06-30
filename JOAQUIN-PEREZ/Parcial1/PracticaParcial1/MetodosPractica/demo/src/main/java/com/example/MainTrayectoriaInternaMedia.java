public class MainTrayectoriaInternaMedia {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();  // Creamos el árbol AVL vacío

        // Leemos las líneas del archivo
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");

        // Insertamos cada producto en el árbol
        for (String linea : lineas) {
            String[] partes = linea.split(",");       // partes[0] = código, partes[1] = nombre
            arbol.insertar(partes[0], partes[1]);     // clave: código, dato: nombre
        }

        // Calculamos la trayectoria interna media
        double resultado = arbol.longTrayIntMedia();

        // Preparamos el contenido del archivo de salida
        String[] salida = new String[]{"Trayectoria Interna Media: " + resultado};

        // Guardamos en salida.txt
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt", salida);

        // También lo mostramos por consola por si se quiere debuggear
        System.out.println(salida[0]);
    }
}

/*TARBOL AVL 
 * 
 * public double longTrayIntMedia() {
    if (raiz == null) return 0;
    int[] resultado = raiz.sumarNiveles(0); // [0] = suma de niveles, [1] = cantidad
    return (double) resultado[0] / resultado[1];
}

teelemto

public int[] sumarNiveles(int nivel) {
    int suma = nivel;     // acumulamos el nivel actual
    int cantidad = 1;     // este nodo cuenta como uno

    if (hijoIzq != null) {
        int[] izq = hijoIzq.sumarNiveles(nivel + 1);
        suma += izq[0];
        cantidad += izq[1];
    }

    if (hijoDer != null) {
        int[] der = hijoDer.sumarNiveles(nivel + 1);
        suma += der[0];
        cantidad += der[1];
    }

    return new int[]{suma, cantidad};
}

*/
