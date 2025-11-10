// import ContaCorrente.*


public class Main {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(0,30);
        System.out.println("saldo da conta "+c1.saldo);
        c1.sacar(20);
        c1.depositar(1000);
        c1.sacar(100);
        System.out.println("saldo da conta "+c1.saldo);

        ContaPoupanca c2 = new ContaPoupanca(100,20);
        System.out.println("saldo da conta "+c2.saldo);
        c2.sacar(20);
        c2.depositar(1000);
        c2.sacar(100);
        System.out.println("saldo da conta "+c2.saldo);
    }
}
