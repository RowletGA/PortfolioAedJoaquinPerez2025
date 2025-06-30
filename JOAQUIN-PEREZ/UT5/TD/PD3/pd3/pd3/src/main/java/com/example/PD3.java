package com.example;

public class PD3 {

    public static void main(String[] args) {
        
        TArbolTrie trie = new TArbolTrie();
        
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(".\\libro.txt");
        // Indizar libro, falta agregarlo a una clase.
        for (int i = 0; i < lineas.length; i++){
            String aux = lineas[i].toLowerCase().replace("-", " ");
            StringBuilder copyAux = new StringBuilder();
            for (char c : aux.toCharArray()){
                if ((c >= 'a' && c <= 'z') || c == ' ' ){
                    copyAux.append(c);
                }
            }
            lineas[i] = copyAux.toString();
        }
        
        int pagina = 0;
        
        for(int i = 0; i<lineas.length; i++){
            if (i%50 == 0){
                pagina ++;
            }
            String[] aux = lineas[i].split(" ");
            for(String str : aux){
                trie.insertar(str,pagina);
            }
        }
        
        
        
        trie.imprimir();
        
        System.out.println(trie.buscar2("sherlo"));
        
        
        
        
    }
}
