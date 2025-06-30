package pd7;

public class Ejercicio1 {
    /*
    
    Unión

Para obtener la unión de dos conjuntos ordenados A y B, creamos una nueva lista vacía llamada C.
Recorremos las listas A y B al mismo tiempo, comparando sus elementos actuales. 
Si un elemento es menor que el otro, lo agregamos a la lista C y avanzamos en la lista donde se encuentra ese elemento.
Si ambos elementos son iguales, agregamos solo uno de ellos a la lista C y avanzamos en ambas listas.
Continuamos el proceso hasta que hayamos recorrido todos los elementos de ambas listas A y B.
Al final, la lista C contendrá la unión de los conjuntos A y B.

PRECONDICIONES:
Existen dos listas A Y B
Las dos listas de entrada, A y B, están ordenadas y no contienen elementos duplicados.
Las listas pueden contener cualquier cantidad de elementos (incluso 0).
POSTCONDICIONES:

La lista resultante C contiene todos los elementos de A y B, sin duplicados y en orden.

funcion Union(A: Lista, B: Lista) -> Lista
Comienzo
    inicializar C como una lista vacía
    inicializar indiceA en 0
    inicializar indiceB en 0

    mientras indiceA < tamaño(A) o indiceB < tamaño(B) hacer
        si indiceA = tamaño(A) entonces
            agregar el elemento de B[indiceB] a C
            indiceB ß indiceB + 1
        sino si indiceB = tamaño(B) entonces
            agregar el elemento de A[indiceA] a C
            indiceA ß indiceA + 1
        sino
            comparar los elementos en A[indiceA] y B[indiceB]
            si A[indiceA] < B[indiceB] entonces
                agregar el elemento de A[indiceA] a C
                indiceA ß indiceA + 1
            sino si A[indiceA] > B[indiceB] entonces
                agregar el elemento de B[indiceB] a C
                indiceB ß indiceB + 1
            sino
                agregar el elemento de A[indiceA] a C
                indiceA ß indiceA + 1
                indiceB ß indiceB + 1
            fin si
        fin si
    fin mientras

    devolver C
Fin

    
    
    
    
Intersección:
    
Para obtener la intersección de dos conjuntos ordenados A y B, creamos una nueva lista vacía llamada C.
Recorremos las listas A y B al mismo tiempo, comparando sus elementos actuales.
Si un elemento es menor que el otro, avanzamos en la lista donde se encuentra ese elemento.
Si ambos elementos son iguales, lo agregamos a la lista C y avanzamos en ambas listas.
Continuamos el proceso hasta que hayamos recorrido todos los elementos de alguna de las listas A o B.
Al final, la lista C contendrá la intersección de los conjuntos A y B.

PRECONDICIONES:
Existen dos listas, A y B
Las dos listas de entrada, A y B, están ordenadas y no contienen elementos duplicados.
Las listas pueden contener cualquier cantidad de elementos (incluso 0).
POSTCONDICIONES:

La lista resultante C contiene los elementos comunes entre A y B, en orden.

funcion Interseccion(A: Lista, B: Lista) -> Lista
Comienzo
    inicializar C como una lista vacía
    inicializar indiceA en 0
    inicializar indiceB en 0

    mientras indiceA < tamaño(A) y indiceB < tamaño(B) hacer
        comparar los elementos en A[indiceA] y B[indiceB]
        si A[indiceA] < B[indiceB] entonces
            indiceA ß indiceA + 1
        sino si A[indiceA] > B[indiceB] entonces
            indiceB ß indiceB + 1
        sino
            agregar el elemento de A[indiceA] a C
            indiceA ß indiceA + 1
            indiceB ß indiceB + 1
        fin si
    fin mientras

    devolver C
Fin

    */
    

}
