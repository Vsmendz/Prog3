import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        LivroDAO dao = new LivroDAO();

        // 1. Criando e inserindo os livros (Requisito: pelo menos 2 livros)
        Livro livro1 = new Livro();
        livro1.setTitulo("top 10 coisas");
        livro1.setAutor("youtube");
        livro1.setAno(1899);
        dao.inserir(livro1);

        Livro livro2 = new Livro();
        livro2.setTitulo("como beber agua");
        livro2.setAutor("chatgpt");
        livro2.setAno(2023);
        dao.inserir(livro2);

        // 2. Listando
        List<Livro> livrosIniciais = dao.listar();
        System.out.println(" Livros cadastrados no banco ");
        for (Livro l : livrosIniciais) {
            System.out.println("ID: " + l.getId() + " | Título: " + l.getTitulo() + " | Autor: " + l.getAutor());
        }

        // 3. Buscando por título
        System.out.println("\n Buscando 'como beber agua' ");
        List<Livro> busca = dao.buscarPorTitulo("como beber agua");
        for (Livro livro : busca) {
            System.out.println("Encontrado: " + livro.getTitulo() + " (ID: " + livro.getId() + ")");
        }

        // 4. Atualizando o livro encontrado na busca
        if (!busca.isEmpty()) {
            Livro livroParaAtualizar = busca.get(0);
            livroParaAtualizar.setTitulo("Java: A Referência Completa");
            dao.atualizar(livroParaAtualizar);
            System.out.println("Livro atualizado com sucesso!");
        }

        if (!livrosIniciais.isEmpty()) {
            int idParaRemover = livrosIniciais.get(0).getId(); 
            dao.remover(idParaRemover);
            System.out.println("\nLivro com ID " + idParaRemover + " (livro um) removido!");
        }

        System.out.println("\n Listagem Final ");
        for (Livro livro : dao.listar()) {
            System.out.println(livro.getId() + " - " + livro.getTitulo());
        }
    }
}