/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
public class MetodosString {
    public static void main(String[] args) {
        String s = "Hola Mundo!";
        
        // substring
        System.out.println("Substring desde el índice 2 hasta el final: " + s.substring(2));
        System.out.println("Substring desde el índice 2 hasta el 6: " + s.substring(2, 6));
        
        // split
        String[] parts = s.split(" ");
        System.out.println("Primera parte después de separar por espacio: " + parts[0]);
        System.out.println("Segunda parte después de separar por espacio: " + parts[1]);
        
        // subSequence
        CharSequence cs = s.subSequence(2, 6);
        System.out.println("Subsecuencia desde el índice 2 hasta el 6: " + cs);
        
        // trim
        String s2 = "    Hola Mundo!    ";
        System.out.println("Cadena original con espacios en blanco: " + s2);
        System.out.println("Cadena con espacios en blanco eliminados: " + s2.trim());
        
        // toLowerCase
        System.out.println("Cadena en minúsculas: " + s.toLowerCase());
        
        // toUpperCase
        System.out.println("Cadena en mayúsculas: " + s.toUpperCase());
        
        // indexOf
        System.out.println("Índice de la letra 'M': " + s.indexOf('M'));
        System.out.println("Índice de la primera ocurrencia de la letra 'o': " + s.indexOf('o'));
        System.out.println("Índice de la última ocurrencia de la letra 'o': " + s.lastIndexOf('o'));
        
        // contains
        System.out.println("¿La cadena contiene la palabra 'Mundo'? " + s.contains("Mundo"));
        
        // replace
        System.out.println("Reemplazar la letra 'o' por 'e': " + s.replace('o', 'e'));
        System.out.println("Reemplazar la palabra 'Mundo' por 'Universo': " + s.replace("Mundo", "Universo"));
        
        // replaceAll
        System.out.println("Reemplazar todas las letras 'o' por 'e': " + s.replaceAll("o", "e"));
        
        // replaceFirst
        System.out.println("Reemplazar la primera letra 'o' por 'e': " + s.replaceFirst("o", "e"));
    }
}