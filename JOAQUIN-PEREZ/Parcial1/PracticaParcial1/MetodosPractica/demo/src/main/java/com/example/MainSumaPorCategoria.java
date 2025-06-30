public class MainSumaPorCategoria {

    public static void main(String[] args) {
        TArbolAVL<String> arbol = new TArbolAVL<>();

        // Leer archivo de productos
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");

        for (String linea : lineas) {
            String[] partes = linea.split(",");
            arbol.insertar(partes[0], partes[1] + "," + partes[2] + "," + partes[3]);
            // clave = código, dato = nombre,categoría,precio
        }

        // Leer la categoría objetivo
        String categoriaObjetivo = ManejadorArchivosGenerico.leerArchivo("./src/categoria.txt")[0];

        // Calcular suma total de precios de esa categoría
        int total = arbol.sumarPreciosPorCategoria(categoriaObjetivo);

        // Guardar resultado en archivo
        String[] salida = new String[]{"Total para " + categoriaObjetivo + ": " + total};
        ManejadorArchivosGenerico.escribirArchivo("./src/total_categoria.txt", salida);
    }
}
/*📌 Enunciado estilo parcial:
Una tienda desea calcular el total de inversión en productos de una categoría específica (ej. "Limpieza").

Dado un archivo productos.txt con productos en el formato:

Copiar
Editar
100,Detergente,Limpieza,250
101,Jabón,Limpieza,180
102,Arroz,Alimentos,300
103,Fideos,Alimentos,200
Se pide:

Insertar los productos en un árbol AVL (clave = código).

Calcular la suma total de precios para productos cuya categoría coincida con la indicada en categoria.txt (ej: "Limpieza").

Guardar el resultado en total_categoria.txt. */


/*TARBOL AVL
 * public int sumarPreciosPorCategoria(String categoria) {
    if (raiz == null) return 0;
    return raiz.sumarPreciosPorCategoria(categoria);
}
// TELEMENTO AB
public int sumarPreciosPorCategoria(String categoria) {
    int suma = 0;

    // Verificamos si la categoría coincide
    String[] partes = this.datos.toString().split(",");
    if (partes.length >= 3 && partes[2].equals(categoria)) {
        suma += Integer.parseInt(partes[3]); // sumamos el precio
    }

    // Recorremos los hijos
    if (hijoIzq != null) {
        suma += hijoIzq.sumarPreciosPorCategoria(categoria);
    }
    if (hijoDer != null) {
        suma += hijoDer.sumarPreciosPorCategoria(categoria);
    }

    return suma;
}
*/