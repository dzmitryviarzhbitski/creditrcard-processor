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
    private boolean valid;

    private CreditCard(String name, String number, Long balance, Long limit, boolean valid) {
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.limit = limit;
        this.valid = valid;
    }

    public static CreditCard newCreditCard(String name, String number, Long limit, boolean valid) {
        return new CreditCard(name, number, DEFAULT_BALANCE, limit, valid);
    }
    public static CreditCard newCreditCard(String name, String number, Long limit, Long balance, boolean valid) {
        return new CreditCard(name, number, balance, limit, valid);
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

    public boolean isValid() {
        return valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (valid != that.valid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        return limit != null ? limit.equals(that.limit) : that.limit == null;
    }
}
