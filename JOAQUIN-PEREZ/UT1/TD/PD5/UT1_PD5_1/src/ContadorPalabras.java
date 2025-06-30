/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joaco
 */
/* Codigo realizado en equipo
public class ContadorPalabras {
    public int  ContadorPalabras(String frase)
    {
        frase= frase.toLowerCase();
        boolean isPalabra= false;
        int contadorPalabras=0;
        //char [] vocales= {'a','e','i','o','u'} ;
        int contadorVocales=0;
        int contadorConsonantes=0;
        char espacio= ' ';
        char caracter;
 
        for(int i =0; i<frase.length();i++)
        {
            caracter = frase.charAt(i);
            if(Character.isLetter(caracter)) {
                isPalabra= true;
                if(caracter=='a' || caracter=='e' || caracter=='i' || caracter=='o' || caracter=='u'){
                    contadorVocales++;
                }
                else
                {
                    contadorConsonantes++;
                }
            }
            if (caracter == espacio && isPalabra)
            {
                contadorPalabras++;
                isPalabra= false;
            }
        }
        if (isPalabra){
            contadorPalabras++;
        }
        return contadorPalabras;
        
    }
  
}*/
public class ContadorPalabras {

    // Enum que representa los tipos de caracteres que se pueden encontrar en la frase
    enum TipoCaracter {
        VOCAL, CONSONANTE, ESPACIO, OTRO
    }

    public int contarPalabras(String frase) {
        // Se convierte la frase a minúsculas
        frase = frase.toLowerCase();
        // Se inicializa el tipo de caracter actual como "espacio"
        TipoCaracter tipoActual = TipoCaracter.ESPACIO;
        // Se inicializan los contadores de palabras, vocales y consonantes
        int contadorPalabras = 0;
        int contadorVocales = 0;
        int contadorConsonantes = 0;

        // Se recorre cada carácter de la frase
        for (char caracter : frase.toCharArray()) {
            // Se obtiene el tipo de carácter del carácter actual
            TipoCaracter tipoNuevo = getTipoCaracter(caracter);
            // Si el tipo de carácter no es "otro"
            if (tipoNuevo != TipoCaracter.OTRO) {
                // Si el tipo de carácter es "espacio" y el tipo de carácter anterior no lo es
                if (tipoNuevo == TipoCaracter.ESPACIO && tipoActual != TipoCaracter.ESPACIO) {
                    // Se incrementa el contador de palabras
                    contadorPalabras++;
                }
                // Si el tipo de carácter es "vocal"
                if (tipoNuevo == TipoCaracter.VOCAL) {
                    // Se incrementa el contador de vocales
                    contadorVocales++;
                // Si el tipo de carácter es "consonante"
                } else if (tipoNuevo == TipoCaracter.CONSONANTE) {
                    // Se incrementa el contador de consonantes
                    contadorConsonantes++;
                }
            }
            // Se actualiza el tipo de carácter actual al nuevo tipo de carácter
            tipoActual = tipoNuevo;
        }
        // Si el último carácter no es un espacio, se incrementa el contador de palabras
        if (tipoActual != TipoCaracter.ESPACIO) {
            contadorPalabras++;
        }
        // Se imprime la información sobre la frase
        System.out.println("La frase \"" + frase + "\" tiene " + contadorPalabras + " palabras, "
                + contadorVocales + " vocales y " + contadorConsonantes + " consonantes.");
        // Se devuelve el contador de palabras
        return contadorPalabras;
    }

    // Método que devuelve el tipo de un carácter
    private TipoCaracter getTipoCaracter(char c) {
        switch (c) {
            // Si el carácter es una vocal, se devuelve "VOCAL"
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return TipoCaracter.VOCAL;
            // Si el carácter es un espacio, se devuelve "ESPACIO"
            case ' ':
                return TipoCaracter.ESPACIO;
            // Si el carácter es una consonante, se devuelve "CONSONANTE"
            default:
                // Se utiliza el método isLetter para determinar si el carácter es una letra
                return Character.isLetter(c) ? TipoCaracter.CONSONANTE : TipoCaracter.OTRO;
        }
    }
}
