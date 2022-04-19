package com.mycompany.loocamodelo;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author gustavo.caxile
 */
public class Exibe {

    Looca looca = new Looca();
    Memoria memoria = new Memoria();
    Processador cpu = new Processador();
    DiscosGroup disco = new DiscosGroup();

    public String capturaDados() throws UnknownHostException {
        
        //Pegando dados da memória RAM em uso
        Float usoRam = longParaFloatMemUso(memoria.getEmUso());    
        Double ramLivre = longParaFloatMemDisponivel(memoria.getDisponivel());
        //Pegando dados do tempo da CPU em uso
        Double tempoCpu = longParaDouble(cpu.getFrequencia());

        //Pegando dados do Disco, para que possamos fazer o cálculo de espaço disponível
        Double discoTotal = longParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal());
        Double discoLivre = longParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
        Integer processosDisco = looca.getGrupoDeProcessos().getTotalProcessos();

        //Cálculo para coletar o uso de disco
        Double usoDeDisco = discoTotal - discoLivre;

        //Coleta de dados do Nome e IP da máquina
        String ipMaquina = InetAddress.getLocalHost().getHostAddress();
        String nomeMaquina = InetAddress.getLocalHost().getHostName();

        String dadosFormatados = String.format("Dados da máquina:\n\n"
                + "Nome da máquina: %s\n"
                + "IP: %s\n\n"
                + "Uso da RAM: %.2f GB\n"
                + "RAM livre: %.2f GB\n"
                + "Frequência da CPU: %.1f GHz\n"
                + "Uso de disco: %.2f GB\n"
                + "Memória disponível: %.2f GB\n"
                + "Processos em execução: %d\n",
                nomeMaquina, ipMaquina, usoRam, ramLivre, tempoCpu, usoDeDisco, discoLivre, processosDisco);

        System.out.println(dadosFormatados);
        return dadosFormatados;
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
        String valorConvertido = Conversor.formatarBytes(valorLong);
        return converted;
    }
    
    public Float longParaFloatMemUso(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);       
        String valorString = valorConvertido.replace(",", ".");       
        valorString = valorString.replace("GiB", "");       
        Float valorFloat = Float.parseFloat(valorString);     
        return valorFloat;
    }
}
