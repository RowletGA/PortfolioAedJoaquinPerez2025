/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"
        String[] claves_insertar = ManejadorArchivosGenerico.leerArchivo("claves_insertar.txt");
        Hash tabla = new Hash();
        Double tamano = claves_insertar.length / 0.75;
        System.out.println("Tamaño de la tabla: " + tamano);
        for (int i = 0; i < claves_insertar.length; i++){
            int clave = Integer.parseInt(claves_insertar[i]);
            int cont = tabla.insertar(clave);
            System.out.println("Clave: " + clave + " - Colisiones: " + cont);
        }
        
        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
        String[] claves_buscar = ManejadorArchivosGenerico.leerArchivo("claves_buscar.txt");
        for (int i = 0; i < claves_buscar.length; i++){
            int clave = Integer.parseInt(claves_buscar[i]);
            int cont = tabla.buscar(clave);
            System.out.println("Clave: " + clave + " - Colisiones: " + cont);
    }
    
}
}
