package Aulas.semana8.atv2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class atv2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        PrintStream out = new PrintStream("./Aulas/semana8/atv2/saida.txt");
        String flag;
        while (entrada.hasNextLine()){
            flag = entrada.nextLine();
            if (flag.equals("FIM")){
                break;
            }
            out.println(flag);
        }
        entrada.close();
        out.close();
    }
}
