/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
public class Tablero {
    public static void imprimirTablero(int largo, int ancho) {
        for (int i = 0; i < largo; i++) { //itera cada fila (largo) 
            for (int j = 0; j < ancho; j++) { // itera las columnas (ancho)
                // imprime el simbolo con los parametros correspondientes
                System.out.print( "#" );
            }
            // Después de imprimir cada columna de la fila, imprimir un salto de línea para pasar a la siguiente fila
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Definir el número de filas y columnas del tablero
        int largo = 6;
        int ancho = 8;
        // Llamar a la función imprimirTablero para imprimir el tablero
        imprimirTablero(largo, ancho);
    }
}

