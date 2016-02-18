package dzvz.operations;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class OperationException extends Exception {

    public final String message;


    public OperationException(String message, Exception e) {
        super(e);
        this.message = message;

    }

    public OperationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
