public class Aluno2 extends Pessoa2{
    private int matricula;
    public Aluno2(int i, String n, int m){
        super(i, n);
        this.matricula = m;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
