package br.com.sptech.eagle.back;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class ModelBd2 {

   public void inserirDadosBancoLocal() {

        // INSERIR DADOS A CADA PERIODO DE TEMPO DE FORMA AUTOMATIZADA!!!!!!!!!!!!!!!!!!
        // ----- CRIANDO OBJETOS NECESSÁRIOS PARA BUSCAR MÉTODOS -----
//        ConexaoBancoH2 conexaoSQL = new ConexaoBancoH2();
        Timer timer = new Timer();
        ConexaoBancoSQL conexaoSQL = new ConexaoBancoSQL();
        MedidaDisco disco = new MedidaDisco();
        MedidaCpu cpu = new MedidaCpu();
        MedidaMemoria memoria = new MedidaMemoria();

// -------------------- CUIDADO AO USAR ESSES COMANDOS NA NUVEM --------------------------------------------------------------
        //Dropa a tabela antes porque não pode criar a mesma tabela 2x, 
        //então na segunda vez o execute "create table" da erro.
        conexaoSQL.getConexaoSQL().execute("drop table if exists medida_disco;");

        conexaoSQL.getConexaoSQL().execute("drop table if exists medida_cpu;");

        conexaoSQL.getConexaoSQL().execute("drop table if exists medida_memoria;");

        // ---------- TABELA MEDIDA_DISCO ----------
        conexaoSQL.getConexaoSQL().execute("create table medida_disco ("
                + "id_medida_disco int primary key auto_increment,"
                + "uso_de_disco double,"
                + "disco_livre double,"
                + "data_hora_medida_disco datetime"
                + ");");

        // ---------- TABELA MEDIDA_CPU ----------
        conexaoSQL.getConexaoSQL().execute("create table medida_cpu ("
                + "id_medida_cpu int primary key auto_increment,"
                    + "tempo_cpu long,"
                + "processos_cpu double,"
                + "data_hora_medida_cpu datetime"
                + ");");

        // ---------- TABELA MEDIDA_MEMORIA ----------
        conexaoSQL.getConexaoSQL().execute("create table medida_memoria ("
                + "id_medida_memoria int primary key auto_increment,"
                + "uso_ram double,"
                + "ram_livre double,"
                + "data_hora_medida_memoria datetime"
                + ");");

        // ------------------------------------------------------------------------------------------------------------------------------    
//        Aqui setamos um timer para que o código execute em loop a cada x segundos e assim capturar os dados da máquina continuamente
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                // ---------- INSERINDO VALORES NA TABELA MEDIDA_DISCO ----------
                LocalDateTime dataHoraMedidaDisco = disco.getDataHoraMedidaDisco();
                Double usoDeDisco = disco.buscarEspacoOcupadoDisco();
                Double discoLivre = disco.buscarEspacoLivreDisco();

                conexaoSQL.getConexaoSQL().update("insert into medida_disco values "
                        + "(null, ?, ?, ?);", usoDeDisco, discoLivre, dataHoraMedidaDisco);

                //Listar informações de disco
                List<MedidaDisco> listaDeMedidasDisco = conexaoSQL.getConexaoSQL().query("select * from "
                        + "medida_disco;", new BeanPropertyRowMapper(MedidaDisco.class));

                // ---------- INSERINDO VALORES NA TABELA MEDIDA_CPU ---------
                LocalDateTime dataHoraMedidaCpu = cpu.getDataHoraMedidaCpu();
                Long tempoCpu = cpu.buscarFrequenciaCpu();
                Integer processosCpu = cpu.buscarProcessosCpu();

                conexaoSQL.getConexaoSQL().update("insert into medida_cpu values "
                        + "(null, ?, ?, ?);", tempoCpu, processosCpu, dataHoraMedidaCpu);

                //Listar informações da cpu
                List<MedidaCpu> listaDeMedidaCpu = conexaoSQL.getConexaoSQL().query("select * from "
                        + "medida_cpu;", new BeanPropertyRowMapper(MedidaCpu.class));

                // ---------- INSERINDO VALORES NA TABELA MEDIDA_MEMORIA ---------
                Double usoRam = memoria.buscarMemoriaEmUso();
                Double ramLivre = memoria.buscarMemoriaDisponivel();
                LocalDateTime dataHoraMedidaMemoria = memoria.getDataHoraMedidaMemoria();

                conexaoSQL.getConexaoSQL().update("insert into medida_memoria values "
                        + "(null, ?, ?, ?);", usoRam, ramLivre, dataHoraMedidaMemoria);

                //Listar informações da memoria
                List<MedidaMemoria> listaDeMedidaMemoria = conexaoSQL.getConexaoSQL().query("select * from "
                        + "medida_memoria;", new BeanPropertyRowMapper(MedidaMemoria.class));

                //Imprimindo listas
                System.out.println(listaDeMedidasDisco);
                listaDeMedidasDisco.clear();

                System.out.println(listaDeMedidaCpu);
                listaDeMedidaCpu.clear();

                System.out.println(listaDeMedidaMemoria);
                listaDeMedidaMemoria.clear();

            }
//          Timer funciona com milissegundos, então 1000 ms = 1 segundo
        }, 0, 2000);
    }
}
