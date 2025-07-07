package uy.edu.ucu.aed.parcial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import uy.edu.ucu.aed.tda.Ruta;
import uy.edu.ucu.aed.tda.TGrafoNoDirigido;

public class RedEvacuacion extends TGrafoNoDirigido {

    public RedEvacuacion() {
        super(new ArrayList<>(), new ArrayList<>());
    }

    public static class EstadoNodo {
        public double distancia;
        public int prioridadCount;

        public  EstadoNodo(double distancia, int prioridadCount) {
            this.distancia = distancia;
            this.prioridadCount = prioridadCount;
        }
    }

    public Map<Comparable, EstadoNodo> evacuarDesde(Comparable origen) {
        Map<Comparable, EstadoNodo> estado = new HashMap<>();
        Map<Comparable, Comparable> anteriores = new HashMap<>();

        for (Comparable etiqueta : getVertices().keySet()) {
            estado.put(etiqueta, new EstadoNodo(Double.POSITIVE_INFINITY, 0));
            anteriores.put(etiqueta, null);
        }

        estado.put(origen, new EstadoNodo(0.0, 0));

        PriorityQueue<Comparable> cola = new PriorityQueue<>((a, b) -> {
            EstadoNodo ea = estado.get(a);
            EstadoNodo eb = estado.get(b);
            if (Double.compare(ea.distancia, eb.distancia) != 0) {
                return Double.compare(ea.distancia, eb.distancia);
            } else {
                return Integer.compare(eb.prioridadCount, ea.prioridadCount); // Más prioritarias mejor
            }
        });

        cola.addAll(getVertices().keySet());

        while (!cola.isEmpty()) {
            Comparable actual = cola.poll();
            EstadoNodo estadoActual = estado.get(actual);

            for (Ruta r : getLasAristas()) {
                Comparable u = r.getEtiquetaOrigen();
                Comparable v = r.getEtiquetaDestino();

                Comparable vecino = null;
                if (u.equals(actual) && cola.contains(v)) vecino = v;
                else if (v.equals(actual) && cola.contains(u)) vecino = u;

                if (vecino != null) {
                    double nuevoCosto = estadoActual.distancia + r.getCosto();
                    int nuevasPrioritarias = estadoActual.prioridadCount + (r.getEsPrioritaria() ? 1 : 0);

                    EstadoNodo estadoVecino = estado.get(vecino);
                    if (nuevoCosto < estadoVecino.distancia ||
                       (nuevoCosto == estadoVecino.distancia && nuevasPrioritarias > estadoVecino.prioridadCount)) {

                        estado.put(vecino, new EstadoNodo(nuevoCosto, nuevasPrioritarias));
                        anteriores.put(vecino, actual);

                        cola.remove(vecino);
                        cola.add(vecino);
                    }
                }
            }
        }

        return estado;
    }
}

/*Una agencia de protección civil desea establecer planes de evacuación de emergencia desde la capital del país hacia todas las ciudades.
Para esto:

Las ciudades están conectadas por rutas, cada una con un costo de evacuación (puede representar congestión, pendiente, condiciones del camino, etc.).

Algunas rutas están marcadas como prioritarias, por ejemplo porque ya están equipadas con señalización, hospitales, recursos, etc.

 */