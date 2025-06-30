package pd8;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivosGenerico {

    public static void escribirArchivo(String nombreCompletoArchivo, String[] listaLineasArchivo) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(nombreCompletoArchivo))) {
            for (String lineaActual : listaLineasArchivo) {
                bw.write(lineaActual);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
    }

    public static String[] leerArchivo(String nombreCompletoArchivo) {
        List<String> listaLineasArchivo = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(nombreCompletoArchivo))) {
            String lineaActual;
            while ((lineaActual = br.readLine()) != null) {
                listaLineasArchivo.add(lineaActual);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente");

        return listaLineasArchivo.toArray(new String[0]);
    }
}
