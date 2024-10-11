public class Circle {
    private double radius;
    private String color;
    protected static final double PI = 3.14;

    /**
     * Ham khoi tao mac dinh.
     */
    public Circle() {
        
    }

    /**
     * Ham khoi tao them radius.
     */
    public Circle(double r) {
        radius = r;
    }

    /**
     * Ham khoi tao them radius va colour.
     * @param r = radius.
     * @param c = colour.
     */
    public Circle(double r, String c) {
        radius = r;
        color = c;
    }

    /**
     * Ham getter cho radius.
     * @return radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Ham setter cho radius.
     * @param r = radius.
     */
    public void setRadius(double r) {
        radius = r;
    }

    /**
     * Ham getter cho colour.
     * @return colour.
     */
    public String getColor() {
        return color;
    }

    /**
     * Ham setter cho colour.
     * @param c = colour.
     */
    public void setColor(String c) {
        color = c;
    }

    /**
     * Ham tinh gia tri dien tich.
     * @return dien tich cua Circle.
     */
    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * Ham tra ve tinh chat cua Circle.
     * @return Tinh chat cua Circle.
     */
    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]";
    }
}
