package uy.edu.ucu.aed.parcial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import uy.edu.ucu.aed.tda.Ruta;
import uy.edu.ucu.aed.tda.TGrafoNoDirigido;

/**
 * Implementa una variante del algoritmo de Prim, donde se parte de rutas preinstaladas obligatorias.
 * El objetivo es completar una red de energía con costo mínimo, expandiendo desde los nodos ya conectados.
 */
public class RedEnergiaPrim extends TGrafoNoDirigido {

    // Lista de rutas que ya están instaladas y deben formar parte obligatoria de la solución
    private List<Ruta> rutasPreinstaladas;

    /**
     * Constructor que inicializa el grafo vacío y guarda las rutas preinstaladas.
     */
    public RedEnergiaPrim(List<Ruta> rutasPreinstaladas) {
        super(new ArrayList<>(), new ArrayList<>());
        this.rutasPreinstaladas = rutasPreinstaladas;
    }

    /**
     * Algoritmo que construye un Árbol de Expansión Mínimo, incluyendo rutas preinstaladas obligatorias.
     * @return Lista de rutas seleccionadas para formar la red de energía.
     */
    public List<Ruta> construirRedEnergiaConPrim() {
        List<Ruta> resultado = new ArrayList<>(); // Lista de rutas seleccionadas
        Set<Comparable> visitados = new HashSet<>(); // Conjunto de ciudades ya conectadas
        PriorityQueue<Ruta> cola = new PriorityQueue<>(Comparator.comparingDouble(Ruta::getCosto)); // Cola prioritaria por menor costo

        // Paso 1: Agregar las rutas preinstaladas al grafo y marcarlas como parte del resultado
        for (Ruta r : rutasPreinstaladas) {
            insertarArista(r); // Insertar la arista al grafo real
            resultado.add(r);  // Agregarla al resultado
            visitados.add(r.getEtiquetaOrigen());  // Marcar ambas ciudades como conectadas
            visitados.add(r.getEtiquetaDestino());
        }

        // Paso 2: Cargar en la cola las rutas que conectan nodos visitados con no visitados
        for (Ruta r : getLasAristas()) {
            // Se usa XOR: exactamente una de las dos ciudades debe estar conectada
            if (visitados.contains(r.getEtiquetaOrigen()) ^ visitados.contains(r.getEtiquetaDestino())) { 
                cola.add(r); // Candidata válida para expandir el MST
            }
        }

        // Paso 3: Ejecutar Prim desde los nodos conectados, expandiendo el MST
        while (!cola.isEmpty() && visitados.size() < getVertices().size()) {
            Ruta r = cola.poll(); // Sacar la ruta de menor costo
            Comparable u = r.getEtiquetaOrigen();
            Comparable v = r.getEtiquetaDestino();

            // Si u está conectado pero v no → expandimos hacia v
            if (visitados.contains(u) && !visitados.contains(v)) {
                resultado.add(r); // Agregar la ruta al resultado
                visitados.add(v); // Marcar la nueva ciudad como conectada

                // Agregar nuevas rutas desde v a la cola si el destino aún no está visitado
                for (Ruta r2 : getLasAristas()) {
                    if (r2.getEtiquetaOrigen().equals(v) && !visitados.contains(r2.getEtiquetaDestino())) {
                        cola.add(r2);
                    } else if (r2.getEtiquetaDestino().equals(v) && !visitados.contains(r2.getEtiquetaOrigen())) {
                        cola.add(r2);
                    }
                }

            // Caso inverso: v está conectado y u no → expandimos hacia u
            } else if (visitados.contains(v) && !visitados.contains(u)) {
                resultado.add(r);
                visitados.add(u);

                for (Ruta r2 : getLasAristas()) {
                    if (r2.getEtiquetaOrigen().equals(u) && !visitados.contains(r2.getEtiquetaDestino())) {
                        cola.add(r2);
                    } else if (r2.getEtiquetaDestino().equals(u) && !visitados.contains(r2.getEtiquetaOrigen())) {
                        cola.add(r2);
                    }
                }
            }
        }

        return resultado; // Devolver el conjunto de rutas seleccionadas
    }
}
  public static List<Ruta> kruskalConCiudadesClave(Collection<Ciudad> ciudades, Collection<Ruta> rutas, Set<Comparable> claves) {
        List<Ruta> resultado = new ArrayList<>();
        Map<Comparable, List<Ciudad>> conjuntos = new HashMap<>();
        for (Ciudad c : ciudades) {
            List<Ciudad> nuevo = new ArrayList<>();
            nuevo.add(c);
            conjuntos.put(c.getEtiqueta(), nuevo);
        }

        List<Ruta> prioritarias = new ArrayList<>();
        List<Ruta> normales = new ArrayList<>();
        for (Ruta r : rutas) {
            if (r.getEsPrioritaria()) prioritarias.add(r);
            else normales.add(r);
        }

        prioritarias.sort(Comparator.comparingDouble(Ruta::getCosto));
        normales.sort(Comparator.comparingDouble(Ruta::getCosto));
        List<Ruta> todas = new ArrayList<>();
        todas.addAll(prioritarias);
        todas.addAll(normales);

        for (Ruta r : todas) {
            List<Ciudad> conjU = conjuntos.get(r.getEtiquetaOrigen());
            List<Ciudad> conjV = conjuntos.get(r.getEtiquetaDestino());
            if (conjU != conjV) {
                resultado.add(r);
                conjU.addAll(conjV);
                for (Ciudad c : conjV) conjuntos.put(c.getEtiqueta(), conjU);
            }
        }

        Set<Comparable> conectados = new HashSet<>();
        for (Ruta r : resultado) {
            conectados.add(r.getEtiquetaOrigen());
            conectados.add(r.getEtiquetaDestino());
        }
        for (Ruta r : rutas) {
            if (resultado.contains(r)) continue;
            if (claves.contains(r.getEtiquetaOrigen()) && !conectados.contains(r.getEtiquetaOrigen())) {
                resultado.add(r);
                conectados.add(r.getEtiquetaOrigen());
            } else if (claves.contains(r.getEtiquetaDestino()) && !conectados.contains(r.getEtiquetaDestino())) {
                resultado.add(r);
                conectados.add(r.getEtiquetaDestino());
            }
        }
        return resultado;
    }

    public static int contarComponentesConectados(TGrafoNoDirigido grafo) {
        Set<Comparable> visitados = new HashSet<>();
        int componentes = 0;
        for (Comparable nodo : grafo.getVertices().keySet()) {
            if (!visitados.contains(nodo)) {
                componentes++;
                Queue<Comparable> cola = new LinkedList<>();
                cola.add(nodo);
                visitados.add(nodo);
                while (!cola.isEmpty()) {
                    Comparable actual = cola.poll();
                    for (Ruta r : grafo.getLasAristas()) {
                        Comparable vecino = null;
                        if (r.getEtiquetaOrigen().equals(actual)) vecino = r.getEtiquetaDestino();
                        else if (r.getEtiquetaDestino().equals(actual)) vecino = r.getEtiquetaOrigen();
                        if (vecino != null && !visitados.contains(vecino)) {
                            visitados.add(vecino);
                            cola.add(vecino);
                        }
                    }
                }
            }
        }
        return componentes;
    }

    public static Map<Comparable, Double> dijkstraConBonus(TGrafoNoDirigido grafo, Comparable origen) {
        Map<Comparable, Double> dist = new HashMap<>();
        PriorityQueue<Comparable> cola = new PriorityQueue<>(Comparator.comparingDouble(dist::get));

        for (Comparable v : grafo.getVertices().keySet()) {
            dist.put(v, Double.POSITIVE_INFINITY);
        }
        dist.put(origen, 0.0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            Comparable actual = cola.poll();
            for (Ruta r : grafo.getLasAristas()) {
                Comparable vecino = null;
                if (r.getEtiquetaOrigen().equals(actual)) vecino = r.getEtiquetaDestino();
                else if (r.getEtiquetaDestino().equals(actual)) vecino = r.getEtiquetaOrigen();

                if (vecino != null) {
                    double peso = r.getCosto();
                    if (r.getEsPrioritaria()) peso *= 0.8;
                    double nuevoDist = dist.get(actual) + peso;
                    if (nuevoDist < dist.get(vecino)) {
                        dist.put(vecino, nuevoDist);
                        cola.add(vecino);
                    }
                }
            }
        }

        return dist;
    }

    public static List<Ruta> detectarPuentes(TGrafoNoDirigido grafo) {
        List<Ruta> puentes = new ArrayList<>();
        int originalComponentes = contarComponentesConectados(grafo);

        for (Ruta r : grafo.getLasAristas()) {
            List<Ruta> copia = new ArrayList<>(grafo.getLasAristas());
            copia.remove(r);
            TGrafoNoDirigido reducido = new TGrafoNoDirigido(grafo.getVertices().values(), copia);
            if (contarComponentesConectados(reducido) > originalComponentes) {
                puentes.add(r);
            }
        }

        return puentes;
    }

    // === BEA - Recorrido por Anchura (BFS) ===
    public static List<Comparable> beaDesde(TGrafoNoDirigido grafo, Comparable origen) {
        List<Comparable> recorrido = new ArrayList<>();
        Set<Comparable> visitados = new HashSet<>();
        Queue<Comparable> cola = new LinkedList<>();
        cola.add(origen);
        visitados.add(origen);

        while (!cola.isEmpty()) {
            Comparable actual = cola.poll();
            recorrido.add(actual);
            for (Ruta r : grafo.getLasAristas()) {
                Comparable vecino = null;
                if (r.getEtiquetaOrigen().equals(actual)) vecino = r.getEtiquetaDestino();
                else if (r.getEtiquetaDestino().equals(actual)) vecino = r.getEtiquetaOrigen();

                if (vecino != null && !visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        return recorrido;
    }

    // === DFS - Detectar ciclo ===
    public static boolean dfsTieneCiclo(TGrafoNoDirigido grafo) {
        Set<Comparable> visitados = new HashSet<>();
        for (Comparable nodo : grafo.getVertices().keySet()) {
            if (!visitados.contains(nodo)) {
                if (dfsVisit(grafo, nodo, null, visitados)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsVisit(TGrafoNoDirigido grafo, Comparable actual, Comparable padre, Set<Comparable> visitados) {
        visitados.add(actual);
        for (Ruta r : grafo.getLasAristas()) {
            Comparable vecino = null;
            if (r.getEtiquetaOrigen().equals(actual)) vecino = r.getEtiquetaDestino();
            else if (r.getEtiquetaDestino().equals(actual)) vecino = r.getEtiquetaOrigen();

            if (vecino != null && !vecino.equals(padre)) {
                if (visitados.contains(vecino)) return true;
                if (!visitados.contains(vecino)) {
                    if (dfsVisit(grafo, vecino, actual, visitados)) return true;
                }
            }
        }
        return false;
    }
}
 