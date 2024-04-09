package org.mario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection conectar() throws SQLException {
        Connection con = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/agenda";
            String user = "aluno";
            String password = "aluno";

            con = DriverManager.getConnection(url, user, password);


        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return con;
    }

    public static void desconectar(Connection connection){
        if(connection != null){
            try{
            connection.close();
            } catch (SQLException e){
                System.out.println("Erro" + e.getMessage());
        }
    }
    }
}
