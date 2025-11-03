public class Main {
    public static void main(String[] args) {
        Livro l1 = new Livro();
        Livro l2 = new Livro("jorge","la casa de banana");
        System.out.println("autor = "+l1.autor+"| nome = "+l1.titulo);
        System.out.println("autor = "+l2.autor+"| nome = "+l2.titulo);
    }
}
