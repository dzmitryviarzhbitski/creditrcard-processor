package dzvz.operations;

import dzvz.model.CreditCard;
import dzvz.services.CreditCardServiceFactory;

import java.util.stream.Stream;

import static dzvz.model.CreditCard.newCreditCard;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public enum Operations {
  ADD {
    @Override
    public void execute(String... arguments) {
      if (arguments != null && arguments.length == 4) {
        String name = arguments[1];
        String cardNumber = arguments[2];
        String limit = arguments[3];
        CreditCardServiceFactory.getInstance().addCreditCard(newCreditCard(name, cardNumber, parseCurrency(limit)));
      }

    }
  },
  CHARGE {
    @Override
    public void execute(String... arguments) {
      if (arguments != null && arguments.length == 3) {
        String name = arguments[1];
        String amount = arguments[2];
        CreditCardServiceFactory.getInstance().chargeCreditCard(name, parseCurrency(amount));
      }

    }
  },
  CREDIT {
    @Override
    public void execute(String... arguments) {
      if (arguments != null && arguments.length == 3) {
        String name = arguments[1];
        String amount = arguments[2];
        CreditCardServiceFactory.getInstance().creditCreditCard(name, parseCurrency(amount));
      }

    }
  },
  SUMMARY {
    @Override
    public void execute(String... arguments) {
      CreditCardServiceFactory.getInstance().getAllCreditCardsOrderedByName().stream().forEach(card-> printSummary(card));
    }
    private void printSummary(CreditCard card) {
      if (CreditCardValidator.validate(card.getNumber())){
        System.out.println(String.format("%s: %s", card.getName(), card.getBalance()));
      }else {
        System.out.println(String.format("%s: %s", card.getName(), "error"));
      }
    }
  };


  public static Operations getOperationByName(String operationName) {
    return Stream.of(Operations.values()).filter(v-> v.name().equalsIgnoreCase(operationName)).findFirst().orElseGet(null);
  }


  public abstract void execute(String ...s);

  protected Long parseCurrency(String input){
    return Long.parseLong(input.substring(1, input.length()));
  }

}
