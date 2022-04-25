package br.com.sptech.eagle.back;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class ModelBd {

    public void inserirDadosBanco() {

        // INSERIR DADOS A CADA PERIODO DE TEMPO DE FORMA AUTOMATIZADA!!!!!!!!!!!!!!!!!!
        // ----- CRIANDO OBJETOS NECESSÁRIOS PARA BUSCAR MÉTODOS -----
//        ConexaoBancoH2 conexaoServer = new ConexaoBancoH2();
        Timer timer = new Timer();
//        ConexaoBancoSQL conexaoSQL = new ConexaoBancoSQL();
        ConexaoBancoServer conexaoServer = new ConexaoBancoServer();
        MedidaDisco disco = new MedidaDisco();
        MedidaCpu cpu = new MedidaCpu();
        MedidaMemoria memoria = new MedidaMemoria();

// -------------------- CUIDADO AO USAR ESSES COMANDOS NA NUVEM --------------------------------------------------------------
        //Dropa a tabela antes porque não pode criar a mesma tabela 2x, 
        //então na segunda vez o execute "create table" da erro.
//        conexaoServer.getConexaoServer().execute("drop table if exists medida_disco;");
//        conexaoServer.getConexaoServer().execute("drop table if exists medida_cpu;");
//        conexaoServer.getConexaoServer().execute("drop table if exists medida_memoria;");
//        conexaoServer.getConexaoServer().execute("drop table if exists empresa;");
//        conexaoServer.getConexaoServer().execute("drop table if exists endereco_empresa;");
//        conexaoServer.getConexaoServer().execute("drop table if exists estacao;");
//        conexaoServer.getConexaoServer().execute("drop table if exists colaborador;");
//        conexaoServer.getConexaoServer().execute("drop table if exists externo_lead;");
//        conexaoServer.getConexaoServer().execute("drop table if exists totem;");
//        conexaoServer.getConexaoServer().execute("drop table if exists componente;");
//        conexaoServer.getConexaoServer().execute("drop table if exists carga_papel;");
//        --------------------   TABELAS CRIADAS NA CONEXAO LOCAL --> MySQL
        conexaoServer.getConexaoServer().execute("use eagle_totens;");

//        conexaoServer.getConexaoServer().execute("create table empresa ("
//                + "id_empresa int IDENTITY(10,1) primary key,"
//                + "razao_social varchar(100),"
//                + "cnpj varchar(45),"
//                + "telefone varchar(12)"
//                + ");");
//
//        conexaoServer.getConexaoServer().execute("create table endereco_empresa ("
//                + "id_endereco int IDENTITY(100,1) primary key,"
//                + "logradouro varchar(45),"
//                + "numero varchar(45),"
//                + "cidade varchar(45),"
//                + "uf varchar(45),"
//                + "fk_empresa int,"
//                + "foreign key (fk_empresa) references empresa (id_empresa)"
//                + ");");
//
//        conexaoServer.getConexaoServer().execute("create table estacao ("
//                + "id_estacao int IDENTITY(1000,1) primary key,"
//                + "nome varchar(45),"
//                + "zona varchar(45),"
//                + "status_estacao varchar(10),"
//                + "fk_empresa int,"
//                + "foreign key (fk_empresa) references empresa (id_empresa)"
//                + ");");
//
//        conexaoServer.getConexaoServer().execute("create table colaborador"
//                + "id_colaborador int IDENTITY(20,1) primary key,"
//                + "nome varchar(45),"
//                + "nivel_acesso int,"
//                + "funcao varchar(45),"
//                + "telefone varchar(45),"
//                + "email varchar (45),"
//                + "senha varchar(45),"
//                + "fk_empresa int,"
//                + "foreign key (fk_empresa) references empresa (id_empresa) ("
//                + ");");
//
//        conexaoServer.getConexaoServer().execute("create table externo_lead"
//                + "id_lead int IDENTITY(200,1) primary key,"
//                + "nome varchar (45),"
//                + "email varchar(45),"
//                + "telefone varchar(20),"
//                + "descricao varchar(200)"
//                + ");");
//
//        conexaoServer.getConexaoServer().execute("create table totem"
//                + "id_totem int IDENTITY(30,1) primary key,"
//                + "status_totem boolean,"
//                + "fk_estacao int,"
//                + "foreign key (fk_estacao) references estacao (id_estacao)"
//                + ");");
//
//        conexaoServer.getConexaoServer().execute("create table componente"
//                + "id_componente int IDENTITY(300,1) primary key,"
//                + "tipo varchar(45),"
//                + "modelo varchar(45),"
//                + "marca varchar(45),"
//                + "data_implementada datetime,"
//                + "bobina_cota_total int,"
//                + "memoria_total double,"
//                + "cpu_velocidade_base double,"
//                + "disco_capacidade double"
//                + ");");
//
//        conexaoServer.getConexaoServer().execute("create table carga_papel"
//                + "id_medida_bobina int IDENTITY(40,1) primary key,"
//                + "cotas_disponiveis int,"
//                + "data_hora_medida_bobina datetime,"
//                + "fk_totem int,"
//                + "fk_componente_bobina int,"
//                + "foreign key (fk_totem) references totem (id_totem),"
//                + "foreign key (fk_componente_bobina) references componente (id_componente)"
//                + ");");
        //---------- TABELA MEDIDA_DISCO ----------
//        conexaoServer.getConexaoServer().execute("create table medida_disco ("
//                + "id_medida_disco int IDENTITY primary key ,"
//                + "uso_de_disco double,"
//                + "disco_livre double,"
//                + "data_hora_medida_disco datetime"
//                + ");");
        // ---------- TABELA MEDIDA_CPU ----------
//        conexaoServer.getConexaoServer().execute("create table medida_cpu ("
//                + "id_medida_cpu int IDENTITY primary key,"
//                + "tempo_cpu bigint,"
//                + "processos_cpu double,"
//                + "data_hora_medida_cpu datetime"
//                + ");");
        // ---------- TABELA MEDIDA_MEMORIA ----------
//        conexaoServer.getConexaoServer().execute("create table medida_memoria ("
//                + "id_medida_memoria int PRECISION primary key,"
//                + "uso_ram double,"
//                + "ram_livre double,"
//                + "data_hora_medida_memoria datetime"
//                + ");");
        // ---------------- INSERTS FIXOS --------------------------------
//        conexaoServer.getConexaoServer().update("insert into empresa values (null, \"CPTM SP LTDA\", \"10.108.421/0001-02\", \"56153764\");");
//        conexaoServer.getConexaoServer().update("insert into endereco_empresa values (null, \"Rua das araras\", \"150\", \"São Paulo\", \"SP\", 10);");
//        conexaoServer.getConexaoServer().update("insert into estacao values(null, \"Pinheiros\", \"Sul\",\"Ativo\",1);");
//        conexaoServer.getConexaoServer().update("insert into colaborador values(null, \"Natalia\", 1,\"Gerente\", \"119632845210\", \"natalia@gmail.com\", \"teste123\", 10);");
//        conexaoServer.getConexaoServer().update("insert into externo_lead values(null, \"Teste Lead\", \"lead@gmail.com\", \"119632845210\",  \"teste descrição\");");
//        conexaoServer.getConexaoServer().update("insert into totem values (null, true, 1000);");
//        conexaoServer.getConexaoServer().update("insert into componente values"
//                + "(null, \"cpu\", \"xpto\", \"xpto\", \"2022-10-10 01:24:06\",null,null,10.8,null),"
//                + "(null, \"memoria\", \"xpto\", \"xpto\", \"2022-10-10 01:24:06\",null, 8.5,null,null),"
//                + "(null, \"disco\", \"xpto\", \"xpto\", \"2022-10-10 01:24:06\",null, null,null,20.0),"
//                + "(null, \"bobina\", \"xpto\", \"xpto\", \"2022-10-10 01:24:06\",100, null,null,null);");
//        conexaoServer.getConexaoServer().update("insert carga_papel values (null, 10, \"2022-10-10 01:24:06\", 30, 300);");
        // ------------------------------------------------------------------------------------------------------------------------------    
//        Aqui setamos um timer para que o código execute em loop a cada x segundos e assim capturar os dados da máquina continuamente
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                // ---------- INSERINDO VALORES NA TABELA MEDIDA_DISCO ----------
//                LocalDateTime dataHoraMedidaDisco = ;
                Double usoDeDisco = disco.buscarEspacoOcupadoDisco();
                Double discoLivre = disco.buscarEspacoLivreDisco();

                conexaoServer.getConexaoServer().update("insert into medida_disco values "
                        + "(?, ?, ?);", usoDeDisco, discoLivre, LocalDateTime.now());

                //Listar informações de disco
                List<MedidaDisco> listaDeMedidasDisco = conexaoServer.getConexaoServer().query("select * from "
                        + "medida_disco;", new BeanPropertyRowMapper(MedidaDisco.class));

                // ---------- INSERINDO VALORES NA TABELA MEDIDA_CPU ---------
//                LocalDateTime dataHoraMedidaCpu = cpu.getDataHoraMedidaCpu();
                Long tempoCpu = cpu.buscarFrequenciaCpu();
                Integer processosCpu = cpu.buscarProcessosCpu();

                conexaoServer.getConexaoServer().update("insert into medida_cpu values "
                        + "(?, ?, ?);", tempoCpu, processosCpu, LocalDateTime.now());

                //Listar informações da cpu
                List<MedidaCpu> listaDeMedidaCpu = conexaoServer.getConexaoServer().query("select * from "
                        + "medida_cpu;", new BeanPropertyRowMapper(MedidaCpu.class));

                // ---------- INSERINDO VALORES NA TABELA MEDIDA_MEMORIA ---------
                Double usoRam = memoria.buscarMemoriaEmUso();
                Double ramLivre = memoria.buscarMemoriaDisponivel();
//                LocalDateTime dataHoraMedidaMemoria = memoria.getDataHoraMedidaMemoria();

                conexaoServer.getConexaoServer().update("insert into medida_memoria values "
                        + "(?, ?, ?);", usoRam, ramLivre, LocalDateTime.now());

                //Listar informações da memoria
                List<MedidaMemoria> listaDeMedidaMemoria = conexaoServer.getConexaoServer().query("select * from "
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

    public String verificarUsuario(String email, String senha) {
//        ConexaoBancoSQL conexaoServer = new ConexaoBancoSQL();
        ConexaoBancoServer conexaoServer = new ConexaoBancoServer();

        System.out.println(email + " " + senha);
        List<VerificacaoUsuario> listaUsuario = conexaoServer.getConexaoServer().query("select "
                + "nome, email, senha from colaborador where email = ? and senha = ?",
                new BeanPropertyRowMapper(VerificacaoUsuario.class), email, senha);

        if (!listaUsuario.isEmpty()) {
            return listaUsuario.toString();
        } else {
            return "inexistente";
        }

    }

}
