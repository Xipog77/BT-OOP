import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Ham doc du lieu dau vao.
     * @param inputStream du lieu dau vao.
     */
    public void readCustomerList(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(" ");
                if (Character.isLetter(info[0].charAt(0))) {
                    StringBuilder name = new StringBuilder(info[0]);
                    for (int i = 1; i < info.length; i++) {
                        if (Character.isLetter(info[i].charAt(0))) {
                            name.append(" ").append(info[i]);
                        }
                    }
                    long idNumber = Long.parseLong(info[info.length - 1]);
                    customerList.add(new Customer(idNumber, name.toString()));
                } else {
                    long accountNumber = Long.parseLong(info[0]);
                    String accountType = info[1];
                    double balance = Double.parseDouble(info[2]);

                    if (accountType.equals(Account.CHECKING)) {
                        customerList.get(customerList.size() - 1)
                                .addAccount(new CheckingAccount(accountNumber, balance));
                    } else if (accountType.equals(Account.SAVINGS)) {
                        customerList.get(customerList.size() - 1)
                                .addAccount(new SavingsAccount(accountNumber, balance));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ham tra ve danh sach khach hang xep theo id.
     * @return string.
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(Comparator.comparing(Customer::getIdNumber));
        StringBuilder str = new StringBuilder();
        for (Customer customer : customerList) {
            str.append(customer.getCustomerInfo()).append("\n");
        }
        return str.toString();
    }

    /**
     * Ham tra ve danh sach khach hang xep theo ten.
     * @return string.
     */
    public String getCustomersInfoByNameOrder() {
        customerList.sort(Comparator.comparing(Customer::getFullName));
        StringBuilder str = new StringBuilder();
        for (Customer customer : customerList) {
            str.append(customer.getCustomerInfo()).append("\n");
        }
        return str.toString();
    }
}
