package com.mycompany.projeto.eagle.totens;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;
import java.time.LocalDateTime;

public class MedidaMemoria {

    Looca looca = new Looca();
    Memoria memoria = new Memoria();
    LocalDateTime DateTime = LocalDateTime.now();

    // ----- ATRIBUTOS MEDIDA MEMÓRIA -----
    private Integer idMedidaMemoria;
    private Double usoRam;
    private Double ramLivre;
    private LocalDateTime dataHoraMedidaMemoria;

    // ----- GET & SET -----
    public Integer getIdMedidaMemoria() {
        return idMedidaMemoria;
    }

    public void setIdMedidaMemoria(Integer idMedidaMemoria) {
        this.idMedidaMemoria = idMedidaMemoria;
    }

    public Double getUsoRam() {
        return usoRam;
    }

    public void setUsoRam(Double usoRam) {
        this.usoRam = usoRam;
    }

    public Double getRamLivre() {
        return ramLivre;
    }

    public void setRamLivre(Double ramLivre) {
        this.ramLivre = ramLivre;
    }

    public LocalDateTime getDataHoraMedidaMemoria() {
        return DateTime;
    }

    public void setDataHoraMedidaMemoria(LocalDateTime dataHoraMedidaMemoria) {
        this.dataHoraMedidaMemoria = dataHoraMedidaMemoria;
    }

    // ----- NOSSOS MÉTODOS API LOOCA -----
    // ---------- MEMÓRIA ---------- FALTA CACHE, MEMORIA_TOTAL(COMPONENTE)
    public Double buscarMemoriaEmUso() {
        Double usoRam = longParaDoubleEmUso(memoria.getEmUso());
        return usoRam;
    }

    public Double buscarMemoriaDisponivel() {
        Double ramLivre = longParaFloatMemDisponivel(memoria.getDisponivel());
        return ramLivre;
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

      @Override
    public String toString() {
        return String.format("\n------ Medida Memória ----- \nidMedidaMemoria: %s"
                + "\nUso de RAM: %.2f\nRAM Livre: %.2f\nData Hora Medida do Disco: %s", idMedidaMemoria, usoRam, ramLivre, dataHoraMedidaMemoria);
    }
}
