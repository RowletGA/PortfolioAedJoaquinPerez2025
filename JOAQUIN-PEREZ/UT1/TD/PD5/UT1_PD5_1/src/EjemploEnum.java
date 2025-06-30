/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
public class EjemploEnum {
    
    // Declaración de un enum
    enum DiasDeLaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
    }
    
    public static void main(String[] args) {
        
        // Uso del enum
        DiasDeLaSemana hoy = DiasDeLaSemana.VIERNES;
        
        // Imprime el valor del enum
        System.out.println("Hoy es " + hoy);
        
        // Comparación de enums
        if (hoy == DiasDeLaSemana.VIERNES) {
            System.out.println("Es Viernes! \n pero tengo muchas ut1_pd mas :C ");
        }
        
        // Ciclo a través de todos los valores del enum
        for (DiasDeLaSemana dia : DiasDeLaSemana.values()) {
            System.out.println(dia);
        }
        
        String frase = "Son muchos td, un cafe y a seguir";
        ContadorPalabras contador = new ContadorPalabras();
        int numPalabras = contador.contarPalabras(frase);
        
        

        
    }
}


