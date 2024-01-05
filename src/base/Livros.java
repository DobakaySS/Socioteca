/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import dao.LivrosDAO;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author DOUGLAS
 */
public class Livros {
    public String codigo;
    public String autor;
    public String titulo;
    public boolean status;
    public String editora;
    
    
    
     public static Vector encontraPorTitulo(String parameter) {
        Vector itens = LivrosDAO.selectTitulo(parameter);
        return itens;
    }

    public static Vector encontraPeloId(String parameter) {
       
     Vector itens = LivrosDAO.selectById(parameter);
       return itens;
       
    }

    

    public boolean grava() {
        boolean result;
        if(this.codigo.equals("")){
            result = false;
        }else{
         result = LivrosDAO.insert(
                this.codigo,
                this.autor,this.titulo,this.status,this.editora);
        }
        return result;
    }

    public boolean deleta() {
      boolean result;
        Vector v = LivrosDAO.getAll();
        int match=0;
       int cont=0;
        while(cont<v.size()){
           Livros u = new Livros();
           u=(Livros)v.get(cont);
            if(this.codigo.equals( u.codigo)){
                match++;
            }
            cont++;
        }
        if(match==1){
         result = LivrosDAO.delete(this.codigo);
        }else{
            JOptionPane.showMessageDialog(null, "Este livro não existe.");
            result=false;
        }
        return result;
    }
    public boolean delete(){
        boolean result = LivrosDAO.delete(this.codigo);
        return result;
        
    }

    public boolean update() {
        boolean result
                = LivrosDAO.update(this.codigo,
                this.autor,this.titulo,this.status,this.editora);
        return result;
    }
    
    
    
    
    

    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
}
