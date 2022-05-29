package br.com.sptech.eagle.back;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author gustavo.caxile
 */
public class TesteSlack {
 
    public static void main(String[] args) throws IOException, InterruptedException, Exception {

        Slack s = new Slack(1002, 32);

        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        String datetime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dataDeHoje.getTime());
        
        BuscarMedidas busc = new BuscarMedidas();
        
        System.out.println(busc);

        s.alertaMapeamento("teste", datetime);
    }
}
