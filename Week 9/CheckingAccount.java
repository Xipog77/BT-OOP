public class CheckingAccount extends Account {

    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, amount,
                    super.getBalance() - amount, super.getBalance()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, amount,
                    super.getBalance() + amount, super.getBalance()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
