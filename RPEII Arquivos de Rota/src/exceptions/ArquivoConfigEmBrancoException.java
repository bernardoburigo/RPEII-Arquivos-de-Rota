package exceptions;

public class ArquivoConfigEmBrancoException extends RuntimeException {
    public ArquivoConfigEmBrancoException(String message) {
        super(message);
    }

    public ArquivoConfigEmBrancoException() {
        super("Não foi possivel continuar pois o seu arquivo config esta em branco, " +
                "mas a aplicação seguirá criando as linhas automaticamente");
    }
}
