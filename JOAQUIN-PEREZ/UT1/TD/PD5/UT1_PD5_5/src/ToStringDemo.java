/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
public class ToStringDemo {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
        
        int dot = s.indexOf('.');
        System.out.println(dot + " digits " +
        "before decimal point.");
        
        System.out.println( (s.length() - dot - 1) +
        " digits after decimal point.");
}
}
/*
1)La salida de este programa tendría que comentar cuantos digitos hay antes y despues del punto
siendo : 3 digits before decimal point. \n 2 digits after decimal point.

2)Se crea una variable d, double y se le asigna un valor
  Luego convierte el Objeto en una string y apunta a s en la memoria
  Usa el metodo IndexOf para encontrar el punto, se almacena en dot
  Se imprimen dos lineas, la primera antes del punto y la segunda despues del mismo
*/
