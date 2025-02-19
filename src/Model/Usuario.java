package Model;

public class Usuario {
    private int cod;
    private String nome;
    private String senha;
    private String cargo;
    public String getNome;
    public String getSenha;
    public String getCargo;
    
    //Construtor com parametros
    public Usuario(int cod, String nome, String senha, String cargo){
        this.cod = cod;
        this.nome = nome;
        this.senha = senha;
        this.cargo = cargo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
