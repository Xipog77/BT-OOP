import java.util.Objects;

public class Rectangle extends Shape {
    protected double width;
    protected double length;
    protected Point topLeft;

    public Rectangle() {
        super();
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Ham khoi tao rectangle.
     * @param width = chieu dai.
     * @param length = chieu rong.
     * @param color = mau.
     * @param filled = lap day.
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * Ham khoi tao day du rectangle.
     * @param topLeft = point.
     * @param width = chieudai.
     * @param length = chieu rong.
     * @param color = mau.
     * @param filled = lap day.
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[topLeft=%s,width=%.1f,length=%.1f,color=%s,filled=%b]",
                topLeft.toString(), width, length, super.getColor(), super.isFilled());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle r = (Rectangle) obj;
            double epsilon = 0.001;
            return Math.abs(width - r.getWidth()) < epsilon
                    && Math.abs(length - r.getLength()) < epsilon
                    && topLeft.equals(r.getTopLeft());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length, topLeft);
    }

}
