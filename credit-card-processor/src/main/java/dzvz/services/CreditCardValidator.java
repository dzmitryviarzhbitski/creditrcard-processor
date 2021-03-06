package dzvz.services;

import org.apache.commons.lang.StringUtils;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCardValidator {

    public static boolean validate(String creditCardNumber) {

        if (StringUtils.isBlank(creditCardNumber)){
            return false;
        }
        try {
            int sum = 0;
            boolean multiply = false;
            for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
                if (!multiply) {
                    sum += getDigit(creditCardNumber, i);
                } else {
                    int digit = getDigit(creditCardNumber, i);
                    if (digit < 10) {
                        digit = digit * 2;
                        if (digit > 9) {
                            digit = digit % 10 + 1;
                            sum += digit;
                        } else {
                            sum += digit;
                        }
                    }
                }
                multiply = !multiply;

            }
            return sum % 10 == 0;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static int getDigit(String creditCardNumber, int i) throws IllegalArgumentException {
        char value = creditCardNumber.charAt(i);
        int digit = Character.getNumericValue(value);
        if (digit >= 0 && digit <= 9) {
            return digit;
        } else {
            throw new IllegalArgumentException("Invalid credit card is provided");
        }
    }

}
