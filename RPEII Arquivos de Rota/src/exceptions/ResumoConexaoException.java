package exceptions;

public class ResumoConexaoException extends RuntimeException {
    public ResumoConexaoException(String message) {
        super(message);
    }

    public ResumoConexaoException() {
        super("Resumo de conexão inválido");
    }
}
