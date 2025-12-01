package Aulas.semana8.atv1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class atv1{
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Digite o nome do arquivo:");
            Scanner entrada = new Scanner(System.in);
            String nome_arq = entrada.nextLine();
            InputStream is = new FileInputStream("./Aulas/semana8/atv1/"+nome_arq+".txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);    
    
            String pl = br.readLine();
    
            while(pl != null){
                System.out.println("palavra : "+pl);
                pl = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.err.println("error : "+e);
        }
    }
} 