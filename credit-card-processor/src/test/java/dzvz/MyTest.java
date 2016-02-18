package dzvz;

import dzvz.operations.CreditCardValidator;
import dzvz.operations.OperationException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class MyTest {

    @Test
    public void testValidCCNumers() throws OperationException {
        String [] validCards =  new String[]{"49927398716", "4222222222222", "4012888888881881", "4012888888881881", "5555555555554444", "5105105105105100" , "371449635398431", "378282246310005", "4457000300000007"};
        for (String creditCard : validCards){
            Assert.assertTrue(CreditCardValidator.validate(creditCard));
        }
    }

    @Test
    public void testInValidCCNumers() throws OperationException {
        String [] validCards =  new String[]{"aaaa", "1111111111111111", null, "", "5555a55555554444", "5105105105105103" , "371449635398437", "378282246310002", "1","1234567890123456"};
        for (String creditCard : validCards){
            Assert.assertFalse(CreditCardValidator.validate(creditCard));
        }
    }


}
