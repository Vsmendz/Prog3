public class Main {
    public static void main(String[] args) {
        Aluno2 l1 = new Aluno2(17, "paulo", 202425301);
        System.out.println("nome = "+l1.getNome()+"\nidade = "+l1.getIdade()+"\nmatricula = "+l1.getMatricula());
        l1.setIdade(30);
        l1.setMatricula(2783901);
        l1.setNome("joana");
        System.out.println("nome = "+l1.getNome()+"\nidade = "+l1.getIdade()+"\nmatricula = "+l1.getMatricula());
    }
}
