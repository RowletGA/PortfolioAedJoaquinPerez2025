package com.example;
public interface IEmpresa {
    
    public String getNombre();
    
    public String getTelefono();
    public void setTelefono (String telefono);
    
    public String getDireccion();    
    public void setDireccion(String Direccion);
    
    public Lista getListaSucursales();

    public void insertarSucursal(Sucursal unaSucursal);

    public boolean eliminar(Comparable clave);

    public void imprimirSucursales();

    public String imprimirSeparador(String separador);

    public Sucursal buscarPorCodigo(Comparable clave);

    public int cantidadSucursales();
}
