package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Angelo
 */
public class DBConnection {

//Início da classe de conexão//
    public static String status = "Not connected...";

    public static Connection connection = null;//atributo do tipo Connection 

    public static void main(String args[]) {
        System.out.println("Testando conexão");
        DBConnection.getConnectionMySQL();
        System.out.println(DBConnection.status);
    }

//Método de Conexão//
    public static Connection getConnectionMySQL() {

        try {
// Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//
            String serverName = "200.18.128.78";    //caminho do servidor do BD
            String mydatabase = "douglas_mluiza";   //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "douglas_mluiza";        //nome de um usuário de seu BD      
            String password = "biblioteca";      //sua senha de acesso
            connection = DriverManager
                    .getConnection(url, username, password);
            //Testa sua conexão//  
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }

    //Método que fecha sua conexão//
    public static boolean CloseConnection() {

        try {
            DBConnection.getConnectionMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ResartConnection() {
        CloseConnection();
        return DBConnection.getConnectionMySQL();
    }

}
