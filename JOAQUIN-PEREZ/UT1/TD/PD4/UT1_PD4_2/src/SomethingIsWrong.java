/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
1) Indica qué es lo que está mal en el siguiente programa: */
public class SomethingIsWrong {
public static void main(String[] args) {
Rectangle  myRect = new Rectangle();
myRect.width = 40;
myRect.height = 50;
System.out.println("myRect's area is " + myRect.area());
}
static class Rectangle { // es estatica pq no es un valor que vaya a cambiar a futuro
    public int width;
    public int height;
    public int area(){
        return width*height;
    }
}
}
/* 2) Repara el error, ejecuta el programa y verifica que la salida es correcta
1) La variable no está inicializada, incluso luego se intenta usar la misma pero no es 
posible ya que falta inicializar myRect.
2) Aún corrigiendo este error, nos da un error de compilación ya que la clase Rectangle no existe,
para voy a crear una clase rectangle, usando width y heigth como lo vemos en el codigo viejo.
Código ya funcionando



*/
    

