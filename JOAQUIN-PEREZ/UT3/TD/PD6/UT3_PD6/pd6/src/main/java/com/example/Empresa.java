package com.example;
public class Empresa implements IEmpresa {
    
    private String nombre;
    private String direccion;
    private String telefono;
    
    private Lista listaSucursales = new Lista();
    @Override
    public String getNombre() {
        return this.nombre;
    }
        
      @Override
    public String getDireccion() {
        return this.direccion;
    }
    
    @Override 
    public void setDireccion(String direccion) {
        this.direccion = direccion;
        
    }
    @Override
    public String getTelefono() {
        return this.telefono;
    }
    
    @Override 
    public void setTelefono(String telefono) {
        this.telefono = telefono;
        
    }
            @Override
        public Lista<Sucursal> getListaSucursales() {
            return this.listaSucursales;
        }

        @Override
        public void insertarSucursal(Sucursal unaSucursal) {
            this.listaSucursales.insertar(new Nodo<Sucursal>(unaSucursal.getNombre(), unaSucursal));
        }

        @Override
        public boolean eliminar(Comparable clave) {
            return this.listaSucursales.eliminar(clave);
        }

    @Override
    public void imprimirSucursales() {
        this.listaSucursales.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return this.listaSucursales.imprimir(separador);
    }

    @Override
    public Sucursal buscarPorCodigo(Comparable clave) {
        Nodo<Sucursal> nodoDeProducto = this.listaSucursales.buscar(clave);
        if (nodoDeProducto != null) {
            return nodoDeProducto.getDato();
        } else {
            return null;
        }
    }

    @Override
    public int cantidadSucursales() {
        return this.listaSucursales.cantElementos();
    } 
    public void actualizarSucursales(String[] sucursales) {
        for (int i = 0; i < sucursales.length; i++) {
            
            Sucursal nuevaSucursal = new Sucursal ();
            nuevaSucursal.setNombre(sucursales[i]);
            this.insertarSucursal(nuevaSucursal);
        }
    }
    
}
