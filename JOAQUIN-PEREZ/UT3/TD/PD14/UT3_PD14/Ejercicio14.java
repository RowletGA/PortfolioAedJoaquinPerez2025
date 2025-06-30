public class Ejercicio14 {
    /*        PonerEnCola(unElemento)
        Pre-condiciones:

        La cola es una estructura válida con atributos primero, proximo, arreglo y arregloAux.
        Post-condiciones:

        El elemento se agrega al final de la cola.
        La cola se actualiza correctamente.
        Si es necesario, la cola se redimensiona.
        
        
        COMIENZO
    SI NOT (proximo == primero) // La cola no está llena.
        arreglo[proximo] <- unElemento
        proximo <- (proximo + 1) % arreglo.largo
    SINO // Se redimensiona el arreglo y se inserta el nuevo valor.
        arregloAux <- new array[arreglo.largo] // Se crea un vector auxiliar con las dimensiones
        COPIAR arreglo A arregloAux // Copiar los valores del arreglo original al arregloAux
        arreglo <- new array[arreglo.largo * 2] // Redimensiono el vector multiplicando su largo por 2

        PARA i DESDE 0 HASTA arregloAux.largo - 1 HACER
            arreglo[i] <- arregloAux[i]
        FIN PARA

        arreglo[proximo] <- unElemento // Inserto el nuevo elemento en la nueva posición vacía.
        proximo <- (proximo + 1) % arreglo.largo // Muevo proximo a la próxima posición vacía.
    FIN SI
FIN

        
        
        
        QuitarDeCola()
      Pre-condiciones:

      La cola es una estructura válida con atributos primero, proximo y arreglo.
      Post-condiciones:

      El primer elemento de la cola es eliminado.
      La cola se actualiza correctamente.
      Se devuelve el elemento eliminado o nulo si la cola está vacía.      

        
        COMIENZO
    SI NOT (primero == proximo) // La cola no está vacía.
        resultado <- arreglo[primero]
        primero <- (primero + 1) % arreglo.largo
        DEVOLVER resultado
    SINO
        DEVOLVER nulo
    FIN SI
FIN

        */ 
    
}
