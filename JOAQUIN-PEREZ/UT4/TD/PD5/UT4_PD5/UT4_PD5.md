Escenario para todos los ejercicios:
Estos ejercicios tratan del desarrollo de algoritmos en seudocódigo y análisis del tiempo de
ejecución correspondiente para el TDA ArbolBinarioBusqueda – TArbolBB- (y el
correspondiente TDA NodoArbolBinariobBusqueda – TElementoAB),
Ejercicio #1
Desarrolla un algoritmo (ambas partes, método de Árbol y método de Nodo), para Insertar un
nuevo Nodo en el Árbol (este nuevo nodo se ha de brindar como parámetro al método del
Arbol).
De acuerdo a los lineamientos para desarrollo de algoritmos en seudocódigo presentados en
clase, deberás desarrollar:
1. Descripción en lenguaje natural del algoritmo solicitado
2. Identificación de precondiciones y postcondiciones correspondientes
3. Escritura del algoritmo en seudocódigo formal
4. Análisis detallado del orden del tiempo de ejecución del algoritmo

 ##lenguaje natural :
     El algoritmo de insercción de un nuevo nodo en un arbol binario de busqueda consiste 
     en agregar un nuevo nodo al arbol de manera que se mantenga el orden de los nodos en el arbol.
    Para esto se compara el valor del nuevo nodo con el valor de la raiz del arbol, si el valor del nuevo nodo
    es menor que el valor de la raiz se compara con el nodo izquierdo de la raiz, si el valor del nuevo nodo es mayor
    que el valor de la raiz se compara con el nodo derecho de la raiz, se repite este proceso de forma recursiva hasta
    encontrar un nodo nulo en el cual se inserta el nuevo nodo.

    precondiciones: El avl no debe estar vacio 
    el nuevo nodo a insertar no es nulo

    postcondiciones: el arbol debe tener un nuevo nodo insertado correcatmente y debe ser un avl valido

    Algoritmo insertarNodo(nuevoNodo, raiz)
         Comenzar
            si raiz es nulo entonces
                raiz = nuevoNodo
            sino
                si nuevoNodo < raiz entonces
                    insertarNodo(nuevoNodo, raiz.izquierdo)
                sino
                    insertarNodo(nuevoNodo, raiz.derecho)
                fin si
            fin si
            Fin
    Analisis de tiempo de ejecucion:
    El tiempo de ejecucion de este algoritmo es O(log n) ya que en el peor de los casos se recorre la altura del arbol
