public class Transaction {
    private final double amount;
    private final double initialBalance;
    private final double finalBalance;
    private final int type;
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;

    /**
     * Ham khoi tao Transaction.
     * @param type loai giao dich.
     * @param amount so tien giao dich.
     * @param initialBalance so du truoc giao dich.
     * @param finalBalance so du sau giao dich.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Ham tra ve kieu loai giao dich.
     * @param t kieu giao dich.
     * @return string.
     */
    private String getTransactionTypeString(int t) {
        if (t == TYPE_DEPOSIT_CHECKING) {
            return  "Nạp tiền vãng lai";
        } else if (t == TYPE_WITHDRAW_CHECKING) {
            return  "Rút tiền vãng lai";
        } else if (t == TYPE_DEPOSIT_SAVINGS) {
            return "Nạp tiền tiết kiệm";
        } else if (t == TYPE_WITHDRAW_SAVINGS) {
            return "Rút tiền tiết kiệm";
        } else {
            throw new IllegalArgumentException("Invalid transaction type");
        }
    }

    /**
     * Ham tra ve thong tin giao dich.
     * @return string.
     */
    public String getTransactionSummary() {
        StringBuilder str = new StringBuilder();
        str.append("Kiểu giao dịch: ");
        str.append(getTransactionTypeString(type));
        str.append(". Số dư ban đầu: $");
        str.append(String.format("%.2f", initialBalance));
        str.append(". Số tiền: $");
        str.append(String.format("%.2f", amount));
        str.append(". Số dư cuối: $");
        str.append(String.format("%.2f", finalBalance));
        str.append(".\n");
        return str.toString();
    }
}
