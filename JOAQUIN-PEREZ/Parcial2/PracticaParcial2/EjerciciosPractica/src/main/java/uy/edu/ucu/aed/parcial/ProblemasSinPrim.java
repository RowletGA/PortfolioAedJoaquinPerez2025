// Archivo: ProblemasSinPrim.java
package uy.edu.ucu.aed.parcial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.Ruta;
import uy.edu.ucu.aed.tda.TGrafoNoDirigido;

public class ProblemasSinPrim {

    // === MÉTODOS ORIGINALES RESTAURADOS ===

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

    // === NUEVOS MÉTODOS PRIM AGREGADOS ===

       public static List<Ruta> primDesdeCapital(TGrafoNoDirigido grafo, Comparable capital) {
        List<Ruta> resultado = new ArrayList<>();
        Set<Comparable> visitados = new HashSet<>();
        PriorityQueue<Ruta> cola = new PriorityQueue<>(Comparator.comparingDouble(Ruta::getCosto));

        visitados.add(capital);
        for (Ruta r : grafo.getLasAristas()) {
            if (r.getEtiquetaOrigen().equals(capital) || r.getEtiquetaDestino().equals(capital)) {
                cola.add(r);
            }
        }

        while (!cola.isEmpty() && visitados.size() < grafo.getVertices().size()) {
            Ruta r = cola.poll();
            Comparable nuevo = null;
            if (visitados.contains(r.getEtiquetaOrigen()) && !visitados.contains(r.getEtiquetaDestino())) {
                nuevo = r.getEtiquetaDestino();
            } else if (visitados.contains(r.getEtiquetaDestino()) && !visitados.contains(r.getEtiquetaOrigen())) {
                nuevo = r.getEtiquetaOrigen();
            }
            if (nuevo != null) {
                resultado.add(r);
                visitados.add(nuevo);
                for (Ruta r2 : grafo.getLasAristas()) {
                    if ((r2.getEtiquetaOrigen().equals(nuevo) && !visitados.contains(r2.getEtiquetaDestino())) ||
                        (r2.getEtiquetaDestino().equals(nuevo) && !visitados.contains(r2.getEtiquetaOrigen()))) {
                        cola.add(r2);
                    }
                }
            }
        }
        return resultado;
    }

    // MAIN de prueba para Prim desde capital
    public static void mainPrimDesdeCapital() {
        List<Ciudad> ciudades = List.of(
            new Ciudad("Montevideo"), new Ciudad("Canelones"),
            new Ciudad("Florida"), new Ciudad("Rivera")
        );
        List<Ruta> rutas = List.of(
            new Ruta("Montevideo", "Canelones", 5, false),
            new Ruta("Montevideo", "Florida", 10, false),
            new Ruta("Canelones", "Rivera", 3, false),
            new Ruta("Florida", "Rivera", 2, false)
        );
        TGrafoNoDirigido g = new TGrafoNoDirigido(ciudades, rutas);

        System.out.println("PRIM DESDE CAPITAL (Montevideo):");
        for (Ruta r : primDesdeCapital(g, "Montevideo")) {
            System.out.println(r.getEtiquetaOrigen() + " -> " + r.getEtiquetaDestino() + " ($" + r.getCosto() + ")");
        }
    }

    // ================== PRIM CON RUTAS PREINSTALADAS ==================
    /**
     * Enunciado:
     * La red eléctrica ya tiene algunas rutas instaladas.
     * Se desea expandir desde esas ciudades preconectadas usando Prim,
     * sin perder las rutas existentes.
     */
    public static List<Ruta> primConRutasPreinstaladas(TGrafoNoDirigido grafo, List<Ruta> preinstaladas) {
        List<Ruta> resultado = new ArrayList<>(preinstaladas);
        Set<Comparable> visitados = new HashSet<>();
        PriorityQueue<Ruta> cola = new PriorityQueue<>(Comparator.comparingDouble(Ruta::getCosto));

        for (Ruta r : preinstaladas) {
            visitados.add(r.getEtiquetaOrigen());
            visitados.add(r.getEtiquetaDestino());
        }

        for (Ruta r : grafo.getLasAristas()) {
            if (visitados.contains(r.getEtiquetaOrigen()) ^ visitados.contains(r.getEtiquetaDestino())) {
                cola.add(r);
            }
        }

        while (!cola.isEmpty() && visitados.size() < grafo.getVertices().size()) {
            Ruta r = cola.poll();
            Comparable nuevo = null;
            if (visitados.contains(r.getEtiquetaOrigen()) && !visitados.contains(r.getEtiquetaDestino())) {
                nuevo = r.getEtiquetaDestino();
            } else if (visitados.contains(r.getEtiquetaDestino()) && !visitados.contains(r.getEtiquetaOrigen())) {
                nuevo = r.getEtiquetaOrigen();
            }
            if (nuevo != null) {
                resultado.add(r);
                visitados.add(nuevo);
                for (Ruta r2 : grafo.getLasAristas()) {
                    if ((r2.getEtiquetaOrigen().equals(nuevo) && !visitados.contains(r2.getEtiquetaDestino())) ||
                        (r2.getEtiquetaDestino().equals(nuevo) && !visitados.contains(r2.getEtiquetaOrigen()))) {
                        cola.add(r2);
                    }
                }
            }
        }
        return resultado;
    }

    // MAIN de prueba para Prim con rutas preinstaladas
    public static void mainPrimPreinstaladas() {
        List<Ciudad> ciudades = List.of(
            new Ciudad("Montevideo"), new Ciudad("Canelones"),
            new Ciudad("Florida"), new Ciudad("Rivera")
        );
        List<Ruta> rutas = List.of(
            new Ruta("Montevideo", "Canelones", 5, false),
            new Ruta("Montevideo", "Florida", 10, false),
            new Ruta("Canelones", "Rivera", 3, false),
            new Ruta("Florida", "Rivera", 2, false)
        );
        List<Ruta> preinstaladas = List.of(new Ruta("Montevideo", "Canelones", 5, false));
        TGrafoNoDirigido g = new TGrafoNoDirigido(ciudades, rutas);

        System.out.println("\nPRIM CON RUTAS PREINSTALADAS:");
        for (Ruta r : primConRutasPreinstaladas(g, preinstaladas)) {
            System.out.println(r.getEtiquetaOrigen() + " -> " + r.getEtiquetaDestino() + " ($" + r.getCosto() + ")");
        }
    }

    public static void main(String[] args) {
        mainPrimDesdeCapital();
        mainPrimPreinstaladas();
    }
} 

  // === MÉTODOS ORIGINALES RESTAURADOS ===

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
