/*Muchos cálculos pueden ser expresados de manera concisa usando la operación “multsuma”,
que toma tres operandos y computa a*b + c. Algunos procesadores incluso proveen una
implementación de hardware para esta operación para números de punto flotante.
Crear un nuevo programa llamado Multsuma.java. Escribir un método llamado multsuma que
toma tres doubles como parámetros y que imprime el resultado de multisumarlo.
Escribir un método main que testee multsuma invocándolo con unos pocos parámetros
simples, como por ejemplo 1.0, 2.0, 3.0, y después imprima por consola el resultado, que en
ese caso debería ser 5.0. */

public class Multsuma {
    public static void main(String[] args) {
        double a = 1.0;
        double b = 2.0;
        double c = 3.0;
        System.out.println(multsuma(a, b, c));
    }

    public static double multsuma(double a, double b, double c) {
        return a * b + c;
    }
}
// imprime 5.0 ya q al ser doubles nos da el .0