package dzvz.clients;

import dzvz.operations.Operation;
import dzvz.operations.OperationException;
import dzvz.operations.impl.PrintSummaryOperation;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class SummaryOperationParser extends OperationParser {

    @Override
    public Operation parse(String... arguments) throws OperationException {
        return new PrintSummaryOperation();
    }
}
