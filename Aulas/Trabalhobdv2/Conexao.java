package Aulas.Trabalhobdv2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url =
            "jdbc:mysql://100.75.155.128:3306/Func" +
            "?useSSL=false&serverTimezone=UTC";

        String user = "root";
        String senha = "casaos";

        return DriverManager.getConnection(url, user, senha);
    }
}