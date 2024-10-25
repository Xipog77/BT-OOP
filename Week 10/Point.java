import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point() {}

    public Point(double x, double y) {
        pointX = x;
        pointY = y;
    }

    public double getPointX() {
        return pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double distance(Point p) {
        return Math.sqrt((pointX - p.getPointX()) * (pointX - p.getPointX())
                + (pointY - p.getPointY()) * (pointY - p.getPointY()));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point p = (Point) obj;
            return p.getPointX() == pointX && p.getPointY() == pointY;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    public String toString() {
        return String.format("(%.1f,%.1f)", pointX, pointY);
    }
}
