package Aulas.Trabalho

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static final String URL = "jdbc:mysql://100.75.155.128:3306/Func";
    private static final String USER = "root";
    private static final String PASSWORD = "casaos";

    public static Connection conectar() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}