package br.com.sptech.eagle.back;

import Control.Colaborador;
import Control.Estacao;
import Control.Relatorio;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author gustavo.caxile
 */
public class Slack {
    
    private static final HttpClient client = HttpClient.newHttpClient();
    public static String URL;

    private ConexaoBancoSlack config;
    private JdbcTemplate con;

    private final Integer id_estacao;
    private final Integer id_totem;
   
    public Slack(Integer fk_estacao,Integer fk_totem) {
        this.id_estacao = fk_estacao;
        this.URL = recuperarWebHook(id_estacao);
        this.id_totem = fk_totem;

        this.verificarURL(URL);
        System.out.println(URL);
    }

    public static void sendMessage(org.json.JSONObject content) throws IOException, InterruptedException {

        System.out.println(URL);
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }

    public static void enviarRelatorio(Integer fk_totem) throws IOException, InterruptedException {

        // Foi necessário usar a fk_estacao para fazer o select no banco
        // O objeto Relatorio retorna uma string com relatório montado
        Relatorio relatorio = new Relatorio(fk_totem);

        //Transforma o relatório em JSON para API SLACK
        org.json.JSONObject json = new org.json.JSONObject();
        json.put("text", relatorio.novoRegistro());

        Slack.sendMessage(json);
    }

    public Slack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void alertaMapeamento(String mensagem, String data_implementada) {

        try {

            org.json.JSONObject json = new org.json.JSONObject();

            //Montando a imagem que será enviada pelo Slack
            String alert = String.format(" %s \n\n"
                    + "Totem: %d\n"
                    + "Horário: %s\n",
                    mensagem, id_totem, data_implementada);

            //Transforma o alerta em JSON para a API SLACK
            json.put("text", alert);

            Slack.sendMessage(json);
        } catch (IOException e) {

            System.out.println("Falha ao enviar alerta de mapeamento de dispositivos ao Slack");
            System.out.println(e.getMessage());
        } catch (InterruptedException ex) {

            Logger.getLogger(Slack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String recuperarNomeUsuario(Integer id_colaborador) {

        try {

            //Tentativa de conexão com o Banco
            this.config = new ConexaoBancoSlack();
            this.con = new JdbcTemplate(config.getBancoSlack());
        } catch (Exception e) {

            System.out.println("Falha ao conectar com o banco de dados.");
            System.out.println(e.getMessage());
        }

        List<Colaborador> listaDeUsuarios = con.query(""
                + "SELECT * FROM colaborador "
                + "WHERE id_colaborador = ?",
                new BeanPropertyRowMapper(Colaborador.class), id_colaborador);

        String nome = "";
        for (Colaborador colaborador : listaDeUsuarios) {

            nome = colaborador.getNome();
        }

        return nome;
    }

    private String recuperarWebHook(Integer id_estacao) {

        try {

            this.config = new ConexaoBancoSlack();
            this.con = new JdbcTemplate(config.getBancoSlack());
        } catch (Exception e) {

            System.out.println("Falha ao conectar com o banco de dados.");
            System.out.println(e.getMessage());
        }

        List<Estacao> listaEstacao = con.query(""
                + "SELECT * FROM estacao "
                + "WHERE id_estacao = ?",
                new BeanPropertyRowMapper(Estacao.class), id_estacao);
        System.out.println(listaEstacao + "teste");
        System.out.println(id_estacao);
        
        String mensagem = "aaa";
        for (Estacao estacao : listaEstacao) {

            mensagem = estacao.getSlackWebHook();
        }
        
        System.out.println(mensagem);
        return mensagem;
    }

    private void verificarURL(String URL) {

        if (URL == null) {

            System.out.println("Estação sem URL Slack WebHook cadastrada.");
        } else if (URL.isBlank()) {

            System.out.println("URL está em branco.");
        }
    }
}
