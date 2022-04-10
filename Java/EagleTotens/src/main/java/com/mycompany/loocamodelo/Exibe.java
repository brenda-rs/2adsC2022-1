package com.mycompany.loocamodelo;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;

/**
 *
 * @author gustavo.caxile
 */
public class Exibe {

    Looca looca = new Looca();
    Memoria memoria = new Memoria();
    Processador cpu = new Processador();
    DiscosGroup disco = new DiscosGroup();
    
    public void capturaDados(){
        
        //Pegando dados da memória RAM em uso
        Float usoRam = LongParaFloat(memoria.getEmUso());
        
        //Pegando dados do tempo da CPU em uso
        Float tempoCpu = LongParaFloat(cpu.getFrequencia());
        
        //Pegando dados do Disco, para que possamos fazer o cálculo de espaço disponível
        Float discoTotal = LongParaFloat(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal());
        Float discoLivre = LongParaFloat(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
        
        Float usoDeDisco = discoTotal - discoLivre;
        
        String dadosFormatados = String.format("Dados da máquina:\n"
                + "Uso da RAM: %.2f GB\n"
                + "Frequência da CPU: %.1f GHz\n"
                + "Uso de disco: %.2f GB\n"
                + "Memória disponível: %.2f GB",
                usoRam, tempoCpu, usoDeDisco, discoLivre);
        
        System.out.println(dadosFormatados);
    }
    
    public double LongParaDouble(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        double valorDouble = Double.parseDouble(valorString);

        return valorDouble;
    }

    public Integer LongParaInteger(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        Integer valorInteger = Integer.parseInt(valorString);

        return valorInteger;
    }

    public Float LongParaFloat(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        Float valorFloat = Float.parseFloat(valorString);

        return valorFloat;
    }
}
