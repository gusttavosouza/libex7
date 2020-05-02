package br.edu.utfpr.libex7.adapters.persistence.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String JDBC_URL = "jdbc:h2:mem:libex7;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;INIT=runscript from 'classpath:create_schema_libex7.sql'";
    private static final String USER = "sa";
    private static final String PWD = null;


    private static Connection connection;

    public static Connection getInstance(){
        try {
            if(connection != null)
                return connection;
            connection = DriverManager.getConnection(JDBC_URL, USER, PWD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar com banco de dados", e);
        }
    }
}
