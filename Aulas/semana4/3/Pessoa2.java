public class Pessoa2 {
    private int idade;
    private String nome;
    public Pessoa2(int i, String n){
        this.nome = n;
        this.idade = i;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}
