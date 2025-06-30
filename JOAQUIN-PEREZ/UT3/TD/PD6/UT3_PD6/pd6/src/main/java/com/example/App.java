package com.example;
import com.example.ManejadorArchivosGenerico;


public class App  {

        public static void main(String[] args) {
            System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir")); // verfico pq no lee el archivo
    
    
            // Leer sucursales de archivo
            String sucursales[] = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\joaco\\OneDrive\\Desktop\\PortfolioJoaquinPerezAED2024\\JOAQUIN-PEREZ\\UT3\\TD\\PD6\\UT3_PD6\\src\\main\\java\\com\\example\\suc3.txt");
            Empresa empresaPrueba = new Empresa();
          //  empresaPrueba.cantidadSucursales();
            //empresaPrueba.actualizarSucursales(sucursales);
           // empresaPrueba.imprimirSucursales();
            //System.out.println(empresaPrueba.cantidadSucursales());
           // empresaPrueba.eliminar("Chicago");
           // System.out.println(empresaPrueba.cantidadSucursales());
            
           //empresaPrueba.eliminar("Chicago");
    
    
            empresaPrueba.actualizarSucursales(sucursales);
            //empresaPrueba.imprimirSucursales();
            
           System.out.println(empresaPrueba.imprimirSeparador(";_"));
           //empresaPrueba.eliminar("Shenzen");
           //empresaPrueba.eliminar("Tokio");
    
            //empresaPrueba.actualizarSucursales(sucursales);
           // empresaPrueba.imprimirSucursales();
            
            
            ///Respuestas 1) 107
            /// 2) shenzhen 
            //3) queda vacia 
            // 4) ?Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver;_
        }
    }
/*UNIDAD TEMÁTICA 3: Listas, Pilas, Colas
PRACTICOS DOMICILIARIOS INDIVIDUALES #6
Ejercicio #1
La empresa “EstructurasYAlgoritmos”, dedicada a la producción de software y distribución de sus productos a nivel
internacional, desea mantener un registro de las ciudades en las cuales tiene oficinas de ventas.
Para ello, se desea cargar una estructura de datos con el contenido de un archivo “sucursales.txt”, que contendrá,
por cada línea, el nombre de la ciudad en que se encuentra la sucursal.
En todo momento, las funcionalidades que se espera satisfacer con este programa son:
• Agregar una sucursal
• Buscar una sucursal
• Quitar una sucursal
• Listar todas las sucursales
• Indicar la cantidad de sucursales
• Indicar si el directorio de sucursales está o no vacío
Implementa el TDA Lista Simplemente Enlazada, de acuerdo a las interfaces publicadas (con genéricos). Implementa
los métodos necesarios para realizar las funcionalidades requeridas del programa.
Prueba del programa:
Dado un nuevo archivo de entrada, al ejecutar el programa desarrollado se leerá el archivo de entrada y se
mostrarán en consola las ciudades cargadas y el total de elementos – ciudades – contenidas en la estructura.
1. Descargar el archivo “suc1.txt”, guardarlo en el directorio raíz de su implementación como “sucursales.txt” y
ejecutar el programa, emitiendo por consola la cantidad de elementos y la lista de ciudades contenida en la
estructura. La cantidad de elementos es:
a) 104
b) 105
c) 106
d) 107
2. Eliminar la ciudad “Chicago”- listar nuevamente el conjunto de sucursales. Dada la ciudad ·“Hong Kong”, la
que le sigue en la lista es la ciudad ….
a) Buenos Aires
b) Tokio
c) Shenzhen
d) Cleveland
3. Levantar un segundo archivo, “suc2.txt”. Eliminar las ciudades “Shenzen” y “Tokio”. Se cumple lo siguiente:
a) Quedan 5 ciudades
b) Queda 1 ciudad y da error de ejecución
c) Queda vacía y da error de ejecución
d) Ninguna de las anteriores
4. Levantar un tercer archivo, “suc3.txt”. Invocar al método “Imprimir(“;_”)”. El resultado de esta operación es:
Caracas;_Tulsa;_Mobile;_Vancouver;_ Montreal;_
Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver
Montreal;_ Tulsa;_ Caracas;_Mobile;_Vancouver;_
Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver;_ */