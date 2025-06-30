/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joaco
 */
public class Marcapasos {
    //algunos valores consideré que era mejor mantener en publico u privado dependiendo de su uso e información
    public short presionSanguinea; // es más ecónomico que utilizar un entero, considere eel uso de byte pero el límite del mismo no es adecuado
    public short frecuenciaCardiaca; // 
    public short nivelAzucar;
    private long maximaFuerza; // más economico q Long
    private float minTiempoLatidos;
    public float bateriaRestante;
    private char codigoFabricante; // cada caracter ocuparía dos bytes, si fuera una string puede variar dependiendo de el input

    public Marcapasos(short presionSanguinea, short frecuenciaCardiaca, short nivelAzucar, long maximaFuerza, 
                      float minTiempoLatidos, float bateriaRestante, char codigoFabricante) {
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelAzucar = nivelAzucar;
        this.maximaFuerza = maximaFuerza;
        this.minTiempoLatidos = minTiempoLatidos;
        this.bateriaRestante = bateriaRestante;
        this.codigoFabricante = codigoFabricante;
    }

    // Getters y setters para cada variable
    public short getPresionSanguinea() {
        return presionSanguinea;
    }

    public void setPresionSanguinea(byte presionSanguinea) {
        this.presionSanguinea = presionSanguinea;
    }

    public short getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(byte frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public short getNivelAzucar() {
        return nivelAzucar;
    }

    public void setNivelAzucar(byte nivelAzucar) {
        this.nivelAzucar = nivelAzucar;
    }

    public long getMaximaFuerza() {
        return maximaFuerza;
    }

    public void setMaximaFuerza(long maximaFuerza) {
        this.maximaFuerza = maximaFuerza;
    }

    public float getMinTiempoLatidos() {
        return minTiempoLatidos;
    }

    public void setMinTiempoLatidos(float minTiempoLatidos) {
        this.minTiempoLatidos = minTiempoLatidos;
    }

    public float getBateriaRestante() {
        return bateriaRestante;
    }

    public void setBateriaRestante(float bateriaRestante) {
        this.bateriaRestante = bateriaRestante;
    }

    public char getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(char codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }
    /* Parte b) 
    Si bien se podría utilizar un metodo para ver cuanta memoria consume no seria lo optimo, sabiendo que
    necesitamos tener el menor costo/beneficio y administración de la memoria.
    El valor en bytes, sería el siguiente 2 + 2 + 2 + 8 + 4 + 4 + 16) = 38bytes
    2 = short
    8 = long
    4 = float
    char = cada carcter 2byte, al ser 8 caracteres = 16
    */
}