## Letra 

En una red de distribución de paquetes dentro de un país, las ciudades están
conectadas por rutas de entrega directas. Cada ruta tiene un costo asociado,
representando el gasto logístico entre dos ciudades. Sin embargo, debido a res-
tricciones de presupuesto, se desea minimizar el costo total para conectar todas
las ciudades de forma que cualquier paquete pueda ser entregado entre cualquier
par de ciudades (directa o indirectamente).
Además, algunas rutas presentan prioridad de uso debido a acuerdos logís-
ticos preexistentes.
Objetivo
Diseñar un algoritmo que determine el conjunto de rutas de menor costo
total que conecta todas las ciudades, priorizando siempre las rutas con acuerdos
preexistentes cuando sea posible.
Se solicita:
1. Diseñar las estructuras adecuadas para representar las ciudades, rutas y
redes de distribución.
2. Describir en lenguaje natural el algoritmo que resuelve el problema.
3. Indicar precondiciones y postcondiciones.
4. Especificar el pseudocódigo.
5. Analizar el orden del tiempo de ejecución.
Como apoyo adicional, se dispone de dos funciones en la estructura T Caminos:
1. conectados(v1, v2) devuelve verdadero si los vértices v1 y v2 están en el
mismo componente.

1

Notas relevantes : Prioridad de uso , costo minimo , cola de prioridad, menor costo y ruta con prioridad (heapsort) o clave compuesta (es prioritario o costo) 
otra idea, si primro le pasas la lista de rutas prioritarias ordenadas por costo, y desp el resto, primero arma el arbol arbarcador por las prioritarias
1. El algoritmo adecuado es kruskal debido a las colas de prioridad


