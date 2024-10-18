import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account {
    private long accountNumber;
    private double balance;
    protected List<Transaction> transactionList = new ArrayList<>();
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS  = "SAVINGS";

    public Account() {}

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    /**
     * Ham nap tien vao tai khoan.
     * @param amount so tien nap vao.
     * @throws InvalidFundingAmountException neu tien nap vao khong hop le.
     */
    public void doDepositing(double amount)
            throws InvalidFundingAmountException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }

    /**
     * Ham rut tien khoi tai khoan.
     * @param amount so tien rut.
     * @throws InvalidFundingAmountException neu tien nap vao khong hop le.
     * @throws InsufficientFundsException neu tien rut ra khong hop le.
     */
    public void doWithdrawing(double amount)
            throws InvalidFundingAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (amount > balance) {
            throw new InsufficientFundsException(amount);
        } else {
            balance -= amount;
        }
    }

   public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * Ham tra ve lich su giao dich.
     * @return string.
     */
    public String getTransactionHistory() {
        StringBuilder str = new StringBuilder();
        str.append("Lịch sử giao dịch của tài khoản ");
        str.append(accountNumber);
        str.append(":\n");
        for (Transaction transaction : transactionList) {
            System.out.print("- ");
            transaction.getTransactionSummary();
            str.append("- ").append(transaction.getTransactionSummary());
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return Objects.equals(accountNumber, account.accountNumber);
        } else {
            return false;
        }
    }
}
