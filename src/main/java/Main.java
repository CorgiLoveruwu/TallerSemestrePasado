import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Inicio();
    }

    public static void Inicio() {
        CantidadLineas(TransformarCadena(leerArchivo("cadenas.txt")));
        SiEsPalindromo(TransformarCadena(leerArchivo("cadenas.txt")));
    }

    public static void SiEsPalindromo(String[] Lista) {
        int CantidadPalindromos = 0;
        for (int i=0;i<Lista.length;i++){
            if (esPalindromo(Lista[i])){
                CantidadPalindromos++;
            }
        }
        TotalPalindromos(CantidadPalindromos);

    }

    public static void TotalPalindromos(int cantidadPalindromos) {
        System.out.println("La cantidad de palindromos en la cadena es de "+ cantidadPalindromos);
    }

    public static boolean esPalindromo(String cadena) {
        // Convertir a minúscula y quitar espacios " ", puntos "." y comas ","
        // También remplazar palabras con acento

        cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");
        // Invertir la cadena, y si es igual que la original entonces
        // son palíndromos
        String invertida = new StringBuilder(cadena).reverse().toString();
        return invertida.equals(cadena);
    }

    //Cuenta los saltos de linea
    public static void CantidadLineas(String[] Lista) {
        System.out.println("La cantidad de lineas que tiene la cadena es de "+Lista.length);
    }
    //Pasamos el string del texto a un arreglo que los separa por un salto de linea
    public static String[] TransformarCadena(String cadenas) {
        String[] Lista = cadenas.split("\n");
        return Lista;
    }


    public static String leerArchivo(String ruta) {
        Path archivo = Paths.get(ruta);
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return contenido;
    }
}
