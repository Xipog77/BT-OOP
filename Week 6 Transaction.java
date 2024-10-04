public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
    * Ham khoi tao mac dinh.
    */
    public Transaction(String o, double a, double b) {
        operation = o;
        amount = a;
        balance = b;
    }

    /**
    * Ham getter cho operation.
    */
    public String getOperation() {
        return operation;
    }

    /**
    * Ham getter cho amount.
    */
    public double getAmount() {
        return amount;
    }

    /**
    * Ham getter cho Balance.
    */
    public double getBalance() {
        return balance;
    }

    /**
    * Ham setter cho operation.
    */
    public void setOperation(String o) {
        operation = o;
    }

    /**
    * Ham setter cho amount.
    */
    public void setAmount(double a) {
        amount = a;
    }

    /**
    * Ham setter cho balance.
    */
    public void setBalance(double b) {
        balance = b;
    }

}
