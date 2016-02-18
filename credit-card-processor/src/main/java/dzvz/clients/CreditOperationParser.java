package dzvz.clients;

import dzvz.operations.Operation;
import dzvz.operations.OperationException;
import dzvz.operations.impl.CreditOperation;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
class CreditOperationParser extends OperationParser {

    @Override
    public Operation parse(String... arguments) throws OperationException {

        if (arguments != null && arguments.length == 3) {
            String name = arguments[1];
            String amount = arguments[2];
            Operation operation = new CreditOperation(name, parseCurrency(amount, "amount"));
            return operation;
        }

        return null;
    }
}
