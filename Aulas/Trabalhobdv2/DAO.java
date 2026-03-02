package Aulas.Trabalhobdv2;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

    // =========================
    // INSERIR
    // =========================
    public void inserir(Funcionarios func) {

        try {

            Connection conn = Conexao.conectar();

            String sql =
                "INSERT INTO Funcionario (id, nome, cargo, salario_base, salario_total) " +
                "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, func.getId());
            stmt.setString(2, func.getNome());
            stmt.setString(3, func.getCargo());
            stmt.setDouble(4, func.getSalario());
            stmt.setDouble(5, func.calcular_salario());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // LISTAR
    // =========================
    public ArrayList<Funcionarios> listar() {

        ArrayList<Funcionarios> lista = new ArrayList<>();

        try {

            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM Funcionario";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String cargo = rs.getString("cargo");
                String nome = rs.getString("nome");
                int id = rs.getInt("id");
                double base = rs.getDouble("salario_base");
                double total = rs.getDouble("salario_total");

                switch (cargo) {

                    case "Gerente":
                        lista.add(new Gerente(
                                nome,
                                id,
                                base,
                                total - base
                        ));
                        break;

                    case "Vendedor":
                        lista.add(new Vendedor(
                                nome,
                                id,
                                base,
                                (total / base) - 1
                        ));
                        break;

                    case "Estagiario":
                        lista.add(new Estagiario(
                                nome,
                                id,
                                base
                        ));
                        break;

                    case "Diretor":
                        lista.add(new Diretor(
                                nome,
                                id,
                                base
                        ));
                        break;
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // =========================
    // REMOVER
    // =========================
    public void remover(int id) {

        try {

            Connection conn = Conexao.conectar();

            String sql = "DELETE FROM Funcionario WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}