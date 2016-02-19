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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        return limit != null ? limit.equals(that.limit) : that.limit == null;

    }
}
