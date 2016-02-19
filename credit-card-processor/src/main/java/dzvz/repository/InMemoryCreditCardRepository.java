package dzvz.repository;

import dzvz.model.CreditCard;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class InMemoryCreditCardRepository implements CreditCardRepository {

    private final SortedMap<String, CreditCard> cardsRepository = new TreeMap<String, CreditCard>();


    @Override
    public CreditCard getCreditCard(String name) {
        return cardsRepository.get(name);
    }

    @Override
    public CreditCard addCreditCard(CreditCard creditCard) {
        return cardsRepository.put(creditCard.getName(), creditCard);
    }

    @Override
    public List<CreditCard> getCreditCardsOrderedByName() {
        List<CreditCard> cards = new LinkedList<>();
        for (String name : cardsRepository.keySet()){
            cards.add(cardsRepository.get(name));
        }
        return cards;
    }
}
