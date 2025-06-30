package com.example;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra,int pagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra,pagina);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (this.raiz == null) {
            return 0;
        } else {
            return raiz.buscar(palabra);
        }
    }
    
    public String buscar2(String palabra){
        if (this.raiz == null) {
            return "empty trie";
        } else {
            return raiz.buscar2(palabra);
        }
    }
    
    @Override
    public LinkedList<String> predecir(String prefijo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
