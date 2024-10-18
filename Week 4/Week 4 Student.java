package StudentManagement;

public class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String n) {
        name = n;
        return;
    }

    public void setId(String i) {
        id = i;
        return;
    }

    public void setGroup(String g) {
        group = g;
        return;
    }

    public void setEmail(String e) {
        email = e;
        return;
    }

    Student() {
        name = "Student";
        id = "000";
        group = "K62CB";
        email = "uet@vnu.edu.vn";
    }

    Student(String n, String i, String e) {
        name = n;
        id = i;
        group = "K62CB";
        email = e;
    }

    Student(Student s) {
        name = s.name;
        id = s.id;
        group = s.group;
        email = s.email;
    }

    String getInfo() {
        return name + " - " + id + " - " + group + " - " + email;
    }
}
