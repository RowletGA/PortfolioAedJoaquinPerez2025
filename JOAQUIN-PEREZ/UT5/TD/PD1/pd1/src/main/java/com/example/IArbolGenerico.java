
package com.example;

public interface IArbolGenerico<T> {
    
    TElementoAG<T> getRaiz();
    
    public void setRaiz(TElementoAG<T> unElemento);
    
    public String preOrden();
    
    public String postOrden();
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public TElementoAG<T> buscar(Comparable unaEtiqueta);
    
    public String listarIndentado();
    
}