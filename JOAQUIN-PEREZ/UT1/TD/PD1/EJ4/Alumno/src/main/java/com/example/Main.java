package com.example;

public class Alumno {
    private String nombre;

    public Alumno() {
        nombre = null;
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }

    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
    }

    public static int recorrer(String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) { // no estaba recorriendo toda la cadena ya que el for estaba mal arrancando en 1 y no en 0
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    public static int getValor() {
        int vector[] = {6, 16, 26, 36, 46, 56, 66, 76};
        int idx = 7; // no accedia al ultimo arreglo antes estaba el 8 y solo hay 7 elementos
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        return palabra.charAt(0); // no se estaba retornando el primer caracter ya que arrancaba en el segundo caracter
    }

    public static String paraAString(int a) {
        return Integer.toString(a); // no se estaba retornando el valor de a en string ya que queria convertir un int a string
    }
}

    /* las correcciones se hicieron en el codigo algunos estan comentados
    a) Indicar el error al ejecutar la clase Alumno y corregirlo. ¿cómo lo detectaste? Principalmente ees un error de  sintaxis, ya que el método main no está dentro de la clase Alumno, por lo que se debe mover dentro de la clase Alumno. dejando recorrer afuera de la misma
b) Indicar el error al ejecutar el método “recorrer” y corregirlo. ¿cómo lo detectaste?
c) Indicar el error al ejecutar el método “getValor” y corregirlo. ¿cómo lo detectaste?
d) Indicar el error al ejecutar el método “getPrimerCaracter” y corregirlo. ¿cómo lo detectaste?
e) Indicar el error al ejecutar el método “paraAString” y corregirlo. ¿cómo lo detectaste? */