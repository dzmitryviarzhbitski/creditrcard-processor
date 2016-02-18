package dzvz.services;

import dzvz.repository.CreditCardRepositoryFactory;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCardServiceFactory {

    public static final CreditCardService INSTANCE = new CreditCardService(CreditCardRepositoryFactory.getInstance());

    public static CreditCardService getInstance(){
        return INSTANCE;
    };
}
