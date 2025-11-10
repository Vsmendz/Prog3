public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(double saldo,int idade){
        super(saldo,idade);
    }
    
    @Override
    public boolean sacar(double valor){
        double n_valor = this.saldo - valor;
        if (n_valor >= 0){
            this.saldo = n_valor;
            // variavel valor sacado
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor){
        if (valor > 0){
            this.saldo += valor;
        }
    }
}
