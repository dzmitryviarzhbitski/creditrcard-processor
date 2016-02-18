package dzvz.clients;

import dzvz.operations.Operation;
import dzvz.operations.OperationException;
import dzvz.operations.Operations;
import dzvz.repository.InMemoryCreditCardRepository;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static dzvz.clients.OperationFactory.getOperation;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCardConsoleClient {


    public static final InMemoryCreditCardRepository REPOSITORY = new InMemoryCreditCardRepository();

    public static void main(String ...s) throws IOException {
        Scanner scanner = isFileNamePassed(s) ? new Scanner(Paths.get(s[0])): new Scanner(System.in);

        List<Operation> operations = new LinkedList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            operations.add(getOperation(line.split(" ")));
            processLine(line);
        }
        try {
            getOperation(new String[]{Operations.SUMMARY.name()}).execute(REPOSITORY);
        } catch (OperationException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFileNamePassed(String[] s) {
        System.out.print(s);
        return s.length == 1 && StringUtils.isNotBlank(s[0]) && Files.exists(Paths.get(s[0]));
    }

    private static void processLine(String line) {
        if (line != null && !line.isEmpty()){
            System.out.println(line);
                Operation operation = getOperation(line);
                operation.execute(REPOSITORY);

        }
    }

}
