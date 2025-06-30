package ejercicio123;
import Modelos.BinaryTree;
import Modelos.TreeNode;

public class Main {
    public static void main(String[] args) {
      BinaryTree arbol = new BinaryTree();
      arbol.insert(new TreeNode("+"));
      arbol.insert(new TreeNode("3"));
      arbol.insert(new TreeNode("4"));
      arbol.sustituirYEvaluar(arbol.root, 0);
      System.out.println(arbol.root.value);
    }
}
    /*
    Ejercicio #1
Desarrolla un algoritmo para, dado un árbol binario que representa expresiones aritméticas
(operadores, constantes y variables):
• Dados valores concretos de variables, sustituirlas en el árbol
• Evaluar la expresión representada en el árbol y emitir el resultado
NOTAS: se asume que las operaciones son binarias, y son suma, resta, multiplicación y
división
    
    Pre Existe un arbol, ArbolExpression con distintos valores
    
    Post El arbol va a tener las variables sustituidas y devuelve un resultado
    
Función sustituirYEvaluar(nodo, obtenerValorVariable)
  Comienzo
    Si nodo es nulo Entonces
      devolver 0
    Fin Si

    Si nodo es una constante Entonces
      devolver nodo.valor
    Fin Si

    Si nodo es una variable Entonces
      devolver obtenerValorVariable(nodo.valor)
    Fin Si

    valorIzquierdo  sustituirYEvaluar(nodo.hijoIzquierdo, obtenerValorVariable)
    valorDerecho  sustituirYEvaluar(nodo.hijoDerecho, obtenerValorVariable)

    Si nodo.valor es "+" Entonces
      devolver valorIzquierdo + valorDerecho
    Si nodo.valor es "-" Entonces
      devolver valorIzquierdo - valorDerecho
    Si nodo.valor es "*" Entonces
      devolver valorIzquierdo * valorDerecho
    Si nodo.valor es "/" Entonces
      devolver valorIzquierdo / valorDerecho
    Fin Si
  Fin

  Ejercicio 2 
  Ejercicio #2
1. Dada una expresión aritmética, representada mediante notación prefija, diseña un
algoritmo que cree el árbol binario de expresión correspondiente.
2. Considera las posibles situaciones de error
3. Escribe varias expresiones aritméticas (con paréntesis), exprésalas en notación prefija
y luego ejecuta manualmente el algoritmo diseñado para insertar la expresión en el
árbol. Por último, para cada árbol generado, ejecuta manualmente el algoritmo
diseñado en el Ejercicio 1. 

Pre Existe una expresion aritmetica en notacion prefija
Post Se crea un arbol binario de expresion correspondiente

Para este algoritmo primero se deberá de crear un árbol binario de expresión correspondiente a la expresión aritmética en notación prefija. Para ello, se deberá de recorrer la expresión 
aritmética en notación prefija de derecha a izquierda, y se deberá de ir creando el árbol binario de expresión correspondiente.
 
Función crearArbolExpresion(expresion)
  Comienzo
    Si expresion es nula o está vacía Entonces
      devolver nulo
    Fin Si

    caracter <- último caracter de la expresion
    expresion <- todos los caracteres de expresion menos el último

    Si caracter es un operador Entonces
      nodo <- nuevo Nodo
      nodo.valor <- caracter
      nodo.hijoDerecho <- crearArbolExpresion(expresion)
      nodo.hijoIzquierdo <- crearArbolExpresion(expresion)
      devolver nodo
    Si No
      nodo <- nuevo Nodo
      nodo.valor <- caracter
      devolver nodo
  Fin

  Test 1 
  Pre: expresion = "+ 3 4"
  Post: nodo.valor = "+", nodo.hijoIzquierdo.valor = "3", nodo.hijoDerecho.valor = "4"
Final quedaría algo así: 
    +
  /   \
  3    4






    
    jercicio #3
1. Diseña clases Java para representar un árbol binario y el nodo correspondiente, que
sea útil para representar el modelo de árbol de expresión aritmética.
2. Desarrolla en estas clases los métodos correspondientes a los algoritmos desarrollados
en los ejercicios 1 y 2.
3. Desarrolla un programa para probar estos métodos

    
    */
    
    
