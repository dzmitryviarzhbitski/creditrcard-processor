package dzvz.clients;

import dzvz.operations.Operation;
import dzvz.operations.OperationException;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public abstract class OperationParser {
    public abstract Operation parse(String... arguments);

    protected Long parseCurrency(String input) throws OperationException {
        return Long.parseLong(input.substring(1, input.length()));
    }
}
