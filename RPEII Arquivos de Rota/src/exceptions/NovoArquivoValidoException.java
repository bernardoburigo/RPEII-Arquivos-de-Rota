package exceptions;

public class NovoArquivoValidoException extends RuntimeException {
    public NovoArquivoValidoException(String message) {
        super(message);
    }

    public NovoArquivoValidoException() {
        super("O arquivo deve ser processado com sucesso e movido para a pasta Processado após 10 segundos.");
    }
}
