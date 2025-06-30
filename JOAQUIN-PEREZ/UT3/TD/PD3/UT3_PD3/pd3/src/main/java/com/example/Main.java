package com.example;

public class Main {
    public static void main(String[] args) {
        //casos de prueba, se crean los nodos
        Nodo nodo1 = new Nodo(1,"Nodo1");
        Nodo nodo2 = new Nodo(2,"Nodo2");
        Nodo nodo3 = new Nodo(3,"Nodo3");
        
        Lista lista = new Lista(); // lista de pruebas
        
        lista.insertar(nodo1); // probamos metodo insertar
        lista.insertar(nodo2);
        lista.insertar(nodo3);
        
        System.out.println(lista.buscar(1));
        System.out.println(lista.imprimir());
        System.out.println(lista.imprimir(","));
        System.out.println(lista.eliminar(1));
    }
}
/*
• Crear los elementos y la lista
• Insertar un elemento en una lista (al final, la lista no está ordenada)
• Buscar un elemento en una lista
• Listar (imprimir) todos los elementos de una lista
• Eliminar un elemento de una lista, dada su clave.
    
Crear  los elementos de la lista: 
    
Lenguaje natural: Crear una lista vacía y nodos para almacenar los elementos.
    
Precondiciones: N/A
    
Postcondiciones: La lista está vacía y se pueden crear nodos con etiquetas y datos.
    
Pseudocódigo:
    
    Iniciar Lista;
    Iniciar Nodo;
    
Insertar un elemento en una lista (al final, la lista no está ordenada):

Lenguaje natural: 
    
   Añadir un nuevo nodo al final de la lista. Si la lista está vacía, el nuevo nodo se convierte en el primer elemento de la lista. --> caso de lista vacia
   Si la lista ya contiene elementos, el nuevo nodo se agrega después del último nodo de la lista. --> caso lista con un elemnto o más
    
Precondiciones: Verificar que existe la lista
    
Postcondiciones: La lista contiene el nuevo nodo al final de la lista, podemos comprobar si tiene un lemento máß.
    
Pseudocódigo:
    
 insertar(nodo)
  si lista está vacía
    primero = nodo
  sino
    último = obtener último nodo
    último.siguiente = nodo
  fin si
fin 
    
Buscar un elemento en una lista:

Lenguaje natural: 
    Dada una clave, buscar un nodo en la lista que tenga esa clave.
    Recorrer la lista desde el primer nodo hasta el último, comparando la clave de cada nodo con la clave dada.
    Si se encuentra un nodo con la clave, devolver ese nodo. Si no se encuentra ningún nodo con la clave, devolver null.
Precondiciones: La lista ha sido creada y tiene al menos un elemento
    
Postcondiciones: Retorna el nodo si se encuentra en la lista, de lo contrario, retorna nulo.
    
Pseudocódigo:
    
 buscar(clave)
  actual = primero
  mientras actual != null
    si actual.clave == clave
      retornar actual
    fin si
    actual = actual.siguiente
  fin mientras
  retornar null
fin 
    
• Listar (imprimir) todos los elementos de una lista
    
Lenguaje natural: 
    
    Realizar un indice donde compare si es distinto a null y recorra cada elemento devolviendo la clave hasta llegar
    al final de la lista.
Precondiciones: La lista ha sido creada y tiene algun elemento, si no no retorna nada.
    
Postcondiciones: Las claves de todos los nodos de la lista se han impreso.
    
Pseudocódigo:
    
imprimir()
  actual = primero
  mientras actual != null
    imprimir actual.clave
    actual = actual.siguiente
  fin mientras
fin 

    
Eliminar un elemento de una lista, dada su clave:
    
Lenguaje natural:
    
Dada una clave, eliminar el nodo que tenga esa clave de la lista.
Recorrer la lista desde el primer nodo hasta el último, buscando un nodo con la clave dada.
Si se encuentra un nodo con la clave, eliminarlo de la lista y devolver true. Si no se encuentra ningún nodo con la clave, devolver false.
    
Precondiciones: La lista ha sido creada.
    
Postcondiciones: Si se encuentra el nodo con la clave, se elimina de la lista y se retorna true, de lo contrario, se retorna false.
    
Pseudocódigo:
    
eliminar(clave)
  si lista está vacía
    retornar false
  si primero.clave == clave
    primero = primero.siguiente
    retornar true
  fin si
  actual = primero
  mientras actual.siguiente != null
    si actual.siguiente.clave == clave
      actual.siguiente = actual.siguiente.siguiente
      retornar true
    fin si
    actual = actual.siguiente
  fin mientras
  retornar false
fin
     */


