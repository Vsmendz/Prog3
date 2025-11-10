public class ContaCorrente extends ContaBancaria{
    
    public ContaCorrente(double saldo,int idade){
        super(saldo,idade);
    }

    public double taxa = 1;
    @Override
    public boolean sacar(double valor){
        double n_valor = this.saldo - (valor + this.taxa);
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

