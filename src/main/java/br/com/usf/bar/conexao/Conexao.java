package br.com.usf.bar.conexao;

import java.sql.*;

public class Conexao {

    private static final String Drive = "org.hibernate.dialect.PostgreSQLDialect";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/bar";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "batata";

    public static Connection getConnection(){
        try{
            Class.forName(Drive);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ErroSql) {
            throw new RuntimeException("Erro! Não foi possível conectar." + ErroSql);
        }
    }

    public static void closeConnection(Connection con) {
        try{
            if(con != null){
                con.close();
            }
        } catch (SQLException ErroSql){
            throw new RuntimeException("Erro! Não foi possível ffechar a conexão." + ErroSql);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm) {
        closeConnection(con);
        try{
            if(pstm != null){
                pstm.close();
            }
        } catch (SQLException ErroSql){
            throw new RuntimeException("Erro! Não foi possível fechar o PreparedStatement." + ErroSql);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm, ResultSet rs) {
        closeConnection(con, pstm);
        try{
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ErroSql){
            throw new RuntimeException("Erro! Não foi possível fechar o PreparedStatement." + ErroSql);
        }
    }
}
