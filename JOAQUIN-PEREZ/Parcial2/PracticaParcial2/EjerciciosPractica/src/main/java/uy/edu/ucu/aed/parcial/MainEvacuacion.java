package uy.edu.ucu.aed.parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.tda.Ruta;

public class MainEvacuacion {
    public static void main(String[] args) {
        String[] lineasCiudades = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/ciudades.txt", false);
        String[] lineasRutas = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/rutas.txt", false);

        RedEvacuacion red = new RedEvacuacion();

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

        Map<Comparable, RedEvacuacion.EstadoNodo> resultado = red.evacuarDesde("Montevideo");

        List<String> salida = new ArrayList<>();
        salida.add("==== Caminos mínimos de evacuación desde Montevideo ====");
        for (Map.Entry<Comparable, RedEvacuacion.EstadoNodo> entry : resultado.entrySet()) {
            String linea = entry.getKey() + ": costo = " + entry.getValue().distancia +
                    ", rutas prioritarias = " + entry.getValue().prioridadCount;
            salida.add(linea);
        }

        ManejadorArchivosGenerico.escribirArchivo("src/uy/edu/ucu/aed/parcial/salida_dijkstra.txt", salida.toArray(new String[0]));
        System.out.println("Archivo generado: salida_dijkstra.txt");
    }
}
