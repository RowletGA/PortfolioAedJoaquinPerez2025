package com.example;
import java.util.LinkedList;
public interface INodoTrie {

    int buscar(String s); // devuelve la cantidad de comparaciones!
    void imprimir();

    void insertar(String unaPalabra, int pag);
    public void predecir(String prefijo, LinkedList<String> palabras);
    
    
}
