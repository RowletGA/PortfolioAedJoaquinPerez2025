/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
public class ContenedorDeNumeros {
    
    public int anInt;
    public float aFloat;
    
    public static void main(String[] args) {
        ContenedorDeNumeros contenedor = new ContenedorDeNumeros();
        contenedor.anInt = 17;
        contenedor.aFloat = 234.896f; 
        System.out.println("Valor de los contenedores:\n" + contenedor.anInt + "\n" + contenedor.aFloat );
        String[] students = new String[10];
        String studentName = "Peter Parker";
        students[0] = studentName;
        studentName = null;
        /* Después de correr el código quedan dos referencias a objetos, por un
        lado el array students y el nombre Peter Parker, esto es porque previo a 
        darle null a studentsName ocurre la sentencia que iguala la posición 0 de 
        studens a studentsName, por lo cual van a apuntar a la misma dirección de 
        memeoria.
        
        Por otro lado al pasarle null a studensName, esta referencia a la memoria 
        se elimina, y pasa a ser candidato al garbage collector de java ya que este 
        actua cuando los objetos no tienen ninguna referencia.
        
        
        */

    }
    
}
