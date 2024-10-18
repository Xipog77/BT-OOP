public class Cylinder extends Circle {
    private double height;

    /**
     * Ham khoi tao mac dinh.
     */
    public Cylinder() {
        super();
    }

    /**
     * Ham khoi tao them chieu cao.
     * @param h = chieu cao.
     */
    public Cylinder(double h) {
        super();
        height = h;
    }

    /**
     * Ham khoi tao them chieu cao va ban kinh.
     * @param h = chieu cao.
     * @param r = ban kim.
     */
    public Cylinder(double h, double r) {
        super(r);
        height = h;
    }

    /**
     * Ham khoi tao them chieu cao, ban kinh va mau sac.
     * @param h = chieu cao.
     * @param r = ban kinh.
     * @param c = mau sac.
     */
    public Cylinder(double h, double r, String c) {
        super(r, c);
        height = h;
    }

    /**
     * Ham getter cho chieu cao.
     * @return height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Ham setter cho chieu cao.
     * @param h = chieu cao.
     */
    public void setHeight(double h) {
        height = h;
    }

    /**
     * Ham tinh gia tri the tich cua Cylinder.
     * @return the tich Cylinder.
     */
    public double getVolume() {
        return height * super.getArea();
    }

    /**
     * Ham tra ve trang thai cua Cylinder.
     * @return trang thai Cylinder.
     */
    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + "]";
    }

    /**
     * Ham tra ve dien tich cua Cylinder.
     * @return dien tich cua Cylinder.
     */
    @Override
    public double getArea() {
        return height * 2 * PI * super.getRadius() + 2 * super.getArea();
    }
}
