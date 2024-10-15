package exceptions;

public class ConfrontarLinhasIguaisException extends RuntimeException {
    public ConfrontarLinhasIguaisException(String message) {
        super(message);
    }

    public ConfrontarLinhasIguaisException() {
        super("Número de linhas iguais");
    }
}
