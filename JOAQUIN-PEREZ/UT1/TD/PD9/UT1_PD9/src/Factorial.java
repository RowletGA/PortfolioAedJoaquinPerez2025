public class Factorial{
    
    public static int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("El número debe ser positivo.");
        }
        int resultado = 1;
        for (int i = 2; i <= num; i++) { // se itera desde dos, hasta el numero, para no gastar recursos de más omitiendo el caso *1, por otro lado hay 
            resultado *= i;// que considerar el uso de long o de un BigInt si el entero es muy grande.
        }
        return resultado;
    }

    public static void main(String[] args) {
        int num = 0; // tmbn se puede utilizar el scanner como input
        int resultado = factorial(num);
        System.out.println("El factorial de " + num + " es " + resultado);
    }
}
