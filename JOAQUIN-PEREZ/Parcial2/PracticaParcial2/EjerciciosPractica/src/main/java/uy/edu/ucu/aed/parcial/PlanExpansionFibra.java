package uy.edu.ucu.aed.parcial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.Ruta;
import uy.edu.ucu.aed.tda.TGrafoNoDirigido;

public class PlanExpansionFibra extends TGrafoNoDirigido {

    public PlanExpansionFibra() {
        super(new ArrayList<>(), new ArrayList<>());
    }

    public List<Ruta> construirRedFibraDesde(Comparable capital) {
        List<Ruta> resultado = new ArrayList<>();
        Map<Comparable, Ciudad> vertices = getVertices();

        if (!vertices.containsKey(capital)) {
            System.out.println("Capital no existe.");
            return resultado;
        }

        // Inicializamos conjuntos
        Set<Comparable> conectados = new HashSet<>();
        Set<Comparable> noConectados = new HashSet<>(vertices.keySet());

        conectados.add(capital);
        noConectados.remove(capital);

        while (!noConectados.isEmpty()) {
            Ruta mejorRuta = buscarEnlaceMinimo(conectados, noConectados);
            if (mejorRuta == null) break;

            resultado.add(mejorRuta);
            Comparable nuevaCiudad = mejorRuta.getEtiquetaDestino();
            if (!conectados.contains(nuevaCiudad)) {
                conectados.add(nuevaCiudad);
                noConectados.remove(nuevaCiudad);
            } else {
                // puede estar invertido
                nuevaCiudad = mejorRuta.getEtiquetaOrigen();
                conectados.add(nuevaCiudad);
                noConectados.remove(nuevaCiudad);
            }
        }

        return resultado;
    }

    private Ruta buscarEnlaceMinimo(Set<Comparable> conectados, Set<Comparable> noConectados) {
        Ruta minimo = null;
        double costoMin = Double.MAX_VALUE;

        for (Comparable c1 : conectados) {
            for (Comparable c2 : noConectados) {
                for (Ruta r : lasAristas) {
                    if ((r.getEtiquetaOrigen().equals(c1) && r.getEtiquetaDestino().equals(c2)) ||
                        (r.getEtiquetaDestino().equals(c1) && r.getEtiquetaOrigen().equals(c2))) {
                        if (r.getCosto() < costoMin) {
                            costoMin = r.getCosto();
                            minimo = r;
                        }
                    }
                }
            }
        }

        return minimo;
    }
}
