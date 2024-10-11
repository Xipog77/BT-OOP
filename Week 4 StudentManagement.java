package StudentManagement;

import java.util.Objects;

public class StudentManagement {

    private Student[] students = new Student[100];
    private int num = 0;

    public static boolean sameGroup(Student s1, Student s2) {
        return Objects.equals(s1.getGroup(), s2.getGroup());
    }

    public void addStudent(Student newStudent) {
        students[num++] = newStudent;
        return;
    }

    private boolean check(String[] haveUsed, Student student) {
        if (student == null) {
            return false;
        }
        for (String s : haveUsed) {
            if (s == null) {
                continue;
            }
            if (s.equals(student.getGroup())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return a string of all students ordered by group.
     */
    public String studentsByGroup() {
        String ans = "";
        String[] haveUsed = new String[students.length];
        int i = 0;
        for (int j = 0; j < num; j++) {
            if (check(haveUsed, students[j])) {
                haveUsed[i++] = students[j].getGroup();
            }
        }
        for (String s : haveUsed) {
            if (s == null) {
                continue;
            }
            ans += s + '\n';
            for (int j = 0; j < num; j++) {
                if (students[j] != null && Objects.equals(s, students[j].getGroup())) {
                    ans += students[j].getInfo() + '\n';
                }
            }
        }
        return ans;
    }

    /**
     * Remove a student from the list.
     */
    public void removeStudent(String id) {
        for (int i = 0; i < num; i++) {
            if (students[i] != null && students[i].getId().equals(id)) {
                students[i] = null;
                for (int j = i; j < num - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[num] = null;
                num--;
                return;
            }
        }
        return;
    }

    /**
     * Run the test function.
     */
    public static void main(String[] args) {
        Student s1 = new Student("Nguyen Van An", "17020001", "17020001@vnu.edu.vn");
        Student s2 = new Student("Nguyen Van B", "17020002", "17020002@vnu.edu.vn");
        s1.setGroup("K62CC");
        s2.setGroup("K62CC");
        //System.out.println(s1.getInfo());
        //System.out.println(s2.getInfo());
        StudentManagement sm = new StudentManagement();
        sm.addStudent(s1);
        sm.addStudent(s2);
        Student s3 = new Student("Nguyen Van C", "17020003", "17020003@vnu.edu.vn");
        Student s4 = new Student("Nguyen Van D", "17020004", "17020004@vnu.edu.vn");
        sm.addStudent(s3);
        sm.addStudent(s4);
        System.out.print(sm.studentsByGroup());
    }
}
