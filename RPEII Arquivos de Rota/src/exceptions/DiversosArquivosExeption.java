package exceptions;

public class DiversosArquivosExeption extends RuntimeException {
    public DiversosArquivosExeption(String message) {
        super(message);
    }

    public DiversosArquivosExeption() {
        super("O programa deverá rodar novamente");
    }
}
