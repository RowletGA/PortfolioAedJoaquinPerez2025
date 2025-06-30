    5.4:
		a) Verdadera por suma.
		b) Verdadera por suma.
		c) Verdadera por multiplicacion.
		d) Falsa.

	5.5:
		Por regla de la suma, corresponderia O(N) + O(N) = O(N), el orden es O(N)

	5.6:
		x^2 = O(x^2) 
		x = O(x)
		x^3 + x = O(x^3)
		x^2 - x = O(x^2)
		(x^4 / (x - 1)) = O(x^3)

	5.10:
		Cada algoritmo aumentará en 10
		O(N): El tiempo de ejecución será aumentado por un factor de 10.
		O(N^2): El tiempo de ejecución será aumentado por un factor de 100.
		O(N^3): El tiempo de ejecución será aumentado por un factor de 1000.
		O(NlogN): El tiempo de ejecución será aumentado por un factor de 33 (10log10) = 33

	
	5.12:
		a) T(n) = 2ms
		b) T(nlogn) = 2.70ms
		c) T(n^2) = 10ms
		d) T(n^3) = 50ms

	5.13:
		a) O(n)
		b) O(n^2)


	5.15: 
		En la maquina A, para 1000 elementos tarda 10s.
		La maquina B es 3 veces mas rapida. Por lo cual para 1000 elementos tarda 3.33s	
		Para 2500 elementos la maquina B:

		a) T(n) = 3,33 * 2,5 = 8,33s - Incrementa por un factor de 2,5
		b) T(n^2) = 3,33 * (2,5)^2 = 20,81s - Incrementa por un factor de (2,5)^2
		c) T(n^3) = 3,33 * (2,5)^3 = 52,03s - Incrementa por un factor de (2,5)^3
		d) T(nlogn) = 3,33 * 2,5log2,5 = 11,01s - Incrementa por un factor de 2,5log2,5

	5.16:
		0,5ms para 100 elementos
		Para llegar a un minuto utilizo el factor 120.000.
		60.000ms para 12.000.000 elementos


		a) T(n) = 60.0000ms => N = 12.000.000
		b) T(n^2) = 60.000ms = 0.5ms * N^2 => N = sqrt(60.000/0.5) * 100 = 34.641
		c) T(n^3) = 60.000ms => 0.5ms * N^3 => N = 3sqer(60.000/0.5) * 100 = 4.932
		d) T(nlogn) = 60.000ms => 0.5ms * NlogN => N = antilog(60.000/0.5) * 100 = ?
        
   