package Control;

import br.com.sptech.eagle.back.ConexaoBancoSlack;
import br.com.sptech.eagle.back.MedidaCpu;
import br.com.sptech.eagle.back.MedidaDisco;
import br.com.sptech.eagle.back.MedidaMemoria;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author gustavo.caxile
 */
public class Relatorio {
    
    private final Integer estacaoDoTotem;

    private JdbcTemplate con;
    private ConexaoBancoSlack config;

    /**
     *
     * @param fk_estacao
     *
     */
    public Relatorio(Integer fk_estacao) {

        this.estacaoDoTotem = fk_estacao;
        novoRegistro();
    }

    public String novoRegistro() {

        //Recebe a consulta com os registros
        List<MedidaCpu> medidaCpu = consultaBancoCpu(estacaoDoTotem);
        List<MedidaDisco> medidaDisco = consultaBancoDisco(estacaoDoTotem);

        //Valida se a consulta retorna algum registro
        if (medidaCpu.isEmpty() && medidaDisco.isEmpty()) {

            return "Nenhum registro do totem encontrado nas últimas 24 horas";
        }

        //Juntando as Strings
        StringBuilder relatorio = new StringBuilder("");

        //Adiciona cada registro encontrado ao relatório
        for (MedidaCpu medida : medidaCpu) {

            relatorio.append("\n");
            relatorio.append(medidaCpu.toString());
            relatorio.append("\n\n");
        }
        
        for(MedidaDisco medida : medidaDisco){
            
            relatorio.append("\n");
            relatorio.append(medidaDisco.toString());
            relatorio.append("\n\n");
        }

        String relatorioFinal = relatorio.toString();

        return relatorioFinal;
    }

    private List<MedidaCpu> consultaBancoCpu(Integer fk_estacao) {

        try {

            //Tentativa de conexão com o banco
            this.config = new ConexaoBancoSlack();
            this.con = new JdbcTemplate((DataSource) config.getBancoSlack());
        } catch (Exception e) {

            System.out.println("Falha ao conectar com o banco de dados.");
            System.out.println(e.getMessage());
        }

        List<MedidaCpu> listaRegistros = con.query("SELECT * FROM medida_disco trm JOIN componente tm "
                + "on trm.fk_componente_cpu = tm.id_componente JOIN totem tm ON trm.fk_totem = tm.id_totem "
                + "WHERE tm.fk_estacao = 1002 AND trm.data_hora_medida_cpu >= DATEADD(day, -1, GETDATE());",
                new BeanPropertyRowMapper(MedidaCpu.class), fk_estacao);

        return listaRegistros;
    }
    
    private List<MedidaDisco> consultaBancoDisco(Integer fk_estacao) {

        try {

            //Tentativa de conexão com o banco
            this.config = new ConexaoBancoSlack();
            this.con = new JdbcTemplate((DataSource) config.getBancoSlack());
        } catch (Exception e) {

            System.out.println("Falha ao conectar com o banco de dados.");
            System.out.println(e.getMessage());
        }

        List<MedidaDisco> listaRegistros = con.query("SELECT * FROM medida_cpu trm JOIN componente tm "
                + "on trm.fk_componente_cpu = tm.id_componente JOIN totem tm ON trm.fk_totem = tm.id_totem "
                + "WHERE tm.fk_estacao = 1002 AND trm.data_hora_medida_cpu >= DATEADD(day, -1, GETDATE());",
                new BeanPropertyRowMapper(MedidaDisco.class), fk_estacao);

        return listaRegistros;
    }
    
    private List<MedidaMemoria> consultaBancoMemoria(Integer fk_estacao){
        
        try{
            
            //Tentativa de conexão com o banco
            this.config = new ConexaoBancoSlack();
            this.con = new JdbcTemplate(config.getBancoSlack());
        } catch(Exception e){
            
            System.out.println("Falha ao conectar com o banco de dados.");
            System.out.println(e.getMessage());
        }
        
        List<MedidaMemoria> listaRegistros = con.query("SELECT * FROM medida_disco trm JOIN componente tm "
                + "ON trm.fk_componente_memoria = tm.id_componente JOIN totem tm ON trm.fk_totem = tm.id_totem "
                + "WHERE tm.fk_estacao = 1002 AND trm.data_hora_medidca_memoria >= DATEADD(day, -1, GETDATE());",
                new BeanPropertyRowMapper(MedidaMemoria.class), fk_estacao);
        
        return listaRegistros;
    }
}
