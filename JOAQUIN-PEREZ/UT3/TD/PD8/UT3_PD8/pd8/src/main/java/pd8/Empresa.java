package pd8;
import java.util.ArrayList;
import pd8.IEmpresa;
import pd8.Sucursal;
import pd8.ISucursal;
import pd8.ManejadorArchivosGenerico;
public class Empresa implements IEmpresa {
    
    private String nombre;
    private String direccion;
    private String telefono;
    
    private ArrayList<Sucursal> listaSucursales = new ArrayList<Sucursal>();
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
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public ArrayList getListaSucursales() {
        return this.listaSucursales;
    }

    @Override
    public void insertarSucursal(Sucursal unaSucursal) {
        this.listaSucursales.add(unaSucursal);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        for (int i = 0; i < this.listaSucursales.size(); i++) {
            Sucursal actual = this.listaSucursales.get(i);
            if (actual.getNombre() == clave) {
                this.listaSucursales.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void imprimirSucursales() {
        for (int i = 0; i < this.listaSucursales.size(); i++) {
            System.out.println(this.listaSucursales.get(i).getNombre());
        }
    }

    @Override
    public Sucursal buscarPorCodigo(Comparable clave) {
        for (int i = 0; i < this.listaSucursales.size(); i++) {
            Sucursal actual = this.listaSucursales.get(i);
            if (actual.getNombre() == clave) {
                return actual;
            }
        }
        return null;
    }

    @Override
    public int cantidadSucursales() {
        return this.listaSucursales.size();
    }    
    
    public void actualizarSucursales(String[] sucursales) {
        for (int i = 0; i < sucursales.length; i++) {
                                   
            Sucursal nuevaSucursal = new Sucursal();
            nuevaSucursal.setNombre(sucursales[i]);
            this.insertarSucursal(nuevaSucursal);
        }
    }
    
    public boolean estaVacia() {
        return this.listaSucursales.isEmpty();
    }
}
