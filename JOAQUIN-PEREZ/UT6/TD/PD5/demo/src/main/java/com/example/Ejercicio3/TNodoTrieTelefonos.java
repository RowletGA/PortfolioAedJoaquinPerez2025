package Ejercicio3;

import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.tree.TreeNode;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private static final int CANT_CHR_ABECEDARIO = 10;
    private HashMap hijos;
    private boolean esPalabra;
    public TAbonado usuario;

    public TNodoTrieTelefonos() {
        hijos = new HashMap();
        esPalabra = false;
    }

    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        this.predecir(primerosDigitos, abonados);
    }

    public void predecir(String prefijo, LinkedList<TAbonado> abonados) {

        this.predecir(prefijo, abonados, this.buscarNodoTrie(prefijo));
    }

    private void predecir(String prefijo, LinkedList<TAbonado> abonados, TNodoTrieTelefonos nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                abonados.add(nodo.usuario);
            }
            char key;
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                key = (char) ('0' + c);
                if (nodo.hijos.containsKey(key)) {
                    predecir(prefijo, abonados, (TNodoTrieTelefonos) nodo.hijos.get(key));
                }
            }
        }
    }

    private TNodoTrieTelefonos buscarNodoTrie(String s) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < s.length(); c++) {
            if (!nodo.hijos.containsKey(s.charAt(c))) {
                return null;
            }
            nodo = (TNodoTrieTelefonos) nodo.hijos.get(s.charAt(c));
        }
        return nodo;
    }


    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < unAbonado.getTelefono().length(); c++) {
            if (!nodo.hijos.containsKey(unAbonado.getTelefono().charAt(c))) {
                TNodoTrieTelefonos aux = new TNodoTrieTelefonos();
                aux.usuario = unAbonado;
                nodo.hijos.put(unAbonado.getTelefono().charAt(c), aux);
            }
            nodo = (TNodoTrieTelefonos) nodo.hijos.get(unAbonado.getTelefono().charAt(c));
        }
        nodo.esPalabra = true;
    }

}
