package Control;

/**
 *
 * @author gustavo.caxile
 */
public class Colaborador {
    
    private Integer id_colaborador;
    private String nome;
    private Integer nivel_acesso;
    private String funcao;
    private String telefone;
    private String email;
    private String senha;
    private Integer fk_estacao;

    public Integer getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(Integer id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(Integer nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getFk_estacao() {
        return fk_estacao;
    }

    public void setFk_estacao(Integer fk_estacao) {
        this.fk_estacao = fk_estacao;
    }

    @Override
    public String toString() {
        return "Colaborador{" + "id_colaborador=" + id_colaborador + ", nome=" + nome + ", nivel_acesso=" + nivel_acesso + ", funcao=" + funcao + ", telefone=" + telefone + ", email=" + email + ", senha=" + senha + ", fk_estacao=" + fk_estacao + '}';
    }
}
