public class MainCompararTiendas {

    public static void main(String[] args) {
        TArbolAVL<String> tienda1 = new TArbolAVL<>();
        TArbolAVL<String> tienda2 = new TArbolAVL<>();

        // Cargar tienda 1
        String[] datos1 = ManejadorArchivosGenerico.leerArchivo("./src/tienda1.txt");
        for (String linea : datos1) {
            String[] partes = linea.split(",");
            tienda1.insertar(partes[0], partes[1]);
        }

        // Cargar tienda 2
        String[] datos2 = ManejadorArchivosGenerico.leerArchivo("./src/tienda2.txt");
        for (String linea : datos2) {
            String[] partes = linea.split(",");
            tienda2.insertar(partes[0], partes[1]);
        }

        // Buscar duplicados
        LinkedList<String> duplicados = new LinkedList<>();
        tienda1.obtenerDuplicadosCon(tienda2, duplicados);

        // Guardar resultado
        ManejadorArchivosGenerico.escribirArchivo("./src/duplicados.txt", duplicados.toArray(new String[0]));
    }
}
/*Se tienen dos archivos de productos de dos tiendas diferentes.
Cada archivo contiene líneas en formato:

Copiar
Editar
codigo,nombre
Se pide:

Cargar los dos archivos en dos árboles AVL separados.

Detectar qué códigos de producto existen en ambas tiendas (claves duplicadas).

Guardar los códigos duplicados en duplicados.txt.

 */
/*public void obtenerDuplicadosCon(TArbolAVL<?> otro, LinkedList<String> salida) {
    if (raiz != null) {
        raiz.obtenerDuplicadosCon(otro, salida);
    }
}

public void obtenerDuplicadosCon(TArbolAVL<?> otro, LinkedList<String> salida) {
    // Verificamos si este nodo está en el otro árbol
    if (otro.buscar(this.etiqueta) != null) {
        salida.add(this.etiqueta.toString());
    }

    if (hijoIzq != null) {
        hijoIzq.obtenerDuplicadosCon(otro, salida);
    }

    if (hijoDer != null) {
        hijoDer.obtenerDuplicadosCon(otro, salida);
    }
}

 */