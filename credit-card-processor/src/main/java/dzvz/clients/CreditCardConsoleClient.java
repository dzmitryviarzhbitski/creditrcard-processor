package dzvz.clients;

import dzvz.repository.InMemoryCreditCardRepository;
import dzvz.services.CreditCardService;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static dzvz.clients.Operations.getOperationByName;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCardConsoleClient {

    private final CreditCardService service = new CreditCardService(new InMemoryCreditCardRepository());

    public static void main(String ...s){
        CreditCardConsoleClient client = new CreditCardConsoleClient();
        client.processRequest(s);
    }

    public void processRequest(String ...s){
        Path source = Paths.get(s[0]);
        try (Scanner scanner = getScanner(source, s);){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                processLine(service, line);
            }
            processLine(service, Operations.SUMMARY.name());
        }
    }

    private static Scanner getScanner(Path source, String[] s){
        if (isFileNamePassed(s)){
            try {
                return new Scanner(source);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            return new Scanner(System.in);
        }
    }

    private static boolean isFileNamePassed(String[] s) {
        return s.length == 1 && StringUtils.isNotBlank(s[0]) && Files.exists(Paths.get(s[0]));
    }

    public static void processLine(CreditCardService creditCardService, final String line){
        String[] arguments = line.split(" ");
        String operationName = arguments[0];
        getOperationByName(operationName).execute(creditCardService, arguments);
    }

    public CreditCardService getService() {
        return service;
    }
}
