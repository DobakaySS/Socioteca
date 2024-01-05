package dao;

import base.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class UsuarioDAO {

    public static Vector getAll() {
        try {
            String query = "select * from usuario";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();
            Vector<Usuario> itens = new Vector();

            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setSenha(rs.getString("senha"));
                obj.setStatus(rs.getBoolean("stats"));
                obj.setNome(rs.getString("nome"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setCpf(rs.getString("cpf"));
                obj.setCodigoLivro(rs.getString("codlivro"));
                obj.setDatadedevolucao(rs.getString("datadedevolucao"));
                obj.setPunicao(rs.getString("punicao"));

                itens.add(obj);
            }
            DBConnection.CloseConnection();
            return itens;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static Vector selectById(String cpf) {
        try {
            String query = "select * from usuario where cpf = ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1,cpf);
            ResultSet rs = preparedStmt.executeQuery();
            Vector<Usuario> itens = new Vector();

            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setSenha(rs.getString("senha"));
                obj.setStatus(rs.getBoolean("stats"));
                obj.setNome(rs.getString("nome"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setCpf((rs.getString("cpf")));
                obj.setCodigoLivro(rs.getString("codlivro"));
                obj.setDatadedevolucao(rs.getString("datadedevolucao"));
                obj.setPunicao(rs.getString("punicao"));
                itens.add(obj);
            }
            DBConnection.CloseConnection();
            return itens;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static boolean insert(String senha, String cpf, boolean stats, String nome, String endereco, String codlivro,String devolucao,String punicao) {
        try {
            String query = "insert into Usuario (senha, cpf,stats,nome,endereco,codlivro,datadedevolucao,punicao) "
                    + " values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1, senha);
            preparedStmt.setString(2, cpf);
            preparedStmt.setBoolean(3, stats);
            preparedStmt.setString(4, nome);
            preparedStmt.setString(5, endereco);
            preparedStmt.setString(6, codlivro);
            preparedStmt.setString(7, devolucao);
            preparedStmt.setString(8, punicao);
            
            preparedStmt.execute();
            DBConnection.CloseConnection();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean delete(String id) {
        try {
            String query = "delete from Usuario WHERE cpf = ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.execute();
            DBConnection.CloseConnection();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean update(
            String senha, String cpf, String endereco, String nome, boolean stats, String codlivro,String devolucao,String punicao) {
        try {
            String query = "update Usuario senha  = ?, cpf = ?,endereco=?,nome=?,stats=?,codlivro=? WHERE cpf = ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1, senha);
            preparedStmt.setString(2, cpf);
            preparedStmt.setString(3, endereco);
            preparedStmt.setString(4, nome);
            preparedStmt.setBoolean(5, stats);
            preparedStmt.setString(6, codlivro);
            preparedStmt.setString(7, devolucao);
            preparedStmt.setString(8, punicao);
            preparedStmt.setString(9, cpf);
            preparedStmt.execute();
            DBConnection.CloseConnection();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
