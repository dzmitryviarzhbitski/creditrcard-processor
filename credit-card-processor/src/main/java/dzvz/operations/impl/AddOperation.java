package dzvz.operations.impl;

import dzvz.model.CreditCard;
import dzvz.operations.Operation;
import dzvz.operations.OperationException;
import dzvz.repository.CreditCardRepository;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class AddOperation extends Operation {

    private final String name;
    private final String cardNumber;
    private final Long limit;

    public AddOperation(String name, String cardNumber, Long limit) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.limit = limit;
    }

    @Override
    public void doExecute(CreditCardRepository repository) throws OperationException {
        if (repository.getCreditCard(name) == null){
            repository.addCreditCard(new CreditCard(name, cardNumber, 0L, limit));
        }else {
            throw new OperationException("Credit Card is already existed");
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
