package com.mycompany.projeto.eagle.totens;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import java.time.LocalDateTime;

public class MedidaCpu {

    Looca looca = new Looca();
    Processador cpu = new Processador();
    LocalDateTime DateTime = LocalDateTime.now();

    // ----- ATRIBUTOS MEDIDA CPU -----
    private Integer idMedidaCpu;
    private Long tempoCpu;
    private Integer processosCpu;
    private LocalDateTime dataHoraMedidaCpu;

    // ----- GET & SET -----
    public Integer getIdMedidaCpu() {
        return idMedidaCpu;
    }

    public void setIdMedidaCpu(Integer idMedidaCpu) {
        this.idMedidaCpu = idMedidaCpu;
    }

    public Long getTempoCpu() {
        return tempoCpu;
    }

    public void setTempoCpu(Long tempoCpu) {
        this.tempoCpu = tempoCpu;
    }

    public Integer getProcessosCpu() {
        return processosCpu;
    }

    public void setProcessosCpu(Integer processosCpu) {
        this.processosCpu = processosCpu;
    }

    public LocalDateTime getDataHoraMedidaCpu() {
        return DateTime;
    }

    public void setDataHoraMedidaCpu(LocalDateTime dataHoraMedidaCpu) {
        this.dataHoraMedidaCpu = dataHoraMedidaCpu;
    }

    // ----- NOSSOS MÉTODOS API LOOCA -----
    // ---------- CPU ---------- FALTA CPU_VELOCIDADE_BASE(COMPONENTE)
    // Por que não usa valor decimal (Double) --> Ex. 2,20 GHz ??
    public Long buscarFrequenciaCpu() {
        Long tempoCpu = cpu.getFrequencia();
        return tempoCpu;
    }

    public Integer buscarProcessosCpu() {
        Integer processosCpu = looca.getGrupoDeProcessos().getTotalProcessos();
        return processosCpu;
    }
//    
//     //Convertendo long para double
//    public double longParaDouble(Long valorLong) {
//        String valorConvertido = Conversor.formatarBytes(valorLong);
//        String valorString = valorConvertido.replace(",", ".");
//        valorString = valorString.replace("GiB", "");
//        double valorDouble = Double.parseDouble(valorString);
//        return valorDouble;
//    }
//
//    //Convertendo long para integer
//    public Integer longParaInteger(Long valorLong) {
//        String valorConvertido = Conversor.formatarBytes(valorLong);
//        String valorString = valorConvertido.replace(",", ".");
//        valorString = valorString.replace("GiB", "");
//        Integer valorInteger = Integer.parseInt(valorString);
//        return valorInteger;
//    }
//
//    //Convertendo long para float
//    public Double longParaFloatMemDisponivel(Long valorLong) {
//        double converted = (double) valorLong;
//        return converted;
//    }
//
//    public Double longParaDoubleEmUso(Long valorLong) {
//        double converted = (double) valorLong;
//        return converted;
//    }

    // ----- .toString() -----
        @Override
    public String toString() {
        return String.format("\n------ Medida CPU ----- \nidMedidaCpu: %s"
                + "\nTempo CPU: %s\nProcessos: %s\nData Hora Medida da CPU: %s", idMedidaCpu, tempoCpu, processosCpu, dataHoraMedidaCpu);
    }

}
