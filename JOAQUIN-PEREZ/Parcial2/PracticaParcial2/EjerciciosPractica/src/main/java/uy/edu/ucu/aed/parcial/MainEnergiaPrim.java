package uy.edu.ucu.aed.parcial;

import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.tda.Ruta;

import java.util.*;

public class MainEnergiaPrim {
    public static void main(String[] args) {
        // Leer archivos de entrada con ciudades, rutas generales y rutas preinstaladas
        String[] lineasCiudades = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/ciudades.txt", false);
        String[] lineasRutas = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/rutas.txt", false);
        String[] lineasPreinstaladas = ManejadorArchivosGenerico.leerArchivo("src/uy/edu/ucu/aed/parcial/preinstaladas.txt", false);

        // Crear lista de rutas preinstaladas a partir del archivo
        List<Ruta> rutasPreinstaladas = new ArrayList<>();
        for (String linea : lineasPreinstaladas) {
            String[] datos = linea.split(",");
            rutasPreinstaladas.add(new Ruta(datos[0], datos[1], Double.parseDouble(datos[2]), Boolean.parseBoolean(datos[3])));
        }

        // Crear objeto RedEnergiaPrim con rutas preinstaladas
        RedEnergiaPrim red = new RedEnergiaPrim(rutasPreinstaladas);

        // Insertar todas las ciudades
        for (String ciudad : lineasCiudades) {
            red.insertarVertice(new Ciudad(ciudad));
        }

        // Insertar todas las rutas del grafo (incluye las preinstaladas también)
        for (String linea : lineasRutas) {
            String[] datos = linea.split(",");
            red.insertarArista(new Ruta(datos[0], datos[1], Double.parseDouble(datos[2]), Boolean.parseBoolean(datos[3])));
        }

        // Ejecutar el algoritmo de Prim modificado
        List<Ruta> resultado = red.construirRedEnergiaConPrim();

        // Preparar salida
        List<String> salida = new ArrayList<>();
        salida.add("==== Rutas seleccionadas para red de energía ====");
        for (Ruta r : resultado) {
            salida.add(r.getEtiquetaOrigen() + " -> " + r.getEtiquetaDestino() + " (" + r.getCosto() + ")");
        }

        // Escribir archivo de salida
        ManejadorArchivosGenerico.escribirArchivo("src/uy/edu/ucu/aed/parcial/salida_red_energia.txt", salida.toArray(new String[0]));
        System.out.println("Archivo generado: salida_red_energia.txt");
    }
}
