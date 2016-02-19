package dzvz;

import dzvz.clients.CreditCardConsoleClient;
import dzvz.model.CreditCard;
import dzvz.services.CreditCardValidator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static dzvz.clients.Operations.parseCurrency;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCardBalanceTrackerTest {

    @Test
    public void testValidCCNumers(){
        String [] validCards =  new String[]{"49927398716", "4222222222222", "4012888888881881", "4012888888881881", "5555555555554444", "5105105105105100" , "371449635398431", "378282246310005", "4457000300000007"};
        for (String creditCard : validCards){
            Assert.assertTrue(CreditCardValidator.validate(creditCard));
        }
    }

    @Test
    public void testInValidCCNumers(){
        String [] validCards =  new String[]{"aaaa", "1111111111111111", null, "", "5555a55555554444", "5105105105105103" , "371449635398437", "378282246310002", "1","1234567890123456"};
        for (String creditCard : validCards){
            Assert.assertFalse(CreditCardValidator.validate(creditCard));
        }
    }

    @Test
    public void testOverdraftProtection(){
        validate("overdraft_protection_test.txt", "overdraft_protection_test_result.txt");
    }

    @Test
    public void testOperationsAgainstInvalid(){
        validate("test_wrong_numbers_test.txt", "test_wrong_numbers_test_result.txt");
    }

    @Test
    public void testNegative(){
        validate("test_negative_charges_test.txt",  "test_negative_charges_test_result.txt");
    }


    @Test
    public void testBaseSample(){
        validate("base_test.txt",  "base_test_result.txt");
    }

    private void validate(String inputPath, String expectedResultPath) {
        CreditCardConsoleClient client = new CreditCardConsoleClient();
        client.processRequest(new String[]{getAbsolutePath(inputPath)});
        List<CreditCard> cards = client.getService().getAllCreditCardsOrderedByName();
        Map<String, CreditCard> expectedResults = parserResults(expectedResultPath);
        Assert.assertTrue(!expectedResults.isEmpty());
        Assert.assertEquals(cards.size(), expectedResults.size());
        cards.stream().forEach(card-> Assert.assertEquals(expectedResults.get(card.getName()), card));
    }

    private String getAbsolutePath(String fileName) {
        return getClass().getClassLoader().getResource(fileName).getPath();
    }

    public Map<String, CreditCard> parserResults(String resultPath){
        String path = getAbsolutePath(resultPath);
        Map<String, CreditCard> cards = new HashMap<>();
        try (Scanner scanner = getScanner(path)){
           while (scanner.hasNextLine()){
               String line = scanner.nextLine();
               String[] data = line.split(" ");
               CreditCard card = CreditCard.newCreditCard(data[0], data[1], parseCurrency(data[2]),  parseCurrency(data[3]), Boolean.valueOf(data[4]));
               card.setBalance(parseCurrency(data[3]));
               cards.put(card.getName(), card);
           }
        }
        return cards;
    }

    private Scanner getScanner(String path){
        try {
            return new Scanner(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
