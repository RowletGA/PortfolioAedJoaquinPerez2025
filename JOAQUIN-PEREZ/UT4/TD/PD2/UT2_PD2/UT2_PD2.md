EJERCICIO #1

1. 
	Entrada: Un numero entero.
	Salida: El factorial de dicho numero.

	factorial(numero)
	COMIENZO
		SI (numero == 0)
			DEVOVLER 1 // Caso base
		SINO
			DEVOLVER (numero * factorial(n-1)) // Caso recursivo
		FIN SI
	FIN

	En el caso de que se ingrese un numero negativo, nunca progresaria hacia el caso base.
	Siempre incrementaria de forma negativa y no llegaria a 0.

2.
	factorial(int numero)
	COMIENZO
		SI (numero == 0)
			DEVOVLER 1 // O(1)
		SINO
			DEVOLVER (numero * factorial(n-1)) // O(n-1)
		FIN SI
	FIN

	O(1) + O(n-1) = El orden es O(n)

3.
Si el dato es negativo nunca llega asu caso base
	factorial(4) = 24
	factorial(5) = 120
	factorial(0) = 1
    
    
    
EJERCICIO #2

    1. 
            Entrada: Un array de enteros A y un entero n >= 1; tal que A tiene al menos n elementos.
            Salida: La suma de los primero n enteros en A.

            sumaLineal(A, n)
            COMIENZO
                    SI n = 1
                            DEVOLVER A[0] // Caso base.
                    SINO
                            DEVOLVER sumaLineal(A, n-1) + A[n-1] 
                    FIN SI
            FIN

            Si n es negativo, si n es mayor al largo de A o si A es vacio, nunca progresara hacia el caso base
            ya que dichas posiciones se encuentran fuea de los indices.

    2. 
            sumaLineal(A, n)
            COMIENZO
                    SI n = 1
                            DEVOLVER A[0] // O(1)
                    SINO
                            DEVOLVER sumaLineal(A, n-1) + A[n-1] // O(n)
                    FIN SI
            FIN

            O(1) + O(n) = El orden es O(n)

    3.

            Si el parametro n es negativo o si el vector A esta vacio el programa no se ejecutara ya que
            el programa intentara buscar una posicion que no se encuentra dentro de los indices validos.


    EJERCICIO #3

	1.
		Entrada: Un entero x que es el numero base que vamos a multiplicar y un exponente n que es el 
			numero de veces que se multiplica.
		Salida: La potencia de el numero x exponente n.

		potencia(x, n)
		COMIENZO
			SI n = 0
				DEVOLVER 1 // Caso base.
			SINO 
				DEVOLVER x * potencia(x, n-1)
			FIN SI
		FIN

		Si el exponente n es negativo no se llegara al caso base.


	2.
		potencia(x, n)
		COMIENZO
			SI n = 0
				DEVOLVER 1 // O(1)
			SINO 
				DEVOLVER x * potencia(x, n-1) // O(n)
			FIN SI
		FIN

		O(1) + O(n) = El orden es O(n)

	3.
		En el caso de que se establezca previamente que los parametros son valores enteros, no se podria ingresar
		numeros reales.
		De lo contrario, si se pudiesen ingresar valores reales. Funcionaria siempre y cuando el exponente no fuera
		un valor negativo ni un numero decimal o flotante.

EJERCICIO #4

	1.
		Entrada: Un array A de enteros e indices enteros no negativos i y j.
		Salida: Los elementos de A entre los indices i y j, invertidos.

		invertirArray(A, i, j)
		COMIENZO
			SI i < j ENTONCES // Caso base.
				intercambiar A[i] y A[j]
				invertirArray(A, i+1, j-1)
			FIN SI
		FIN

	2.
		En el peor de los casos se toman ambos extremos y seria O(n/2). Por lo cual el algoritmo es de O(n)

	3.
		En la mayoria de casos el programa tira un error (ArrayIndexOutOfBoundsException) implicando que se
		esta intentando acceder a un elemento el cual su indice no existe.

