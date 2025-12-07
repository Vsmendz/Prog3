package Aulas.Trabalho;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionarios> ls = new ArrayList<>();
        try {
            load(ls);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        
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
                        continue;
                    }
                    instancia += letra;
                }
                switch (atributos.get(0)) {
                    case "Gerente":
                        ls.add(new Gerente(atributos.get(1),Integer.parseInt(atributos.get(2)),
                        Double.parseDouble(atributos.get(3)),Double.parseDouble(atributos.get(4))));
                        break;
                    case "Estagiario":
                        ls.add(new Estagiario(atributos.get(1),Integer.parseInt(atributos.get(2)),
                        Double.parseDouble(atributos.get(3))));
                        break;
                    default:
                        ls.add(new Vendedor(atributos.get(1),Integer.parseInt(atributos.get(2)),
                        Double.parseDouble(atributos.get(3)),Double.parseDouble(atributos.get(4))));
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
