package uy.edu.ucu.aed.parcial;

import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.Ruta;
import uy.edu.ucu.aed.tda.TGrafoNoDirigido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class RedDistribucion extends TGrafoNoDirigido {

    public RedDistribucion() {
        super(new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public List<Ruta> construirRedMinimaConPrioridad() {
        List<Ruta> resultado = new ArrayList<>();
        Map<Comparable, Ciudad> vertices = getVertices();

        if (!vertices.isEmpty()) {
            desvisitarVertices();

            // Inicializar cada ciudad como su propia colección
            Map<Comparable, List<Ciudad>> colecciones = new HashMap<>();
            for (Ciudad ciudad : vertices.values()) {
                List<Ciudad> nuevaCol = new ArrayList<>();
                nuevaCol.add(ciudad);
                colecciones.put(ciudad.getEtiqueta(), nuevaCol);
            }

            // Separar rutas prioritarias y no prioritarias
            List<Ruta> prioritarias = new ArrayList<>();
            List<Ruta> noPrioritarias = new ArrayList<>();

            for (Ruta r : lasAristas) {
                if (r.getEsPrioritaria()) {
                    prioritarias.add(r);
                } else {
                    noPrioritarias.add(r);
                }
            }

            // Ordenar ambas listas por costo
            prioritarias.sort(Comparator.comparingDouble(Ruta::getCosto));
            noPrioritarias.sort(Comparator.comparingDouble(Ruta::getCosto));

            // Unir ambas listas
            List<Ruta> rutasOrdenadas = new ArrayList<>();
            rutasOrdenadas.addAll(prioritarias);
            rutasOrdenadas.addAll(noPrioritarias);

            // Aplicar Kruskal modificado
            for (Ruta r : rutasOrdenadas) {
                List<Ciudad> colOrigen = colecciones.get(r.getEtiquetaOrigen());
                List<Ciudad> colDestino = colecciones.get(r.getEtiquetaDestino());

                if (colOrigen != colDestino) {
                    resultado.add(r);
                    colOrigen.addAll(colDestino);
                    for (Ciudad ciudad : colDestino) {
                        colecciones.put(ciudad.getEtiqueta(), colOrigen);
                    }
                }
            }
        }

        return resultado;
    }
}
