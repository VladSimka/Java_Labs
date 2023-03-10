package by.vladsimonenko.fourthlab.variantA.exceptions;

public class SimpleFractionException extends Exception {
    public SimpleFractionException() {
    }

    public SimpleFractionException(String message) {
        super(message);
    }

    public SimpleFractionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SimpleFractionException(Throwable cause) {
        super(cause);
    }
}
