public class SavingsAccount extends Account {
    private final double max = 1000.0;
    private final double min = 5000.0;

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        try {
            if (amount + super.getBalance() < min) {
                throw new InvalidFundingAmountException(amount);
            }
            doDepositing(amount);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount,
                    super.getBalance() - amount, super.getBalance()));
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (amount > max) {
                throw new InvalidFundingAmountException(amount);
            } else if (super.getBalance() - amount < min) {
                throw new InsufficientFundsException(amount);
            }
            doWithdrawing(amount);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount,
                    super.getBalance() + amount, super.getBalance()));
        } catch (InvalidFundingAmountException | InsufficientFundsException  e) {
            System.out.println(e.getMessage());
        }
    }
}
