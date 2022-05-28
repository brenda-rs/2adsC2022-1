package br.com.sptech.eagle.back;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author gustavo.caxile
 */
public class BuscarMedidas {
    
    Looca looca = new Looca();
    Memoria memoria = new Memoria();
    Processador cpu = new Processador();
    DiscosGroup disco = new DiscosGroup();

    private Slack slack = new Slack(1002, 32);

    public Long buscarFrequenciaCpu() {
        Long tempoCpu = cpu.getFrequencia();
        return tempoCpu;
    }

    public Double buscarMemoriaEmUso() {
        Double usoRam = longParaDoubleEmUso(memoria.getEmUso());

        return usoRam;
    }

    public Double buscarMemoriaDisponivel() {

        Double ramTotal = longParaDouble(memoria.getTotal());
        Double ramLivre = longParaFloatMemDisponivel(memoria.getDisponivel());
        Double ramUso = longParaDouble(memoria.getEmUso());
        
        System.out.println(ramTotal + "teste");
        
        Double alertRam = ramTotal * 0.6;
        Double criticRam = ramTotal * 0.8;
        
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        String datetime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dataDeHoje.getTime());

        if (ramUso >= alertRam && ramUso <= criticRam){

            slack.alertaMapeamento(":warning: ALERTA :warning:\nUso de memória RAM acima de 70%", datetime);
        }
        
        if (ramUso > criticRam) {

            slack.alertaMapeamento(":sos: URGENTE :sos:\nUso de memória RAM acima de 80%", datetime);
        }

        return ramLivre;
    }

    public Double buscarEspacoOcupadoDisco() {
        Double discoTotal = longParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal());
        Double discoLivre = longParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
        Double usoDeDisco = discoTotal - discoLivre;
        
        Double alertDisco = discoTotal * 0.7;
        Double criticDisco = discoTotal * 0.85;

        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        String datetime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dataDeHoje.getTime());

        if (usoDeDisco >= alertDisco || usoDeDisco <= criticDisco) {

            slack.alertaMapeamento(":warning: ALERTA :warning:\nUso de Disco acima de 70%", datetime);
        } else if (usoDeDisco > criticDisco) {

            slack.alertaMapeamento(":sos: URGENTE :sos:\nUso de Disco acima de 85%", datetime);
        }

        return usoDeDisco;
    }

    public Double buscarEspacoLivreDisco() {
        Double discoLivre = longParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
        return discoLivre;
    }
    
    public Double buscarUsoCpu(){
        
        Double usoCpu = looca.getProcessador().getUso();
        
        Double calcCpuAlert = 100 * 0.7;
        Double calcCpuCritical = 100 * 0.85;
        
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        String datetime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dataDeHoje.getTime());

        if (usoCpu >= calcCpuAlert || usoCpu <= calcCpuCritical) {

            slack.alertaMapeamento(":warning: ALERTA :warning:\nUso da CPU acima de 70%", datetime);
        } else if (usoCpu > calcCpuCritical) {

            slack.alertaMapeamento(":sos: URGENTE :sos:\nUso da CPU acima de 70%", datetime);
        }
        
        return usoCpu;
    }

    public Integer buscarProcessosCpu() {

        Integer processosCpu = looca.getGrupoDeProcessos().getTotalProcessos();
        return processosCpu;
    }

    public String buscarIpMaquina() throws UnknownHostException {
        String IpMaquina = InetAddress.getLocalHost().getHostAddress();
        System.out.println(IpMaquina);
        return IpMaquina;
    }

    //Convertendo long para double
    public double longParaDouble(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        double valorDouble = Double.parseDouble(valorString);
        return valorDouble;
    }

    //Convertendo long para integer
    public Integer longParaInteger(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        Integer valorInteger = Integer.parseInt(valorString);
        return valorInteger;
    }

    //Convertendo long para float
    public Double longParaFloatMemDisponivel(Long valorLong) {
        double converted = (double) valorLong;
        return converted;
    }

    public Double longParaDoubleEmUso(Long valorLong) {
        double converted = (double) valorLong;
        return converted;
    }
}
