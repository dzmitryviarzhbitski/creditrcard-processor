package dzvz.model;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCard {

    public static final long DEFAULT_BALANCE = 0l;
    private final String name;
    private final String number;
    private Long balance;
    private final Long limit;

    private CreditCard(String name, String number, Long balance, Long limit) {
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.limit = limit;
    }

    public static CreditCard newCreditCard(String name, String number, Long limit) {
        return new CreditCard(name, number, DEFAULT_BALANCE, limit);
    }

    public String getNumber() {
        return number;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getLimit() {
        return limit;
    }

    public String getName() {
        return name;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

}
