package Control;

/**
 *
 * @author gustavo.caxile
 */
public class Estacao {
    
    private Integer id_estacao;
    private String nome;
    private String zona;
    private String status_estacao;
    private Integer fk_empresa;
    private String slackWebHook;

    public Integer getId_estacao() {
        return id_estacao;
    }

    public void setId_estacao(Integer id_estacao) {
        this.id_estacao = id_estacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getStatus_estacao() {
        return status_estacao;
    }

    public void setStatus_estacao(String status_estacao) {
        this.status_estacao = status_estacao;
    }

    public Integer getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(Integer fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public String getSlackWebHook() {
        return slackWebHook;
    }

    public void setSlackWebHook(String slackWebHook) {
        this.slackWebHook = slackWebHook;
    }

    @Override
    public String toString() {
        return "Estacao{" + "id_estacao=" + id_estacao + ", nome=" + nome + ", zona=" + zona + ", status_estacao=" + status_estacao + ", fk_empresa=" + fk_empresa + ", slackWebHook=" + slackWebHook + '}';
    }
}
