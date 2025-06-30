public class MainBuscarDispositivosPorSubred {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Leemos dispositivos del archivo
        String[] dispositivos = ManejadorArchivosGenerico.leerArchivo("./src/dispositivos.txt");

        // Insertamos en el árbol usando la IP como clave
        for (String linea : dispositivos) {
            String[] partes = linea.split(","); // partes[0]=IP, [1]=Nombre, [2]=Subred
            arbol.insertar(partes[0], partes[1] + "," + partes[2]);
        }

        // Leemos la subred que queremos filtrar
        String subredBuscada = ManejadorArchivosGenerico.leerArchivo("./src/subred.txt")[0];

        // Lista donde vamos a guardar resultados
        LinkedList<String> salida = new LinkedList<>();
        arbol.buscarDispositivosPorSubred(subredBuscada, salida);

        // Guardamos los nombres en archivo
        ManejadorArchivosGenerico.escribirArchivo("./src/dispositivos_subred.txt", salida.toArray(new String[0]));
    }
}
/*Se desea mantener un árbol AVL con información de dispositivos de red indexados por su dirección IP.
Cada dispositivo tiene:

IP (clave del nodo)

Nombre

Subred (ej: "172.016.001.")

Dado un archivo con dispositivos, se debe:

Insertarlos en un AVL, usando la IP como clave.

Buscar todos los dispositivos que pertenecen a una subred dada.

Guardar los nombres en un archivo dispositivos_subred.txt. */

/* tarbol AVL
 * public void buscarDispositivosPorSubred(String subred, LinkedList<String> salida) {
    if (raiz != null) {
        raiz.buscarDispositivosPorSubred(subred, salida);
    }
}

// telemento
public void buscarDispositivosPorSubred(String subred, LinkedList<String> salida) {
    if (hijoIzq != null) {
        hijoIzq.buscarDispositivosPorSubred(subred, salida);
    }

    // El dato es "Nombre,Subred"
    String[] partes = this.datos.toString().split(",");
    if (partes.length >= 2 && this.etiqueta.toString().startsWith(subred)) {
        salida.add(partes[0]); // solo agregamos el nombre
    }

    if (hijoDer != null) {
        hijoDer.buscarDispositivosPorSubred(subred, salida);
    }
}
 */