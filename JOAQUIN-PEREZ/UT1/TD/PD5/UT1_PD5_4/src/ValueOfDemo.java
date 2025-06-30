/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */

public class ValueOfDemo {
public static void main(String[] args) {
/*  1)Le estoy pasando los argumentos en propiedades, pero no los está tomando, podría realizar las operaciones a mano
    2)Para que de un entero es muy simplez solo hay que cambiar el tipo de valor, de un float a un integer.
        `   int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
    */


    if (args.length == 3) {
    // convert strings to numbers
        float a = Float.valueOf(args[0]).floatValue(); //El código tenia errores de sintaxis en estas lineas
        float b = Float.valueOf(args[1]).floatValue();
        // do some arithmetic
        System.out.println("a + b = " +
        (a + b));
        System.out.println("a - b = " +
        (a - b));
        System.out.println("a * b = " +
        (a * b));
        System.out.println("a / b = " +
        (a / b));
        System.out.println("a % b = " +
        (a % b));
    } else {
System.out.println("This program " +
"requires two command-line arguments.");
        }
    }
}
