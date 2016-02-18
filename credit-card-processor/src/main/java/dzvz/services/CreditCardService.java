package dzvz.services;

import dzvz.model.CreditCard;
import dzvz.operations.CreditCardValidator;
import dzvz.repository.CreditCardRepository;

import java.util.List;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCardService {

    private final CreditCardRepository repository;

    public CreditCardService(CreditCardRepository repository) {
        this.repository = repository;
    }


    public void addCreditCard(CreditCard creditCard){
        if (repository.getCreditCard(creditCard.getName()) == null){
            repository.addCreditCard(creditCard/*new CreditCard(name, cardNumber, 0L, limit)*/);
        }else {
            throw new RuntimeException("Credit Card is already existed");
        }
    }

    public void chargeCreditCard(String name, Long amount){
        CreditCard creditCard = repository.getCreditCard(name);
        if (creditCard != null) {
            if (validateCreditCard(creditCard)) {
                Long newBalance = creditCard.getBalance() + amount;
                if (newBalance < creditCard.getLimit()) {
                    creditCard.setBalance(newBalance);
                }
            }
        }
    }

    public void creditCreditCard(String name, Long amount){
        CreditCard creditCard = repository.getCreditCard(name);
        if (creditCard != null) {
            if (validateCreditCard(creditCard)) {
                Long newBalance = creditCard.getBalance() - amount;
                creditCard.setBalance(newBalance);
            }
        }
    }

    public List<CreditCard> getAllCreditCardsOrderedByName(){
        return repository.getCreditCardsOrderedByName();
    }

    public boolean validateCreditCard(CreditCard creditCard){
        return new CreditCardValidator().validate(creditCard.getNumber());
    }


}
