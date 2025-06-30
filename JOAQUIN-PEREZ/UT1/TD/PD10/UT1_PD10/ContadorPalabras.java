
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
/*a) Se debe agregar un ,etodo a la clase q reciba dos conjuntos de palabras como entrada y que devuelva un nuevo conjunto que contenga solo las palabras que se repiten en a,nos conjuntos. 
El metodo va a comparar cada palabra del primer conjunto con todas las
 palabras del segundo conjunto y agregara aquellas que se encuentran
  en ambos */

class ContadorPalabras {
    public int contarPalabras(String frase) {
        int primerCaracterDePalabra = 0;
        int ultimoCaracterDePalabra = 1;
        int contador = 0;
        frase = frase.toLowerCase();

        for (int i = 0; i < frase.length(); i++) {
            char letter = frase.charAt(i);

            if (Character.isSpaceChar(letter) || i == frase.length() - 1) {
                ultimoCaracterDePalabra = i;

                for (int j = primerCaracterDePalabra; j < ultimoCaracterDePalabra; j++) {
                    if (Character.isLetter(j)) {
                        break;
                    }
                }
                primerCaracterDePalabra = ultimoCaracterDePalabra;
                contador++;
            }
        }
        return contador;
    }

    public boolean esVocal(Character letra) {
        letra = Character.toLowerCase(letra);
        Character vocales[] = { 'a', 'e', 'i', 'o', 'u' };

        return Arrays.asList(vocales).contains(letra);
    }

    public int[] contarVocalesYConsonantes(String frase) {
        int cantidadDeVocales = 0;
        int cantidadDeConsonantes = 0;

        for (int i = 0; i < frase.length(); i++) {
            Character letra = frase.charAt(i);

            if (Character.isLetter(letra)) {

                if (esVocal(letra)) {
                    cantidadDeVocales++;
                } else {
                    cantidadDeConsonantes++;
                }
            }
        }

        return new int[] { cantidadDeVocales, cantidadDeConsonantes };
    }

    public int cantPalabras(String[] lineasArchivo) {
        int contador = 0;
        for (String linea : lineasArchivo) {
            contador += contarPalabras(linea);
        }
        return contador;
    }

    public String[] procesarArchivo(String nombrearchivo) {
        String[] lineas = {};
        try (FileReader lector = new FileReader(nombrearchivo)) {
            BufferedReader entrada = new BufferedReader(lector);
            while (true) {
                String s = entrada.readLine();
                if (s == null)
                    break;
                lineas = Arrays.copyOf(lineas, lineas.length + 1);
            }
            entrada.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineas;
    }

    public int contadorDePalabrasLargas(String frase, int longitud) {
        int primerCaracterDePalabra = 0;
        int ultimoCaracterDePalabra = 1;
        int contador = 0;
        frase = frase.toLowerCase();

        for (int i = 0; i < frase.length(); i++) {
            char letter = frase.charAt(i);

            if (Character.isSpaceChar(letter) || i == frase.length() - 1) {
                ultimoCaracterDePalabra = i;

                boolean palabraLarga = ultimoCaracterDePalabra - primerCaracterDePalabra > longitud;
                if (palabraLarga || i == frase.length() - 1) {
                    contador++;
                }
                primerCaracterDePalabra = ultimoCaracterDePalabra;
            }
        }
        return contador;
    }

}

/*public class Main {
    public static void main(String args[]) {
        ContadorPalabras cont = new ContadorPalabras();

        cont.procesarArchivo("path/to/file.txt");
    }
}*/