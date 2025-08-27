package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

    // ex1 retorna o SO
    private String os() {
        return System.getProperty("os.name");
    }

    // ex2 
    public void exibeDistro() {
        if (!os().contains("Linux")) {
            System.out.println("Este método é exclusivo para Linux.");
            return;
        }

        String comando = "cat /etc/os-release";

        try {
            Process p = Runtime.getRuntime().exec(comando);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);

            String linha = buffer.readLine();
            while (linha != null) {
                // filtra apenas NAME e VERSION
                if (linha.startsWith("NAME=") || linha.startsWith("VERSION=")) {
                    System.out.println(linha.replace("\"", "")); // remove aspas
                }
                linha = buffer.readLine();
            }

            buffer.close();
            leitor.close();
            fluxo.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
