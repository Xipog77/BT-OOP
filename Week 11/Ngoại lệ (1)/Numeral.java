public class Numeral extends Expression {
    private double value;

    public Numeral() {
        super();
    }

    public Numeral(double value) {
        super();
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf((int) value);
    }

    @Override
    public double evaluate() {
        return value;
    }
}
