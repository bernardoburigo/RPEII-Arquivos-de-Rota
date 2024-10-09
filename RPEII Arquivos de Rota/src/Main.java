public class Main {

    public static void main(String[] args) {
        try {
            Functions fileProcessor = new Functions("C:\\Teste", "C:\\Teste\\Configuracao\\config.txt");

            fileProcessor.init();

            fileProcessor.criarArquivosRota(3);  // Exemplo de criação de 3 arquivos

            fileProcessor.processarArquivos();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}