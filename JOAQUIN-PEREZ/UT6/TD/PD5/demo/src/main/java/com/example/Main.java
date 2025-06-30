package com.example;

public class Main {
    public static void main(String[] args){
        
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/main/java/listado-general_desordenado.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();
        
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] abonados = ManejadorArchivosGenerico.leerArchivo("./src/main/java/abonados.txt");

        for (String str : abonados) {
            String[] aux = str.split(",");
            TAbonado abonado = new TAbonado(aux[1], aux[0]);
            trieAbonados.insertar(abonado);
        }
        
        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);
        String[] busqueda = new String[ab.size()];
        int i = 0;
        for (TAbonado a : ab){
            System.out.println(a.getTelefono()+" , "+a.getNombre());
            String aux = a.getTelefono()+" , "+a.getNombre();
            busqueda[i] = aux;
            i++;
        }
        
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        ManejadorArchivosGenerico.escribirArchivo(".//src//salida.txt", busqueda);
    }
}