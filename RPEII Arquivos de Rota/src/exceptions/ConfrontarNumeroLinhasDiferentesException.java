package exceptions;

public class ConfrontarNumeroLinhasDiferentesException extends RuntimeException {
    public ConfrontarNumeroLinhasDiferentesException(String message) {
        super(message);
    }

    public ConfrontarNumeroLinhasDiferentesException() {
        super("Número de linhas diferentes");
    }
}
