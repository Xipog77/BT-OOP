public class Square extends Expression {
    private Expression expression;

    public Square(Expression e) {
        expression = e;
    }

    @Override
    public String toString() {
        return "(" + expression.toString() + ") ^ 2";
    }

    @Override
    public double evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
