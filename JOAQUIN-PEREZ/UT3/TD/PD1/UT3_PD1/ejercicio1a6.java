public class Ejercicio1a6 {
/*
Son tres nodos, nodo1, nodo 2 y nodo3, nodo2 es el siguiente a nodo1 y nodo3 es el siguiente a nodo2.
El código crea en una instancia un nuevo nodo, llamemosle nodo4 luego hace nodo4.siguiente lo cual lo inserta al inicio de la lista y apunta como siguiente nodo al nodo1, de momento tenemos 
nodo4>nodo1>nodo2>nodo3 luego hace nodo2.siguiente nodo3 lo cual entiendo que la deja igual solo saca la referencia al nodo3 y la vuelve a linkear  dando como respuesta la opción A */
}
/*Sean nodo1, nodo2 y nodo3 tres nodos consecutivos de una lista (nodo2 es el siguiente a
nodo1 y nodo3 es el siguiente a nodo2).
Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
que sucede):
Nuevo nodo otroNodo
otroNodo.siguiente  nodo1
nodo2.siguiente  nodo3
 */
/*Ejercicio #2
Sean nodo1, nodo2 y nodo3 tres nodos consecutivos de una lista (nodo2 es el siguiente a
nodo1 y nodo3 es el siguiente a nodo2).
Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
que sucede):
Nuevo nodo otroNodo
otroNodo  nodo1.siguiente
nodo1.siguiente  nodo3 */
/* inicialmente nodo1. nodo2> nodo3> 
 * crea  un nuevo nodo 
 * a ese nodo otroNodo le asigna el siguiente de nodo1
 * nodo1 > otro nodo 
 * nodo1>nodo3 borra las demás asignaciones (nodo dos queda sin referencia)
 * otronodo>nodo1>nodo3

*/
/*Ejercicio #3*
Ejercicio #3
Sean nodo1, nodo2 y nodo3 tres nodos consecutivos de una lista (nodo2 es el siguiente a
nodo1 y nodo3 es el siguiente a nodo2).
Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
que sucede) y responda las preguntas proyectadas en pantalla:
Nuevo nodo otroNodo
otroNodo.siguiente  nodo1.siguiente
nodo1.siguiente  otroNodo
a) Inserta “otroNodo” en la lista, quedando como anterior a nodo1.
b) Inserta “otroNodo” en la lista, quedando entre nodo1 y nodo2.
c) Elimina nodo2 de la lista.
d) Dará error en tiempo de ejecución si nodo1 es el primero o nodo3 es el último*//* 
La respuesta es b, asigna el siguiente del nuevonodo el nodo 2 y luego el 1 al nuevo nodo, el diagrama seria
 nodo1--> otroNodo--> nodo2-->nodo3*/

 /*Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
que sucede) y responda las preguntas proyectadas en pantalla:
Nuevo nodo otroNodo
Nuevo nodo nodoActual
nodoActual  primero
mientras nodoActual <> nulo hacer
 nodoActual  nodoActual.siguiente
fin mientras
nodoActual.siguiente  otroNodo
a) Inserta correctamente “otroNodo” en la lista, quedando como último nodo.
b) Inserta correctamente “otroNodo” en la lista, quedando como primer nodo.
c) El algoritmo está mal hecho, ya que dará error en tiempo de ejecución si la lista está
vacía.
d) El algoritmo está mal hecho, ya que dará siempre error en tiempo de ejecución. 
La respuesta es la a ya que al salir del bulque inserta el otro nodo luego del nodo actual*/
/*Analice el siguiente fragmento de código (utilice dibujos o diagramas para clarificar qué es lo
que sucede) y responda las preguntas proyectadas en pantalla:
Nuevo nodo otroNodo
Nuevo nodo nodoActual
nodoActual  primero
mientras nodoActual.siguiente <> nulo hacer
 nodoActual  nodoActual.siguiente
fin mientras
nodoActual.siguiente  otroNodo
a) Inserta correctamente “otroNodo” en la lista, quedando como último nodo.
b) Inserta correctamente “otroNodo” en la lista, quedando como primer nodo.
c) El algoritmo está mal hecho, ya que dará error en tiempo de ejecución si la lista está
vacía.
d) El algoritmo está mal hecho, ya que dará siempre error en tiempo de ejecución.
C */