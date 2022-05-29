package logs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VerificarArquivoExiste {

    public void verificarAquivoLog(String email, String senha, LocalDateTime dataHora) throws IOException {

        //Verificando se o arquivo existe na pasta
        Path arquivo = Paths.get("/home/urubu100/Desktop/mensagens-log.txt");
        File arquivoMensagens = arquivo.toFile();
        if (Files.exists(arquivo)) {
            System.out.println("Arquivo de log existe no desktop");
            popularAqruivoLog(arquivoMensagens, email, senha, dataHora);
        } else {
            System.out.println("Arquivo de log NAO existe no desktop");
            criarArquivoLog(email, senha, dataHora);

        }

    }

    public void criarArquivoLog(String email, String senha, LocalDateTime dataHora) {

        java.io.File arquivoLog = new java.io.File("/home/urubu100/Desktop", "mensagens-log.txt");

        try {
            boolean statusArq = arquivoLog.createNewFile();
            System.out.print("Arquivo de log criado com sucesso!");
            popularAqruivoLog(arquivoLog, email, senha, dataHora);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void popularAqruivoLog(File arquivoLog, String email, String senha, LocalDateTime dataHora) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String diaHora = dataHora.format(formatter);
        String textoLog = String.format("\n"
                + "Senha incorreta digitada!\n"
                + "Email inserido: %s\n"
                + "Senha inserida: %s\n"
                + "Data e hora: %s\n"
                + "--------------------------\n", email, senha, diaHora);

        //construtor que recebe também como argumento se o conteúdo será acrescentado (true)
        FileWriter fw = new FileWriter(arquivoLog, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(textoLog);
        bw.newLine();
        bw.close();
        fw.close();
    }
}
