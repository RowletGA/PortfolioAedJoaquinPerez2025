/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EntradaTexto {
    public static void leerEntradaArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Leer el entero, el número de punto flotante y la cadena del archivo
            int entero = Integer.parseInt(br.readLine());
            double flotante = Double.parseDouble(br.readLine());
            String cadena = br.readLine();

            // Imprimir la salida requerida
            System.out.println("El entero leido es  "+ entero);
            System.out.println("El numero flotante es  "+ flotante);
            System.out.println("La cadena leia es \"" + cadena + "\"");
            System.out.println("Hola " + cadena + "! La suma de " + entero + " y " + flotante + " es " + (entero + flotante) + ".");
            System.out.println("La division entera de " + flotante + " y " + entero + " es " + ((int)flotante / entero) + " y su resto es " + (flotante % entero) + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\joaco\\OneDrive\\Documents\\NetBeansProjects\\UT1_PD6_2\\src\\Ut6Entrada.txt";
        leerEntradaArchivo(rutaArchivo);
        EntradaStdin.leerEntradaStdin();
    }
}
