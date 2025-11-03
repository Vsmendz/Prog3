

public class ContaBancaria {
    public int numero;

    public ContaBancaria(int num){
        this.numero = num;
    }

    @Override
    public String toString(){
        return "" + numero;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        if (((ContaBancaria) o) == this) return true;
        else return false;
    }
}
