package atv2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            double r = Raiz.raiz(entrada.nextDouble());
            System.out.println("raiz : "+r);
        } catch (IllegalArgumentException e) {
            System.out.println("error : "+e.getMessage());
        }
    }
}
