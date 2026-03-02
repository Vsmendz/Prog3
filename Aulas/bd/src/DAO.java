import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public void inserir(Livro livro) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO livro (titulo, autor, ano) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setInt(3, livro.getAno());
        stmt.execute();
        conn.close();
    }

    public List<Livro> listar() throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM livro"; 
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Livro> lista = new ArrayList<>();
        while (rs.next()) {
            Livro l = new Livro();
            l.setId(rs.getInt("id"));
            l.setTitulo(rs.getString("titulo"));
            l.setAutor(rs.getString("autor"));
            l.setAno(rs.getInt("ano"));
            lista.add(l);
        }
        conn.close();
        return lista;
    }


    public void remover(int id) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "DELETE FROM livro WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        conn.close();
    }

    public void atualizar(Livro livro) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setInt(3, livro.getAno());
        stmt.setInt(4, livro.getId());
        stmt.execute();
        conn.close();
    }
}