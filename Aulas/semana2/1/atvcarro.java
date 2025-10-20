class carro {
    String modelo;
    String marca;
    int ano;

    public carro(String a,String b,int c){
        this.modelo = a;
        this.marca = b;
        this.ano = c;
    }

    public void exibirinfo(){
        System.out.println(this.modelo);
        System.out.println(this.ano);
        System.out.println(this.marca);
    }
}

public class atvcarro {
    public static void main(String[] args){
        carro c = new carro("top","legal",2000);
        c.exibirinfo();
    }
}