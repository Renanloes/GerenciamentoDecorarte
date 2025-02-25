package DAO;

import DAO.ConexaoBanco;
import Model.Material;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {
     
    //Excluir Material por ID
    public void excluirMaterial (int id) throws SQLException{
        String query = "DELETE FROM materiais WHERE id = ?";
        
        try(Connection conexao = ConexaoBanco.conectar();
            PreparedStatement ps = conexao.prepareStatement(query)){
            
             ps.setInt(1, id);
             ps.executeUpdate();
        }
    }
    
    //Cadastro Material
    public void cadastrarMaterial(Material material) throws SQLException {
        String query = "INSERT INTO materiais (id, categoria, quantidade, valor, descricao) VALUES (?,?,?,?)";
        
        try(Connection conexao = ConexaoBanco.conectar();
            PreparedStatement ps = conexao.prepareStatement(query)){
            
            ps.setString(1, material.getId());
            ps.setString(2, material.getCategoria);
            ps.setInt(3, material.getQuantidade());
            ps.setDouble(4, material.getValor());
            ps.setString(5, material.getDescricao());
        }    
    }
    
    public List<Material> listarMaterial(String id, String categoria, int quantidade, String descricao) throws SQLException{
        List<Material> materiais = new ArrayList<>();
        String query = "SELECT * FROM materiais WHERE id LIKE ? AND categoria LIKE ? AND quantidade LIKE ? AND descricao LIKE ?";
        
        try(Connection conexao = ConexaoBanco.conectar();
            PreparedStatement ps = conexao.prepareStatement(query)){
            
            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + categoria + "%");
            ps.setString(3, "%" + quantidade + "%");
            ps.setString(4, "%" + descricao + "%");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Material material = new Material (id, categoria, quantidade, descricao);
                material.setId(rs.getString("id"));
                material.setCategoria(rs.getString("categoria"));
                material.setQuantidade(rs.getInt("quantidade"));
                material.setDescricao(rs.getString("descricao"));
            }
        }
        
        return null;
    }
}
