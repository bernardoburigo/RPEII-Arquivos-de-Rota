package exceptions;

public class SubstituicaoCaracterException extends RuntimeException {
    public SubstituicaoCaracterException(String message) {
        super(message);
    }

    public SubstituicaoCaracterException() {
      super("Não foi possível substituir o '=' por outro caracter");
    }
}
