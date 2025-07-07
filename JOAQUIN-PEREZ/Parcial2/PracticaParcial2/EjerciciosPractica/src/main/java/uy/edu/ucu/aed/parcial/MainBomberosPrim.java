// Archivo: MainBomberosPrim.java
package uy.edu.ucu.aed.parcial;

import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.tda.Ruta;

import java.util.*;

public class MainBomberosPrim {
    public static void main(String[] args) {
        // Leer archivos de entrada
        String[] lineasCiudades = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/ciudades.txt", false);
        String[] lineasRutas = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/rutas.txt", false);
        String[] lineasZonasCriticas = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/zonas_criticas.txt", false);

        // Armar conjunto de zonas críticas
        Set<Comparable> zonasCriticas = new HashSet<>();
        for (String ciudad : lineasZonasCriticas) {
            zonasCriticas.add(ciudad);
        }

        // Crear instancia del grafo
        RedBomberosPrim red = new RedBomberosPrim(zonasCriticas);

        // Insertar ciudades
        for (String ciudad : lineasCiudades) {
            red.insertarVertice(new Ciudad(ciudad));
        }

        // Insertar rutas
        for (String linea : lineasRutas) {
            String[] datos = linea.split(",");
            red.insertarArista(new Ruta(datos[0], datos[1], Double.parseDouble(datos[2]), false));
        }

        // Ejecutar algoritmo y guardar resultado
        List<Ruta> resultado = red.construirRedConCoberturaCritica();

        List<String> salida = new ArrayList<>();
        salida.add("==== Rutas seleccionadas para red de bomberos ====");
        for (Ruta r : resultado) {
            salida.add(r.getEtiquetaOrigen() + " -> " + r.getEtiquetaDestino() + " (" + r.getCosto() + ")");
        }

        // Escribir archivo de salida
        ManejadorArchivosGenerico.escribirArchivo("src/uy/edu/ucu/aed/parcial/salida_red_bomberos.txt", salida.toArray(new String[0]));
        System.out.println("Archivo generado: salida_red_bomberos.txt");
    }
}
