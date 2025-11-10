public abstract  class ContaBancaria {
    public ContaBancaria(double asaldo,int aidade){
        this.saldo = asaldo;
        this.idade = aidade;
    }
    public double saldo;
    public int idade;
    public abstract boolean sacar(double valor);
    public abstract void depositar(double valor);
}
