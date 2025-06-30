package com.example;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas = new LinkedList<>();

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra,int pag) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        if (!nodo.paginas.contains(pag)){
            nodo.paginas.add(pag);
        }
        nodo.esPalabra = true;
    }
    
    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + " " + nodo.paginas.toString().replace("["," ").replace("]"," "));
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        
        imprimir("", this);
    }
    
      private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
     
         // implementar
        
        return nodo;
    }
      
    private TNodoTrie buscarNodoTrie2(String s) {
        
        
        TNodoTrie nodo = this;
        
        return nodo;
    }
    
     private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
     // implementar
       
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int buscar(String s) {
        TNodoTrie nodoActual = this;
        int cont = 0;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodoActual.hijos[indice] == null) {
                return 0;
            }
            cont++;
            nodoActual = nodoActual.hijos[indice];
        }
        return cont;
    }
    
    public String buscar2(String s){
        TNodoTrie nodoActual = this;
        int cont = 0;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            cont++;
            if (nodoActual.hijos[indice] == null) {
                return s + " not found in trie, cant. comparaciones: " + cont;
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if(nodoActual.esPalabra){
            return s + " Esta en las paginas: " + nodoActual.paginas.toString().replace("["," ").replace("]"," ");
        }
        return s + " not found in trie, cant. comparaciones: " + cont;      
    }
}
    
