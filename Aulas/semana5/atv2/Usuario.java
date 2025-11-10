package atv2;

enum nivel_acesso {basico,medio,top};

public class Usuario {
    public nivel_acesso nivel;
    public String nome;

    public Usuario(String n,nivel_acesso na){
        this.nome = n;
        this.nivel = na; 
    }
}
