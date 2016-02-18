package dzvz.clients;

import dzvz.operations.Operation;
import dzvz.operations.OperationException;
import dzvz.operations.impl.AddOperation;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class AddOperationParser extends OperationParser {

    @Override
    public Operation parse(String... arguments) throws OperationException {

        if (arguments != null && arguments.length == 4) {
            String name = arguments[1];
            String cardNumber = arguments[2];
            String limit = arguments[3];
            AddOperation operation = new AddOperation(name, cardNumber, parseCurrency(limit, "Limit"));
            return operation;
        }

        return null;
    }
}
