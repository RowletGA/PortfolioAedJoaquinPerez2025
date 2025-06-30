package pd8;
public class Main {
    public static void main(String[] args) {
        System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir")); // verfico pq no lee el archivo


        // Leer sucursales de archivo
        String sucursales[] = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\joaco\\OneDrive\\Desktop\\PortfolioJoaquinPerezAED2024\\JOAQUIN-PEREZ\\UT3\\TD\\PD8\\UT3_PD8\\pd8\\src\\main\\java\\pd8\\suc3.txt");
        Empresa empresa = new Empresa();
        
        empresa.actualizarSucursales(sucursales);
        empresa.imprimirSucursales();
        //System.out.println(empresa.cantidadSucursales());
        //empresa.eliminar("Chicago");
        
        //empresa.eliminar("Shenzen");
        //empresa.eliminar("Tokio");
        
        //System.out.println(empresa.imprimirSeparador(";_"));

        //empresa.imprimirSucursales();
    }
}