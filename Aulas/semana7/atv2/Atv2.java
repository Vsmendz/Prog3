package semana5.atv2;

import java.util.*;

public class Atv2 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    HashSet <String> lista = new HashSet<>();
    String texto;

    do { 
        System.out.println("digite uma palavra");
        texto = entrada.next();
        texto = texto.toLowerCase();
        lista.add(texto);
    } while (!texto.equals("fim"));  
    
      
    System.out.println("");
    for (String tx: lista) {
        System.out.println("Palavra = "+tx);
    }
    System.out.println("");
        
    System.out.println("Tem palavra java? " + (lista.contains("java") ? "sim" : "nao"));

    }
}
