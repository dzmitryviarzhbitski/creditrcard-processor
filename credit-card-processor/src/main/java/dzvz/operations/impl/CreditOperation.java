package dzvz.operations.impl;

import dzvz.model.CreditCard;
import dzvz.operations.Luhn10;
import dzvz.operations.Operation;
import dzvz.operations.OperationException;
import dzvz.repository.CreditCardRepository;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditOperation extends Operation {

    private final String name;
    private final Long amount;

    public CreditOperation(String name, Long amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void doExecute(CreditCardRepository repository) throws OperationException {
            CreditCard creditCard = repository.getCreditCard(name);
            if (creditCard != null){
                if (Luhn10.verify(creditCard.getNumber())) {
                    Long newBalance = creditCard.getBalance() - amount;
                    creditCard.setBalance(newBalance);
                }
            }
    }

    @Override
    public void validate() throws OperationException {
//        if (isEmpty(name)){
//            throw new OperationException("'Name'is mandatory. Please provide name");
//        }
//        if (Luhn10.verify(cardNumber)){
//            throw new OperationException("Valid 'Card Number' should be provided");
//        }
//        if (limit == null){
//            throw new OperationException("'Card Limit' is mandatory. Please provide 'Card Limit'");
//        }

    }

}
