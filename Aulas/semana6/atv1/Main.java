package atv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            int result = Div.divisao(entrada.nextInt(), entrada.nextInt());
            System.out.println("resultado : "+result);
        } catch (ArithmeticException e) {
            System.out.println("error : "+e);
        }
    }
}
