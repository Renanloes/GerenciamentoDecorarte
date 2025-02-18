package DAO;

import Model.Usuario;
import DAO.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UsuarioDAO {
    public boolean logar(String usuario, String senha){
        String sql = "SELECT senha FROM usuarios WHERE senha = ?";
        
        try(Connection conexao = ConexaoBanco.conectar();
            PreparedStatement sm = conexao.prepareStatement(sql)){
            sm.setString(1, senha);
            
            try(ResultSet rs = sm.executeQuery()){
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
    
    
}
