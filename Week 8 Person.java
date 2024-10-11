public class Person {
    private String name;
    private String address;

    public Person(String n, String adr) {
        name = n;
        address = adr;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adr) {
        address = adr;
    }

    public String toString() {
        return "Person[name=" + name + ",address=" + address + "]";
    }
}
