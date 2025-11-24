package semana5.atv1;

import java.util.*;
public class Atv1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            System.out.println("digite um valor");
            lista.add(entrada.nextInt());
        }
        int somatoria = 0;
        for(int num : lista){
            somatoria += num;
        }
        
        System.out.println("");
        double media = somatoria/ lista.size();
        System.out.println("Todos os valores");
        for (int num : lista) {
            System.out.println(""+num);
        }
        
        System.out.println("");
        System.out.println("media = "+media);
        System.out.println("somatoria = "+somatoria);
        
        lista.removeIf(num -> num % 2 ==0);
        System.out.println("Todos os valores sem pares");
        for (int num : lista) {
            System.out.println(""+num);
        }
    }
}
