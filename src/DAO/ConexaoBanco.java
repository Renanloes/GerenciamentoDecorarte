package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/GestaoEstoque";
    private static final String USUARIO = "root";
    private static final String SENHA = "YES";
    
    //Abrir conexao banco
    public static Connection conectar() {
        try {
            // Retorna conexao com banco
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            // Exibe mensagem de erro detalhada
            JOptionPane.showMessageDialog(null, "Erro de Conexão com o Banco: " + e.getMessage());
          
            return null;
        }
    }
    
    public static void fecharConexao(Connection conexao){
        try{
            if(conexao != null){
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            }
        }catch (SQLException e){
            System.out.println("Erro ao fechar conexao :" + e.getMessage());
        }
    }
}
