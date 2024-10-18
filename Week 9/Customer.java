import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    private List<Account> accountList = new ArrayList<>();
    private long idNumber;
    private String fullName;

    public Customer() {}

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Customer(final long idNumber, final String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public String getCustomerInfo() {
        return "Số CMND: " + idNumber +  ". Họ tên: " + fullName + ".";
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * Ham xoa mot tai khoan khoi danh sach.
     * @param account tai khoan can xoa.
     */
    public void removeAccount(Account account) {
        Iterator<Account> iterator = accountList.iterator();
        while (iterator.hasNext()) {
            Account existingAccount = iterator.next();
            if (existingAccount.equals(account)) {
                iterator.remove();
                break;
            }
        }
    }
}
