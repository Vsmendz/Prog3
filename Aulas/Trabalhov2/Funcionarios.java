package Aulas.Trabalho;

public abstract class Funcionarios{
    protected String nome;
    protected int matricula_id;
    protected double salario;

    public Funcionarios(String nnome,int id,double ssalario){
        this.nome = nnome;
        this.matricula_id = id;
        this.salario = ssalario;
    }

    public String getNome(){
        return nome;
    }
    
    public int getMatricula(){
        return matricula_id;
    }

    public double getSalario(){
        return salario;
    }

    public double getUnique(){
        return -1;
    } 

    public abstract String getCargo();

    public abstract double calcular_salario();   
}

class Gerente extends Funcionarios{
    private double bonus;

    public Gerente(String nnome,int id,double ssalario,double bbonus) throws IllegalArgumentException{
        super(nnome, id, ssalario);
        if (bbonus < 0) {
            throw new IllegalArgumentException("Limite invalido");
        }
        this.bonus = bbonus;
    }

    @Override
    public String getCargo(){
        return "Gerente";
    }

    @Override
    public double getUnique(){
        return bonus;
    }

    @Override
    public double calcular_salario(){
        return salario + bonus; 
    }
}

class Vendedor extends Funcionarios{
    private double comissao;

    public Vendedor(String nnome,int id,double ssalario,double ccomissao) throws IllegalArgumentException{
        super(nnome, id, ssalario);
        if (ccomissao > 1 || ccomissao < 0) {
            throw new IllegalArgumentException("Comissao fora do limite");
        }
        this.comissao = ccomissao;
    }

    @Override
    public String getCargo(){
        return "Vendedor";
    }

    @Override
    public double getUnique(){
        return comissao;
    }

    @Override
    public double calcular_salario(){
        return salario + salario * comissao; 
    }
}


class Estagiario extends Funcionarios{

    public Estagiario(String nnome,int id,double ssalario){
        super(nnome, id, ssalario);
    }

    @Override
    public String getCargo(){
        return "Estagiario";
    }

    @Override
    public double calcular_salario(){
        return salario;
    }
}

class Diretor extends Funcionarios{
    public Diretor(String nome,int id,double salario){
    super(nome,id,salario);
    }

    @Override 
    public String getCargo(){
        return "Diretor";
    }

    @Override
    public  double calcular_salario(){
        return salario;
    }
}