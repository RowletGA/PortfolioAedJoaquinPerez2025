package pd9;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Expresion expresion = new Expresion(); 
        char [] lista1 = new char[] {'{', '}', 'a', '{', '7', '}'};
        char [] lista2 = new char[] {'{', '}', 'a', '{'};
        char [] lista3 = new char[] {};
        char [] lista4 = new char[] {'{', '}', '{', '{', '{', '}'};
        char [] lista5 = new char[] {'{', '}', '{', '{', '{', '}'};
        char [] lista6 = new char[] {'{', '}', '{', '{', '{', '}'};
        char [] lista7 = new char[] {'{', '}', '{', '{', '{', '}'};
        char [] lista8 = new char[] {'{', '}', '{', '{', '{', '}'};

        System.out.println(expresion.controlCorchetes(lista1));
        System.out.println(expresion.controlCorchetes(lista2));
        System.out.println(expresion.controlCorchetes(lista3));
        System.out.println(expresion.controlCorchetes(lista4));
        System.out.println(expresion.controlCorchetes(lista5));
        System.out.println(expresion.controlCorchetes(lista6));
        System.out.println(expresion.controlCorchetes(lista7));
        System.out.println(expresion.controlCorchetes(lista8));
        
    }
}