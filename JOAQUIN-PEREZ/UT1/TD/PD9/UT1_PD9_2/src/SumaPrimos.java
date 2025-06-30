/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
import java.util.Scanner;

public class SumaPrimos {
    
    public static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2) { //pregunta so es divisible por algún número impar entre 3 y su raíz cuadrada. Si el número n es divisible por algún número en este rango, entonces no es primo.
            if (n % i == 0) { // si es divisible por algun numero impar, entonces no es primo
                prime = false;
                break; // corta 
            }
        }
        if ((n % 2 != 0 && prime && n > 2) || n == 2) { //verifica que sea primo
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        long num = entrada.nextLong();
        
        long i = 0;
        long suma = 0;
        if (isPrime(num)) { // si es primo itera sobre los numeros del 0 hasta el input
            while (i <= num) {
                if (i % 2 == 0) { // si es par se agrega a la suma
                    suma += i;
                }
                i++;
            }
            System.out.println("El número " + num + " es primo.");
            System.out.println("La suma de los números pares desde 0 hasta " + num + " es " + suma + ".");
        } else {
            while (i <= num) { // misma logica para la suma de no primos
                if (i % 2 != 0) {
                    suma += i;
                }
                i++;
            }
            System.out.println("El número " + num + " no es primo.");
            System.out.println("La suma de los números impares desde 0 hasta " + num + " es " + suma + ".");
        }
        
    }
}
