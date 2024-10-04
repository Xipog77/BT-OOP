import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction>  transitionList  = new ArrayList<>();

    /**
    * Ham khoi tao mac dinh.
    */
    Account() {
        balance = 0;
    }

    /**
    * Nap tien vao tai khoan.
    */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
        return;
    }

    /**
    * Rut tien khoi tai khoan.
    */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        } else {
            balance -= amount;
            return;
        }
    }

    /**
    * Ham thuc hien giao dich.
    */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            if (amount > 0) {
                Transaction newTransaction = new Transaction(operation, amount, balance);
                transitionList.add(newTransaction);
            }
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            if (amount > 0 && amount <= balance) {
                Transaction newTransaction = new Transaction(operation, amount, balance);
                transitionList.add(newTransaction);
            }
        } else {
            System.out.println("Yeu cau khong hop le!");
            return;
        }
    }

    /**
    * In ra tat cac cac giao dich da thuc hien.
    */
    public void printTransaction() {
        int count = 1;
        for (Transaction transaction : transitionList) {
            if (transaction != null) {
                if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                    String ans = String.format(
                            "Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.",
                            count,
                            transaction.getAmount(),
                            transaction.getBalance()
                    );
                    System.out.println(ans);
                } else {
                    String ans = String.format(
                            "Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.",
                            count,
                            transaction.getAmount(),
                            transaction.getBalance()
                    );
                    System.out.println(ans);
                }
                count++;
            }
        }
        return;
    }
}
