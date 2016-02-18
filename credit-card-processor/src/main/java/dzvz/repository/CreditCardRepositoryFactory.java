package dzvz.repository;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCardRepositoryFactory {

    private static final CreditCardRepository INSTANCE = new InMemoryCreditCardRepository();

    public static CreditCardRepository getInstance(){
        return INSTANCE;
    }
}
