package exceptions;

public class HeaderInvalidoSPException extends RuntimeException {
    public HeaderInvalidoSPException(String message) {
        super(message);
    }

    public HeaderInvalidoSPException() {
        super("Soma dos pesos difere (Valor do Registro HEADER = NN e Soma dos Pesos = NN)");
    }
}
