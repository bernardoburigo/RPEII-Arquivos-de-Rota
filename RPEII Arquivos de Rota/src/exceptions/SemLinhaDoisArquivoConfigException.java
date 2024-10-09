package exceptions;

public class SemLinhaDoisArquivoConfigException extends RuntimeException {
    public SemLinhaDoisArquivoConfigException(String message) {
        super(message);
    }

    public SemLinhaDoisArquivoConfigException() {
        super("Houve um erro ao continua executando o programa, linha 2 no arquivo config não existe, " +
                "mas a aplicação irá criar um para você");
    }
}
