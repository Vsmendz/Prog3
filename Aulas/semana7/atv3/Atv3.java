package semana5.atv3;

import java.util.*;

public class Atv3 {
    public static void main(String[] args) {
        Map<String,Integer> lista = new HashMap<>();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantos usuarios deseja digitar?");
        int cont = entrada.nextInt();
        entrada.nextLine(); // limpar buffer

        for (int i = 0; i < cont; i++) {
            System.out.println("Nome");
            String nome = entrada.nextLine();
            System.out.println("idade");
            int idade = entrada.nextInt();
            entrada.nextLine();
            lista.put(nome, idade);
        }            

        System.out.println("Digite um nome para ver a idade");
        String flag = entrada.nextLine();
        if (lista.containsKey(flag)) {
            System.out.println("idade = "+lista.get(flag));
            lista.remove(flag);
        }else{
            System.out.println("pessoa nao encotrada");
        }

        System.out.println(lista);

    }
}
