package exceptions;

public class HeaderInvalidoMaisCaracterPermitidoException extends RuntimeException {
    public HeaderInvalidoMaisCaracterPermitidoException(String message) {
        super(message);
    }

    public HeaderInvalidoMaisCaracterPermitidoException() {
        super("Header inválido");
    }
}
