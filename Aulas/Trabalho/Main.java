package Aulas.Trabalho;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionarios> ls = new ArrayList<>();
        Menu.start(ls);

        try {
            save(ls);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

    }
    public static void save(ArrayList<Funcionarios> ls)throws FileNotFoundException {
        PrintStream out = new PrintStream("./Aulas/Trabalho/backup.csv");
        out.println("Cargo,Nome,ID,Salario_Base,Unique,Salario_Total");
        for (Funcionarios func : ls) {
            out.printf("%s,%s,%s,%s,%s,%s\n",func.getCargo(),func.getNome(),func.getMatricula(),
            func.getSalario(),func.getUnique(),func.calcular_salario());
        }
    }
    public static void load(ArrayList<Funcionarios> ls)throws FileNotFoundException{
        BufferedReader br = new BufferedReader(new FileReader("./Aulas/Trabalho/backup.csv"));
        try {
            br.readLine();
            String linha;
            while ((linha = br.readLine()) != null){
                ArrayList<String> atributos = new ArrayList<>();
                String instancia = "";
                for (char letra : linha.toCharArray()) {
                    if (letra == ','){
                        atributos.add(instancia);
                        instancia = "";
                    }
                    instancia += letra;
                }
                
            }
        } catch (Exception e) {
        }

    }
}
