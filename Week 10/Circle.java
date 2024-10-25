import java.util.Objects;

public class Circle extends Shape {
    protected double radius;
    protected Point center;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * Ham khoi tao day du Circle.
     * @param center = point.
     * @param radius = ban kinh.
     * @param color = mau sac.
     * @param filled = lap day.
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[center=%s,radius=%.1f,color=%s,filled=%b]",
                center.toString(), radius, super.getColor(), super.isFilled());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle c = (Circle) obj;
            double epsilon = 0.001;
            return Math.abs(radius - c.getRadius()) < epsilon
                    && c.center.equals(center);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, center);
    }
}
