import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime la frase");
        String frase = sc.nextLine();

        try {
        ProcessBuilder processBuilder = new ProcessBuilder("java","-jar", "librerias/separacionExamen.jar");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();




        OutputStream os = process.getOutputStream(); //ESTO ES PARA ESCRIBIR
        PrintStream ps = new PrintStream(os);
        ps.println(frase);
        ps.flush();

        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8); //el utf es para temas de codificacion
        BufferedReader br = new BufferedReader(isr);

        String linea;

        while(!((linea = br.readLine()).isEmpty())){
                System.out.println(linea);
        }

        } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}