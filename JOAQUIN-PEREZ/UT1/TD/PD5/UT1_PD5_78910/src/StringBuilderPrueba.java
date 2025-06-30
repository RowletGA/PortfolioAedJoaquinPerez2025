/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
//EJERCICIO 7 Y 8
public class StringBuilderPrueba {
    public static void main(String[] args) {
        // Crear un StringBuilder vacío
        StringBuilder sb1 = new StringBuilder();
        System.out.println(sb1); // ""

        // Crear un StringBuilder con una capacidad inicial de 10 caracteres
        StringBuilder sb2 = new StringBuilder(10);
        System.out.println(sb2); // ""

        // Crear un StringBuilder a partir de una cadena existente
        StringBuilder sb3 = new StringBuilder("Hola mundo");
        System.out.println(sb3); // "Hola mundo"

        // Establecer la longitud del StringBuilder
        sb3.setLength(4);
        System.out.println(sb3); // "Hola"

        // Asegurarse de que el StringBuilder tenga una capacidad mínima
        sb3.ensureCapacity(20);

        // Agregar una cadena al final del StringBuilder
        sb3.append(" amigos");
        System.out.println(sb3); // "Hola amigos"

        // Insertar una cadena en una posición específica
        sb3.insert(4, " mis");
        System.out.println(sb3); // "Hola mis amigos"

        // Eliminar caracteres de una posición específica hasta otra posición específica
        sb3.delete(5, 8);
        System.out.println(sb3); // "Hola amigos"

        // Eliminar un carácter en una posición específica
        sb3.deleteCharAt(4);
        System.out.println(sb3); // "Hoa amigos"

        // Invertir el orden de los caracteres del StringBuilder
        sb3.reverse();
        System.out.println(sb3); // "sogima aoH"
        
        String hannah = "Did Hannah see bees? Hannah did.";
        System.out.println(hannah.length());
            
    }
}
/*EJERCICIO 8
Creates an empty string builder with a capacity of 16 (16 empty elements).
StringBuilder sb = new StringBuilder("Able was I ere I saw
Elba.");
El comportamiento predeterminado de la clase StringBuilder es asignar una capacidad 
inicial de 16 caracteres si no se especifica explícitamente.Como en este caso se proporciona una cadena inicial, 
la capacidad inicial se establecerá en la longitud de la cadena inicial más 16 caracteres adicionales.
La Capacidad inicial sería 25 + 16 o 26+16 en el caso de que Elba siga en la misma linea, ya que no estoy considerando el 
espacio al cambiar de linea.
En este caso el total es de 41

EJERCICIO 9 
Considere la siguiente string:
String hannah = "Did Hannah see bees? Hannah did.";
a) ¿qué valor muestra la expresión “hannah.length”?
b) ¿qué valor es retornado por la invocación del método “hannah.charAt(12)”?
c) Escribe una expresión que referencie la letra “b” en la string referida por “hannah".

a) La expresión "hannah.length()" devuelve 32.

b) La invocación del método "hannah.charAt(12)" devuelve el carácter en la posición 12 de la cadena "hannah", contando desde cero.
En este caso, el carácter en la posición 12 es la letra "e".

c) Para referenciar la letra "b" en la cadena "hannah", podemos usar la siguiente expresión:
"hannah.charAt(15)"

Esto se debe a que la letra "b" aparece en la posición 16 de la cadena "hannah", contando desde cero

10) ¿Cuán larga es las string devuelta por la siguiente expresión? ¿cuál es la string?
"Was it a car or a cat I saw?".substring(9, 12)
devolvería car, especificamente "car" , la ultima posición no se cuenta debido al metodo.
*/
