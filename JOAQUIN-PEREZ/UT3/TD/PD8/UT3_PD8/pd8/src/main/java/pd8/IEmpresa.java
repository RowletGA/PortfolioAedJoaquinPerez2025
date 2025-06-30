package pd8;
import java.util.ArrayList;
public interface IEmpresa {
    
    public String getNombre();
    
    public String getTelefono();
    public void setTelefono (String telefono);
    
    public String getDireccion();    
    public void setDireccion(String Direccion);
    
    public ArrayList getListaSucursales();

    public void insertarSucursal(Sucursal unaSucursal);

    public boolean eliminar(Comparable clave);

    public void imprimirSucursales();


    public Sucursal buscarPorCodigo(Comparable clave);

    public int cantidadSucursales();
}
