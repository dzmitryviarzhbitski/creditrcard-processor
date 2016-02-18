package dzvz.operations;

import dzvz.repository.CreditCardRepository;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public interface Operation {
    void execute(CreditCardRepository repository)
}
