package com.mycompany.loocamodelo;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;

/**
 *
 * @author gustavo.caxile
 */
public class Exibe {

    public static void main(String[] args) {

        Looca looca = new Looca();
        
        //Criação do gerenciador
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        
        //Obtendo memória a partir do getter
        Memoria memoria = looca.getMemoria();
        
        //Obtendo lista de sistemas a partir do getter
        Sistema sistema = looca.getSistema();

        //Obtendo lista de discos a partir do getter
        List<Disco> discos = grupoDeDiscos.getDiscos();
        
        //Obtendo lista de ram a partir do getter
        Long memoriaRamDisp = memoria.getDisponivel();
        Long memoriaRamEmUso = memoria.getEmUso();
        Long memoriaRamTotal = memoria.getTotal();
        
        discos.forEach(element -> {
            
            //System.out.println(element);
        });
        
        System.out.println(memoriaRamDisp);
        System.out.println(memoriaRamEmUso);
        System.out.println(memoriaRamTotal);
        System.out.println(sistema);
        System.out.println(memoria);
    }
}
