package by.vladsimonenko.thirdlab.variantC.exception;


/**
 * Class - exception for BoolMatrix
 */
public class BoolMatrixException extends Exception {
    public BoolMatrixException() {
        super();
    }

    public BoolMatrixException(String message) {
        super(message);
    }

    public BoolMatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoolMatrixException(Throwable cause) {
        super(cause);
    }
}
