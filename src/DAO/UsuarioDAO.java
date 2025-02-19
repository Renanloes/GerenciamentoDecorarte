package DAO;

import Model.Usuario;
import DAO.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UsuarioDAO { // login
    public boolean logar(String usuario, String senha){
        String sql = "SELECT senha FROM usuarios WHERE senha = ?";
        
        try(Connection conexao = ConexaoBanco.conectar();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, senha);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){ //se encontrado usuario
                    String senhaBanco = rs.getString("senha"); //Obtem a senha
                    
                    
                    return senha.equals(senhaBanco);
                }
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário" + e.getMessage());
        }
        
        return false; // Caso nao encontre ou relate erro       
    }
    
    
    public void CadastroUsuario(Usuario usuario){
        String sql = "INSERT INTO usuarios(nome, senha, cargo) VALUES(?,?,?)";
        try(Connection conexao = ConexaoBanco.conectar();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            
            ps.setString(1, usuario.getNome);
            ps.setString(1, usuario.getSenha);
            ps.setString(1, usuario.getCargo);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário" + e.getMessage());
        }
    }
    
}
