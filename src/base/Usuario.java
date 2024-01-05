/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import dao.UsuarioDAO;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author DOUGLAS
 */
public class Usuario {
    public String senha;
    public String cpf;
    public boolean status;
    public String nome;
    public String endereco;
    public String codigoLivro;
    public String datadedevolucao;
    public String punicao;// formato = "0;0;0;0;00/00/0000" ou
    //              "contadordedias; dias de atraso;(contadordedias*2); dias banido;dia de amanha";

    
    
    
     public static Vector encontraPeloId(String cpf) {
       
     Vector itens = UsuarioDAO.selectById(cpf);
       return itens;
       
    }

    public boolean grava() {
        boolean result;
        Vector v = UsuarioDAO.getAll();
        int match=0;
       int cont=0;
        while(cont<v.size()){
           Usuario u = new Usuario();
           u=(Usuario)v.get(cont);
            if(this.cpf.equals(u.cpf)){
                match++;
            }
            cont++;
        }
        if(match==0){
         result = UsuarioDAO.insert(this.senha, this.cpf, this.status, this.nome, this.endereco,this.codigoLivro,this.datadedevolucao,this.punicao);
        }else{
            JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado");
            result=false;
        }
        return result;
    }

    public boolean deleta() {
        boolean result = UsuarioDAO.delete(this.cpf);
        return result;
    }

    public boolean update() {
        boolean result
                = UsuarioDAO.update(this.senha, this.cpf,this.endereco,this.nome, this.status,this.codigoLivro,this.datadedevolucao,this.punicao);
        return result;
    }
    
    
    
    
    public String getDatadedevolucao() {
        return datadedevolucao;
    }
    public void setDatadedevolucao(String datadedevolucao) {
        this.datadedevolucao = datadedevolucao;
    }

    public String getPunicao() {
        return punicao;
    }

    public void setPunicao(String punicao) {
        this.punicao = punicao;
    }
    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(String codigoLivro) {
        this.codigoLivro = codigoLivro;
    }
    
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }
   
    
    
    
    
    
  
    
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
