package dzvz.repository;

import dzvz.model.CreditCard;

import java.util.List;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public interface CreditCardRepository {

    CreditCard getCreditCard(String name);

    CreditCard addCreditCard(CreditCard creditCard);

    List<CreditCard> getCreditCardsOrderedByName();

}
