package pd7;

public class Lista<T> implements ILista<T>{
    private Nodo<T> primero;

    public Lista() {
        this.primero = null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (esVacia()) {
            primero = nodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(etiqueta, dato);
        insertar(nuevoNodo);
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getEtiqueta().compareTo(clave) == 0) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getEtiqueta().compareTo(clave) == 0) {
            primero = primero.getSiguiente();
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.getEtiqueta() + " ";
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    @Override
    public String imprimir(String separador) {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.getEtiqueta() + separador;
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    @Override
    public int cantElementos() {
        int cantidad = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            cantidad++;
            actual = actual.getSiguiente();
        }
        return cantidad;
    }
}
