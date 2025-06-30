/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 * En lenguaje natural, describe previamente la operación y las condiciones que deben cumplirse
para que sea posible realizarla. 
* Para poder realizar una operación entre vectores, es necesario que los arrays de estos tengan la misma cantidad
* de elementos, para eso primero tenemos que hacer un filtro donde la longitud de los vectores sea = o distinta
* para poder cumplir con el ejercicio.
* Un ejemplo de esto seria el vector 1 {1,2} y el vector 2 {3,4}
* la multiplicación sería 1*3 + 1*4
 */

public class ArraysVectores {
    public static int multiplyVectors(int[] vector1, int[] vector2) {
        if (vector1.length != vector2.length) {
            System.out.println("No se pueden multiplicar los vectores: tienen diferente tamaño.");
            return 0;
        }

        int result = 0;
        for (int i = 0; i < vector1.length; i++) {
            result += vector1[i] * vector2[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] vector1 = {1, 55, 7};
        int[] vector2 = {41, 6, 9};
        
        int result = multiplyVectors(vector1, vector2);
        System.out.println("El resultado de la multiplicacion de los vectores es: " + result);
    }
}
