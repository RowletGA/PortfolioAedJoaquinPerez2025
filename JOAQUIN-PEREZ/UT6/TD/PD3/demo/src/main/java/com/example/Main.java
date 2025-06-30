package com.example;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", null);
        map.put("key3", "value3");
        map.put("key4", null);
        System.out.println(map);
        removeNullValues(map);

    }
    /*EJERCICIO 1
Escribe, en el menor número de líneas de código posible, una funcionalidad que elimine todas las entradas de un
Map cuyo valor sea null.
EJERCICIO 2
Escribe un método que tome como parámetro un Map<String.String> y devuelva un nuevo Map<String.String> en el
que las claves y los valores estén intercambiados. Genera una excepción si hay valores duplicados en el mapa que se
pasa como parámetro.
EJERCICIO 3
Escribe un programa que lea cadenas de caracteres de entrada y las imprima ordenadas según su longitud,
comenzando por la más corta. Si hay varias cadenas con la misma longitud, éstas deben imprimirse en orden
lexicográfico.
EJERCICIO 4
Escribe un programa que lea un archivo de texto, pasado como primer parámetro en la línea de comando, en una
List. El programa debe luego imprimir en forma aleatoria líneas del archivo. El número de líneas a imprimir será
especificado como segundo parámetro. Escribe este programa de forma tal que asigne una colección del tamaño
correcto desde el inicio, y no una que vaya expandiéndose gradualmente a medida que el archive es leído. Para
calcular la cantidad de líneas del archive se puede usar la función java.io.File.length para obtener el tamaño
del archivo y luego dividir por el tamaño considerado de una línea promedio….
EJERCICIOS DEL DOCUMENTO IBM JAVA COLLECTIONS FRAMEWORK
Utilizando el documento disponible en la webasignatura “IBM JAVA COLLECTIONS FRAMEWORK”, se recomienda
realizar los siguientes ejercicios, que son todas implementaciones muy utilizadas habitualmente en programas
reales:
• Exercise 2. “How to use a TreeSet to provide a sorted JList”, pág. 38
• Exercise 3. “How to use an ArrayList with a JComboBox” , pág. 40
• Exercise 4. “How to use a map to count words”, pág. 41 */
//EJERCICIO 1
    public static void removeNullValues(HashMap<String, String> map) {
        map.values().removeIf(value -> value == null);
        System.out.println(map);
    }
    //EJERCICIO 2
    public static Map<String, String > inverir (Map<String, String> map) {
        Map<String, String> mapInvertido = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (mapInvertido.containsKey(entry.getValue())) {
                throw new IllegalArgumentException("El mapa tiene valores duplicados");
            }
            mapInvertido.put(entry.getValue(), entry.getKey());
        }
        return mapInvertido;

    }
    //EJERCICIO 3
    public static void ordenarCadenas(String cadenas) {
        String[] aux = cadenas.split(" ");
        TreeMap<Integer, LinkedList<String>> mapa = new TreeMap<>();
        for (String s : aux) {
            if (mapa.containsKey(s.length())) {
                mapa.get(s.length()).add(s);
                Collections.sort(mapa.get(s.length()));
            } else {
                mapa.put(s.length(), new LinkedList<String>());
                mapa.get(s.length()).add(s);
            }

        }
        System.out.println(mapa.values());
    }
    //EJERCICIO 4
    public static List<String> leerArchivo(String archivo) {
        FileReader fr = null; // pomer desp el archivo a insertar
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();

    


}
        return lineas;
    }
    public static void imprimirLineasAleatorias(List<String> lineas, int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            System.out.println(lineas.get(random.nextInt(lineas.size())));
        }
    }
}

