package com.example;

import java.util.*;

public class Main {
   


// Parte A Se utilizó la clase HashMap de la api de colecciones de Java, debido a que esta clase permite almacenar
// pares de clave valor, en este caso la palabra y la cantidad de veces que aparece en el texto. Además, esta clase
// permite acceder a los valores de manera eficiente, lo que facilita la implementación de la funcionalidad requerida.
public static void main(String[] args) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(".\\libro.txt");
        for (String s : diezPalabrasMasRepetidos(ocurrenciasPalabras(lineas))){
            System.out.print(s + " - ");
        }
    }

 

    public static void manejadorLibro(String[] lineas) {
        for (int i = 0; i < lineas.length; i++) {
            String aux = lineas[i].toLowerCase().replace("-", " ");
            StringBuilder copyAux = new StringBuilder();
            for (char c : aux.toCharArray()) {
                if ((c >= 'a' && c <= 'z') || c == ' ') {
                    copyAux.append(c);
                }
            }
            lineas[i] = copyAux.toString();
        }
    }

    public static HashMap<String, Integer> ocurrenciasPalabras(String[] lineas) {
        HashMap<String, Integer> mapa = new HashMap<>();
        for (String s : lineas) {
            String[] aux = s.split(" ");
            for (String palabra : aux) {
                if (mapa.containsKey(palabra)) {
                    mapa.replace(palabra, mapa.get(palabra) + 1);
                } else {
                    mapa.put(palabra, 1);
                }
            }
        }

        return mapa;
    }

    private static int[] diezValoresMasRepetidas(HashMap<String, Integer> mapa) {
        
        HashMap<String,Integer> mapAux = new HashMap<>(mapa);
        int[] claves = new int[10];
        for (int i = 0; i < 10; i++) {
            Integer maxValue = Collections.max(mapAux.values());
            mapAux.values().remove(Collections.max(mapAux.values()));
            claves[i] = maxValue;
        }

        return claves;
    }
    
    public static String[] diezPalabrasMasRepetidos(HashMap<String,Integer> mapa){
        String[] palabras = new String[10];
        int[] claves = diezValoresMasRepetidas(mapa);
        // Conseguir las palabras //
        for (int i = 0; i < 10; i++) {
            for (var par : mapa.entrySet()) {
                if (Objects.equals(claves[i], par.getValue())) {
                    palabras[i] = par.getKey();
                }
            }
        }
        return palabras;
    }

}

