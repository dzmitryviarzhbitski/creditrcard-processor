package dzvz.clients;

import dzvz.operations.Operations;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static dzvz.operations.Operations.getOperationByName;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCardConsoleClient {

    public static void main(String ...s) throws IOException {
        Scanner scanner = isFileNamePassed(s) ? new Scanner(Paths.get(s[0])): new Scanner(System.in);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            processLine(line);
        }
        processLine(Operations.SUMMARY.name());

    }

    private static boolean isFileNamePassed(String[] s) {
        return s.length == 1 && StringUtils.isNotBlank(s[0]) && Files.exists(Paths.get(s[0]));
    }

    public static void processLine(final String line){
        String[] arguments = line.split(" ");
        String operationName = arguments[0];
        getOperationByName(operationName).execute(arguments);
    }

}
