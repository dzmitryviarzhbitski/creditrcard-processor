package dzvz.model;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public class CreditCard {

    private final String name;
    private final String number;
    private Long balance;
    private final Long limit;

    public CreditCard(String name, String number, Long balance, Long limit) {
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.limit = limit;
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
