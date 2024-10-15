package exceptions;

public class ArquivoValidoException extends RuntimeException {
    public ArquivoValidoException(String message) {
        super(message);
    }

    public ArquivoValidoException(){
        super("Arquivo processado com sucesso e movido para a pasta Processado.");
    }
}
