package exceptions;

public class HeaderInvalidoNNException extends RuntimeException {
    public HeaderInvalidoNNException(String message) {
        super(message);
    }

    public HeaderInvalidoNNException() {
        super("Número totais de nós inválido");
    }
}
