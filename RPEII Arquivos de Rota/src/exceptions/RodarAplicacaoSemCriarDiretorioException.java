package exceptions;

public class RodarAplicacaoSemCriarDiretorioException extends RuntimeException {
    public RodarAplicacaoSemCriarDiretorioException(String message) {
        super(message);
    }

    public RodarAplicacaoSemCriarDiretorioException() {
        super("A aplicação não deixará seguir o fluxo ou então seguirá criando os " +
              "diretórios automaticamente nos caminhos C:\\Teste e C:\\Teste\\Configuracao");
    }
}
