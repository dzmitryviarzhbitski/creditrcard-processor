package dzvz.operations;

import dzvz.repository.CreditCardRepository;
import dzvz.repository.CreditCardRepositoryFactory;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public abstract class Operation {
    public void execute(){
        execute(CreditCardRepositoryFactory.getInstance());
    }
    public abstract void execute(CreditCardRepository repository);
}
