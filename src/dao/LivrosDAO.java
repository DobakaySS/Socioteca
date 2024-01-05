package dao;

import base.Livros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class LivrosDAO {
    public static Vector getAll(){
        try {
            String query = "select * from livros";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
          
            ResultSet rs = preparedStmt.executeQuery();
            Vector<Livros> itens = new Vector();

            while (rs.next()) {
                Livros obj = new Livros();
                obj.setCodigo(rs.getString("codigo"));
                obj.setAutor(rs.getString("autor"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setEditora(rs.getString("editora"));
                obj.setStatus(rs.getBoolean("stats"));

                itens.add(obj);
            }
            DBConnection.CloseConnection();
            return itens;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public static Vector selectStatus(boolean s) {
        try {
            String query = "select * from livros where stats like ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1, "%"+s+"%");
            ResultSet rs = preparedStmt.executeQuery();
            Vector<Livros> itens = new Vector();

            while (rs.next()) {
                Livros obj = new Livros();
                obj.setCodigo(rs.getString("codigo"));
                obj.setAutor(rs.getString("autor"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setEditora(rs.getString("editora"));
                obj.setStatus(rs.getBoolean("stats"));

                itens.add(obj);
            }
            DBConnection.CloseConnection();
            return itens;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    public static Vector selectEditor(String editora) {
        try {
            String query = "select * from livros where editora like ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1, "%"+editora+"%");
            ResultSet rs = preparedStmt.executeQuery();
            Vector<Livros> itens = new Vector();

            while (rs.next()) {
                Livros obj = new Livros();
                obj.setCodigo(rs.getString("codigo"));
                obj.setAutor(rs.getString("autor"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setEditora(rs.getString("editora"));
                obj.setStatus(rs.getBoolean("stats"));

                itens.add(obj);
            }
            DBConnection.CloseConnection();
            return itens;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    public static Vector selectAutor(String autor) {
        try {
            String query = "select * from livros where autor like ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1, "%"+autor+"%");
            ResultSet rs = preparedStmt.executeQuery();
            Vector<Livros> itens = new Vector();

            while (rs.next()) {
                Livros obj = new Livros();
                obj.setCodigo(rs.getString("codigo"));
                obj.setAutor(rs.getString("autor"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setEditora(rs.getString("editora"));
                obj.setStatus(rs.getBoolean("stats"));

                itens.add(obj);
            }
            DBConnection.CloseConnection();
            return itens;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
       public static Vector selectTitulo(String titulo) {
        try {
            String query = "select * from livros where titulo like ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1, "%"+titulo+"%");
            ResultSet rs = preparedStmt.executeQuery();
            Vector<Livros> itens = new Vector();

            while (rs.next()) {
                Livros obj = new Livros();
                obj.setCodigo(rs.getString("codigo"));
                obj.setAutor(rs.getString("autor"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setEditora(rs.getString("editora"));
                obj.setStatus(rs.getBoolean("stats"));

                itens.add(obj);
            }
            DBConnection.CloseConnection();
            return itens;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static Vector selectById(String parameter) {
        try {
            String query = "select * from livros where codigo = ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1, parameter);
            ResultSet rs = preparedStmt.executeQuery();
            Vector<Livros> itens = new Vector();
            int cont=0;
            while (rs.next()) {
                
                Livros obj = new Livros();
                obj.setCodigo(rs.getString("codigo"));
                obj.setAutor(rs.getString("autor"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setEditora(rs.getString("editora"));
                obj.setStatus(rs.getBoolean("stats"));
                itens.add(obj);
                cont++;
            }
            DBConnection.CloseConnection();
            
            return itens;
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static boolean insert(String codigo, String autor, String titulo, boolean status,String editora) {
        try {
            String query = "insert into livros (codigo,autor,stats,editora,titulo) "
                    + " values(?,?,?,?,?)";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1,codigo);
            preparedStmt.setString(2,autor);
            preparedStmt.setBoolean(3, status);
            preparedStmt.setString(4,editora);
            preparedStmt.setString(5,titulo);
            
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
            String query = "delete from livros WHERE codigo = ?";
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
            String codigo, String autor, String titulo, boolean status,String editora) {
        try {
            String query = "update Livros set codigo = ?, autor = ?,stats=?,editora =?,titulo=? WHERE codigo = ?";
            PreparedStatement preparedStmt = DBConnection.getConnectionMySQL()
                    .prepareStatement(query);
            preparedStmt.setString(1,codigo);
            preparedStmt.setString(2,autor);
            preparedStmt.setBoolean(3, status);
            preparedStmt.setString(4,editora);
            preparedStmt.setString(5,titulo);
            preparedStmt.setString(6, codigo);
            preparedStmt.execute();
            DBConnection.CloseConnection();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
