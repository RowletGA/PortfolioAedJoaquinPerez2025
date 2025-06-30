public class Hash implements IHash{

    private int[] tablaHash;
    private int tamano;
    private int cantidadElementos = 0;

    public Hash(){
        this.tamano = 50;
        this.tablaHash = new int[this.tamano];
    }
    public Hash(int tamano){
        this.tamano = tamano;
        this.tablaHash = new int[this.tamano];
    }

    @Override
    public int insertar (int unaClave){
        int cont = 0;
        int pos = funcionHashing(unaClave);
        while (tablaHash[pos] != 0 && tablaHash[pos] != unaClave && cont < tamano){
            pos = (pos + 1) % tamano;
            cont++;
        }
        tablaHash[pos] = unaClave;
        cantidadElementos++;

        System.out.println(cantidadElementos);
        if (cantidadElementos / tamano >= 0.7){
            System.out.println("Rehashing");
            //this.reDimensionar();} //Rehashing no implementado
        }
        return cont;
    }
public int buscar(int unaClave){
        int cont = 0;
        int pos = funcionHashing(unaClave);
        while (tablaHash[pos] != unaClave && cont < tamano){
            pos = (pos + 1) % tamano;
            cont++;
        }
        return cont;
    }

    @Override
    public int funcionHashing (int unaClave){
        return unaClave % tamano;
    }

    private void reDimensionar(){ // esto lo tiró copilot porque no lo entedí y decidí no implementarlo
        int[] tablaHashAux = tablaHash;
        tamano = tamano * 2;
        tablaHash = new int[tamano];
        cantidadElementos = 0;
        for (int i = 0; i < tablaHashAux.length; i++){
            if (tablaHashAux[i] != 0){
                insertar(tablaHashAux[i]);
            }
        }
    }
}
