/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joaco
 */
import java.util.Scanner; // esti permite usar el scanner, herramienta que necesitamos para leer la entrada del usuario

public class EntradaStdin {
    public static void leerEntradaStdin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el radio de la circunferencia: ");
        double radio = sc.nextDouble();

        double area = Math.PI * radio * radio;
        double perimetro = 2 * Math.PI * radio;

        System.out.println("El area de la circunferencia es: " + area);
        System.out.println("El perimetro de la circunferencia es: " + perimetro);
    }

    public static void main(String[] args) {
        leerEntradaStdin();
    }
}

