package com.example;

import java.nio.ShortBuffer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TArbolGenerico<Integer> arbol = new TArbolGenerico<>();
        arbol.insertar(100, null);
        arbol.insertar(50, 100);
        arbol.insertar(150, 100);
        arbol.insertar(25, 50);
        arbol.insertar(75, 50);
        System.out.println(arbol.preOrden());
        System.out.println(arbol.postOrden());
        System.out.println(arbol.buscar (50).getEtiqueta());
        System.out.println(arbol.listarIndentado());
    }
}