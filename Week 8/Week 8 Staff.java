public class Staff extends Person {
    private String school;
    private double pay;

    Staff(String n, String adr, String sch, double p) {
        super(n, adr);
        school = sch;
        pay = p;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String sch) {
        school = sch;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double p) {
        pay = p;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() + ",school=" + school + ",pay=" + pay + "]";
    }
}
