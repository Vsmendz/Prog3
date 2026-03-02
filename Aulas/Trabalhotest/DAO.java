package Aulas.Trabalho

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public void inserir(Funcionarios Func) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO Funcionario (nome, cargo, salario_base,salario_total) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, Func.getNome());
        stmt.setString(2, Func.getCargo);
        stmt.setDouble(3, Func.getSalario());
        stmt.setDouble(4, Func.calcular_salario());
        stmt.execute();
        conn.close();
    }

public List<Funcionarios> listar() throws Exception {
    List<Funcionarios> lista = new ArrayList<>();
    String sql = "SELECT * FROM Funcionario"; 
    
    // O try-with-resources já cuida de fechar o conn, stmt e rs para você!
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
         
        while (rs.next()) {
            Funcionarios func;
            
            // Verificamos se a coluna de comissão tem algum valor (se não for nula, é Vendedor)
            if (rs.getObject("percentual_comissao") != null) {
                Vendedor vendedor = new Vendedor();
                vendedor.setPercentualComissao(rs.getDouble("percentual_comissao"));
                func = vendedor; // O Vendedor assume o papel da variável func
            } else {
                // Se for nula, instanciamos um funcionário comum
                func = new Funcionarios(); 
            }
            
            // Agora preenchemos os dados comuns a ambos os tipos
            // (Assumindo que sua tabela tem uma coluna 'id')
            func.setId(rs.getInt("id")); 
            func.setNome(rs.getString("nome"));
            func.setCargo(rs.getString("cargo"));
            func.setSalarioBase(rs.getDouble("salario_base"));
            
            // Adiciona na lista o objeto correto (seja ele Funcionario comum ou Vendedor)
            lista.add(func);
        }
    }
    return lista;
}

public void remover(int id) throws Exception {
    String sql = "DELETE FROM Funcionario WHERE id = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         
        stmt.setInt(1, id);
        stmt.execute();
    }
}