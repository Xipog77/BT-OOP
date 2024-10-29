import java.util.Objects;

public class Person implements Comparable<Person> {
    protected String name;
    protected int age;
    protected String address;

    public Person() {}

    /**
     * Hàm khởi tạo Person.
     * @param name tên.
     * @param age tuổi.
     * @param address địa chỉ.
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Hàm so sánh 2 Person.
     * @param p the object to be compared.
     * @return kết quả so sánh.
     */
    @Override
    public int compareTo(Person p) {
        if (!Objects.equals(this.name, p.name)) {
            return this.name.compareTo(p.name);
        } else if (this.age != p.age) {
            return Integer.compare(this.age, p.getAge());
        } else {
            return this.address.compareTo(p.address);
        }
    }
}
