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

    

    public Long buscarFrequenciaCpu() {
        Long tempoCpu = cpu.getFrequencia();
        return tempoCpu;
    }

    public Double buscarMemoriaEmUso() {
        Double usoRam = longParaDoubleEmUso(memoria.getEmUso());

        return usoRam;
    }

    public Double buscarMemoriaDisponivel(String id_totem) {

        Double ramTotal = longParaDouble(memoria.getTotal());
        Double ramLivre = longParaFloatMemDisponivel(memoria.getDisponivel());
        Double ramUso = longParaDouble(memoria.getEmUso());
        Integer fk_totem = Integer.parseInt(id_totem);
        Slack slack = new Slack(1002, fk_totem);     
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

    public Double buscarEspacoOcupadoDisco(String id_totem) {
        Double discoTotal = longParaDoubleDisco(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal());
        Double discoLivre = longParaDoubleDisco(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
        Double usoDeDisco = discoTotal - discoLivre;
        Integer fk_totem = Integer.parseInt(id_totem);
        Slack slack = new Slack(1002, fk_totem);
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
        Double discoLivre = longParaDoubleDisco(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
        return discoLivre;
    }
    
    public Double buscarUsoCpu(String id_totem){
        
        Double usoCpu = looca.getProcessador().getUso();
        Integer fk_totem = Integer.parseInt(id_totem);
        Slack slack = new Slack(1002, fk_totem);
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
        valorString = valorString.replace("MiB", "");
        valorString = valorString.replace("GiB", "");
        Double valorDouble = Double.parseDouble(valorString);
        return valorDouble;
    }
    
    public double longParaDoubleDisco(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        valorString = valorString.replace("MiB", "");
        Double valorDouble = Double.parseDouble(valorString);
        return valorDouble;
    }

    //Convertendo long para integer
    public Integer longParaInteger(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        valorString = valorString.replace("MiB", "");
        Integer valorInteger = Integer.parseInt(valorString);
        return valorInteger;
    }

    //Convertendo long para float
    public Double longParaFloatMemDisponivel(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        valorString = valorString.replace("MiB", "");
        Double converted = Double.parseDouble(valorString);
        return converted;
    }

    public Double longParaDoubleEmUso(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        valorString = valorString.replace("MiB", "");
        Double converted = Double.parseDouble(valorString);
        return converted;
    }
}
