import exceptions.ArquivoConfigEmBrancoException;
import exceptions.RodarAplicacaoSemCriarDiretorioException;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Functions {
    private final String pastaPrincipal;
    private final String configFile;
    private String pastaProcessado;
    private String pastaNaoProcessado;

    
    public Functions(String pastaPrincipal, String configFile) {
        this.pastaPrincipal = pastaPrincipal;
        this.configFile = configFile;
    }

    public void init() throws IOException {
        lerConfigECreateDirs();
    }
    

    private void lerConfigECreateDirs() throws IOException {
        Path configPath = Paths.get(configFile);

        if (!Files.exists(configPath)) {
            throw new RodarAplicacaoSemCriarDiretorioException();
        }

        List<String> linhasConfig = Files.readAllLines(Paths.get(configFile));

        if (linhasConfig.isEmpty() || linhasConfig.get(0).trim().isEmpty() || linhasConfig.get(1).trim().isEmpty()) {
            throw new ArquivoConfigEmBrancoException();
        }

        this.pastaProcessado = linhasConfig.get(0).split("=")[1];
        this.pastaNaoProcessado = linhasConfig.get(1).split("=")[1];

        Files.createDirectories(Paths.get(pastaProcessado));
        Files.createDirectories(Paths.get(pastaNaoProcessado));
    }

    public void criarArquivosRota(int quantidade) throws IOException {
        AtomicInteger contador = new AtomicInteger(1);
        for (int i = 0; i < quantidade; i++) {
            String nomeArquivo = String.format("rota%02d.txt", contador.getAndIncrement());
            Path caminhoArquivo = Paths.get(pastaPrincipal, nomeArquivo);

            try (BufferedWriter writer = Files.newBufferedWriter(caminhoArquivo)) {
                writer.write("HEADER\n");
                writer.write(String.format("00%02dSP\n", contador.get()));
                writer.write("RESUMO DE CONEXOES\n");
                writer.write("01A=B\n");
                writer.write("01C=D\n");
                writer.write("RESUMO DOS PESOS\n");
                writer.write("02A;B=10\n");
                writer.write("02C;D=20\n");
                writer.write(String.format("TRAILER\n09RC=%02d;RP=%02d;P", contador.get(), contador.get()));
            }
        }
    }

    public void processarArquivos() {
        File pastaPrincipalDir = new File(pastaPrincipal);
        File[] arquivosRota = pastaPrincipalDir.listFiles((dir, name) -> name.matches("rota\\d{2}\\.txt"));

        if (arquivosRota != null) {
            for (File arquivo : arquivosRota) {
                try {
                    System.out.println("Processando arquivo: " + arquivo.getName());

                    moverArquivo(arquivo.toPath(), Paths.get(pastaProcessado, arquivo.getName()));
                    System.out.println("Arquivo processado com sucesso: " + arquivo.getName());

                } catch (Exception e) {
                    try {
                        moverArquivo(arquivo.toPath(), Paths.get(pastaNaoProcessado, arquivo.getName()));
                        System.err.println("Erro ao processar arquivo: " + arquivo.getName() + ". Movido para 'Não Processado'");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
    }
    

    private void moverArquivo(Path origem, Path destino) throws IOException {
        Files.move(origem, destino, StandardCopyOption.REPLACE_EXISTING);
    }
}
