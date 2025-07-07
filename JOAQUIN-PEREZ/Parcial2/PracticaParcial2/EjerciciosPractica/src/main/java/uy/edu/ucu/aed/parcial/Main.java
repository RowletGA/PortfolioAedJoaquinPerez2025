package uy.edu.ucu.aed.parcial;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.tda.Ruta;

public class Main {
    public static void main(String[] args) {
       String[] lineasCiudades = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/ciudades.txt", false);
       String[] lineasRutas = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/rutas.txt", false);




        // Kruskal modificado
        RedDistribucion red = new RedDistribucion();
        for (String ciudad : lineasCiudades) {
            red.insertarVertice(new Ciudad(ciudad));
        }

        for (String linea : lineasRutas) {
            String[] datos = linea.split(",");
            String origen = datos[0];
            String destino = datos[1];
            double costo = Double.parseDouble(datos[2]);
            boolean esPrioritaria = Boolean.parseBoolean(datos[3]);
            red.insertarArista(new Ruta(origen, destino, costo, esPrioritaria));
        }

        List<String> salidaKruskal = new ArrayList<>();
        salidaKruskal.add("==== Rutas seleccionadas (Kruskal con prioridad) ====");
        for (Ruta ruta : red.construirRedMinimaConPrioridad()) {
            salidaKruskal.add(ruta.getEtiquetaOrigen() + " -> " +
                    ruta.getEtiquetaDestino() + " (" + ruta.getCosto() + ")");
        }
        ManejadorArchivosGenerico.escribirArchivo("salida_kruskal.txt", salidaKruskal.toArray(new String[0]));

        // Prim desde capital
        PlanExpansionFibra fibra = new PlanExpansionFibra();
        for (String ciudad : lineasCiudades) {
            fibra.insertarVertice(new Ciudad(ciudad));
        }
        for (String linea : lineasRutas) {
            String[] datos = linea.split(",");
            String origen = datos[0];
            String destino = datos[1];
            double costo = Double.parseDouble(datos[2]);
            boolean esPrioritaria = Boolean.parseBoolean(datos[3]);
            fibra.insertarArista(new Ruta(origen, destino, costo, esPrioritaria));
        }

        List<String> salidaPrim = new ArrayList<>();
        salidaPrim.add("==== Rutas seleccionadas (Plan de expansión con Prim) ====");
        for (Ruta ruta : fibra.construirRedFibraDesde("Montevideo")) {
            salidaPrim.add(ruta.getEtiquetaOrigen() + " -> " +
                    ruta.getEtiquetaDestino() + " (" + ruta.getCosto() + ")");
        }
        ManejadorArchivosGenerico.escribirArchivo("salida_prim.txt", salidaPrim.toArray(new String[0]));

        System.out.println("Resultados generados en salida_kruskal.txt y salida_prim.txt");
    }
}
