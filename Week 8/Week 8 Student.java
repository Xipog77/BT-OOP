public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    Student(String n, String adr, String pro, int y, double f) {
        super(n, adr);
        program = pro;
        year = y;
        fee = f;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String pro) {
        program = pro;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int y) {
        year = y;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double f) {
        fee = f;
    }

    @Override
    public String toString() {
        String ans =
        ans += "Student[" + super.toString() + ",program="
                + program + ",year=" + year + ",fee=" + fee + "]";
    }
}
