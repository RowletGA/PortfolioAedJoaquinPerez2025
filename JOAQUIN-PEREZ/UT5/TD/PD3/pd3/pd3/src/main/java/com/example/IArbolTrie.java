package com.example;
import java.util.LinkedList;
public interface IArbolTrie {

    void imprimir();
    int buscar(String palabra);

    void insertar(String palabra,int pagina);

    LinkedList<String> predecir(String prefijo);
    
}

