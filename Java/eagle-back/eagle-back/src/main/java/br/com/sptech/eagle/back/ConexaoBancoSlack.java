package br.com.sptech.eagle.back;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author gustavo.caxile
 */
public class ConexaoBancoSlack {
    
    private final BasicDataSource bancoSlack;

    public ConexaoBancoSlack() {

        this.bancoSlack = new BasicDataSource();

        try {

            this.bancoSlack.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.bancoSlack.setUrl("jdbc:sqlserver://eagle-totens.database.windows.net:1433;"
                    + "database=eagle_totens;encrypt=true;trustServerCertificate=false;"
                    + "hostNameInCertificate=*.database.windows.net;");
            this.bancoSlack.setUsername("adminEagleTotens2022");
            this.bancoSlack.setPassword("2ads$grupo9");
        } catch (Exception e) {

            System.out.println(e.getMessage() + "teste");
        }
    }
    
    public BasicDataSource getBancoSlack(){
        
        return bancoSlack;
    }
}
