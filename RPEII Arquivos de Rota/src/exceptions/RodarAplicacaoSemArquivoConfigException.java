package exceptions;

public class RodarAplicacaoSemArquivoConfigException extends RuntimeException {
    public RodarAplicacaoSemArquivoConfigException(String message) {
        super(message);
    }

    public RodarAplicacaoSemArquivoConfigException() {
        super("Não possui um arquivo config.txt no caminho C:\\Temp\\Configuracao, " +
                "mas a aplicação criará um para você"
        );
    }
}
