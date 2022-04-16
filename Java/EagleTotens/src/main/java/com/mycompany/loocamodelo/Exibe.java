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

    public void capturaDados() throws UnknownHostException {

        //Pegando dados da memória RAM em uso
        Float usoRam = LongParaFloat(memoria.getEmUso());
        Float ramLivre = LongParaFloat(memoria.getDisponivel());

        //Pegando dados do tempo da CPU em uso
        Float tempoCpu = LongParaFloat(cpu.getFrequencia());

        //Pegando dados do Disco, para que possamos fazer o cálculo de espaço disponível
        Float discoTotal = LongParaFloat(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal());
        Float discoLivre = LongParaFloat(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
        Integer processosDisco = looca.getGrupoDeProcessos().getTotalProcessos();

        //Cálculo para coletar o uso de disco
        Float usoDeDisco = discoTotal - discoLivre;

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
    }

    //Convertendo long para double
    public double LongParaDouble(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        double valorDouble = Double.parseDouble(valorString);

        return valorDouble;
    }

    //Convertendo long para integer
    public Integer LongParaInteger(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        Integer valorInteger = Integer.parseInt(valorString);

        return valorInteger;
    }

    //Convertendo long para float
    public Float LongParaFloat(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        Float valorFloat = Float.parseFloat(valorString);

        return valorFloat;
    }
}
