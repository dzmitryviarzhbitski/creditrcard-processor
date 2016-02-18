package dzvz.clients;

import dzvz.operations.Operation;
import dzvz.operations.Operations;

import java.util.EnumMap;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class OperationFactory {

    private final static EnumMap<Operations, OperationParser> parsers = new EnumMap<Operations, OperationParser>(Operations.class);

    static {
        parsers.put(Operations.ADD, new AddOperationParser());
        parsers.put(Operations.CHARGE, new ChargeOperationParser());
        parsers.put(Operations.CREDIT, new CreditOperationParser());
        parsers.put(Operations.SUMMARY, new SummaryOperationParser());
    }

    public static Operation getOperation(String... arguments) {
        Operations operations = Operations.safeValueOf(arguments[0]);
        OperationParser operation = parsers.get(operations);
        return operation.parse(arguments);
    }
}

