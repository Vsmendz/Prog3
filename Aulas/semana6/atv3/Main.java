package atv3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            String value = entrada.nextLine(); 
            int num = Integer.parseInt(value);
            System.out.println("numero : "+num);

        } catch (NumberFormatException e) {
            System.out.println("error : "+e);

        } finally {
            System.out.println("Programa encerrado");
        }
    }
}
