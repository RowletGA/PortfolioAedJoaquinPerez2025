package uy.edu.ucu.aed.parcial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import uy.edu.ucu.aed.tda.Ruta;
import uy.edu.ucu.aed.tda.TGrafoNoDirigido;

public class RedBomberosPrim extends TGrafoNoDirigido {

    private Set<Comparable> zonasCriticas;

    public RedBomberosPrim(Set<Comparable> zonasCriticas) {
        super(new ArrayList<>(), new ArrayList<>());
        this.zonasCriticas = zonasCriticas;
    }

    /**
     * Construye la red mínima usando Prim, pero luego asegura que cada ciudad crítica
     * tenga al menos 2 conexiones.
     */
    public List<Ruta> construirRedConCoberturaCritica() {
        List<Ruta> resultado = new ArrayList<>();
        Set<Comparable> visitados = new HashSet<>();
        PriorityQueue<Ruta> cola = new PriorityQueue<>(Comparator.comparingDouble(Ruta::getCosto));

        // Elegimos cualquier ciudad como punto de partida
        if (getVertices().isEmpty()) return resultado;
        Comparable inicio = getVertices().keySet().iterator().next();
        visitados.add(inicio);

        // Agregar rutas iniciales desde el nodo de inicio
        for (Ruta r : getLasAristas()) {
            if (r.getEtiquetaOrigen().equals(inicio) || r.getEtiquetaDestino().equals(inicio)) {
                cola.add(r);
            }
        }

        // Ejecutar Prim normal
        while (!cola.isEmpty() && visitados.size() < getVertices().size()) {
            Ruta r = cola.poll();
            Comparable u = r.getEtiquetaOrigen();
            Comparable v = r.getEtiquetaDestino();

            if (visitados.contains(u) && !visitados.contains(v)) {
                resultado.add(r);
                visitados.add(v);
                for (Ruta r2 : getLasAristas()) {
                    if ((r2.getEtiquetaOrigen().equals(v) && !visitados.contains(r2.getEtiquetaDestino())) ||
                        (r2.getEtiquetaDestino().equals(v) && !visitados.contains(r2.getEtiquetaOrigen()))) {
                        cola.add(r2);
                    }
                }
            } else if (visitados.contains(v) && !visitados.contains(u)) {
                resultado.add(r);
                visitados.add(u);
                for (Ruta r2 : getLasAristas()) {
                    if ((r2.getEtiquetaOrigen().equals(u) && !visitados.contains(r2.getEtiquetaDestino())) ||
                        (r2.getEtiquetaDestino().equals(u) && !visitados.contains(r2.getEtiquetaOrigen()))) {
                        cola.add(r2);
                    }
                }
            }
        }

        // Paso adicional: verificar cobertura crítica
        Map<Comparable, Integer> grado = new HashMap<>();
        for (Ruta r : resultado) {
            grado.put(r.getEtiquetaOrigen(), grado.getOrDefault(r.getEtiquetaOrigen(), 0) + 1);
            grado.put(r.getEtiquetaDestino(), grado.getOrDefault(r.getEtiquetaDestino(), 0) + 1);
        }

        // Reforzar zonas críticas con una segunda conexión si solo tienen una
        for (Comparable ciudad : zonasCriticas) {
            if (grado.getOrDefault(ciudad, 0) < 2) {
                // Buscar ruta extra más barata que conecte la ciudad crítica a otra ya conectada
                Ruta mejor = null;
                for (Ruta r : getLasAristas()) {
                    if ((r.getEtiquetaOrigen().equals(ciudad) || r.getEtiquetaDestino().equals(ciudad)) &&
                        !resultado.contains(r)) {
                        if (mejor == null || r.getCosto() < mejor.getCosto()) {
                            mejor = r;
                        }
                    }
                }
                if (mejor != null) {
                    resultado.add(mejor);
                }
            }
        }

        return resultado;
    }
}
