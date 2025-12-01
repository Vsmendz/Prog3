package Aulas.semana8.atv3;

import java.io.File;
import java.util.Scanner;

public class atv3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String path = entrada.nextLine();

        File arq = new File(path);

        if(arq.isDirectory()){
            System.out.println("caminho encontrado");
        }else if(arq.exists() && arq.isFile()){
            System.out.println("arquivo encontrado");
            System.out.println("caminho : "+arq.getAbsolutePath());
            System.out.println("tamanho bytes: "+arq.length());
        }else{
            System.out.println("erro : caminho/arquivo n encontrado");
        }
        entrada.close();
    }
}
