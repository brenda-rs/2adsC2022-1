package com.mycompany.projeto.eagle.totens;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoBancoSQLServer {

    public class ConexaoBancoSQL {

        private JdbcTemplate conexaoServer;

        //Método para conexão com o banco;
        public ConexaoBancoSQL() {
            //Vem da biblioteca apache e é uma forma simplificada de fazer uma conexão com um banco de dados.
            BasicDataSource dataSource = new BasicDataSource();

            //Driver do banco que quero conectar --> SQL Server
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //Bancos relacionais têm uma string de conexão, qual banco estou usando: SQL Server, 
            //a url, nome do servidor, porta do servidor, nome do banco de dados.
            dataSource​.setUrl("jdbc:sqlserver://meubanco.database.windows.net/eagle_totens");
//                    Tentar utilizar o Timezone
//                    + "?useTimezone=true&serverTimezone=America/Sao_Paulo");

            dataSource​.setUsername("root");

            dataSource​.setPassword("urubu100");

            conexaoServer = new JdbcTemplate(dataSource);
        }

        public JdbcTemplate getConexaoServer() {
            return conexaoServer;
        }
    }

}
