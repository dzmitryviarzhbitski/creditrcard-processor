package dzvz.operations.impl;

import dzvz.model.CreditCard;
import dzvz.operations.Luhn10;
import dzvz.operations.Operation;
import dzvz.operations.OperationException;
import dzvz.repository.CreditCardRepository;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class PrintSummaryOperation extends Operation {

    public PrintSummaryOperation() {
    }

    @Override
    public void doExecute(CreditCardRepository repository) throws OperationException {
        repository.getCreditCardsOrderedByName().stream().forEach(card-> printSummary(card));

    }

    private void printSummary(CreditCard card) {
        if (Luhn10.verify(card.getNumber())){
            System.out.println(String.format("%s: %s", card.getName(), card.getBalance()));
        }else {
            System.out.println(String.format("%s: %s", card.getName(), "error"));
        }
    }

    @Override
    public void validate() throws OperationException {
    }

}
