import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    public Layer() {}

    public Layer(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Ham xoa nhung hinh tron.
     */
    public void removeCircles() {
        Iterator<Shape> iterator = shapes.iterator();
        while (iterator.hasNext()) {
            Object shape = iterator.next();
            if (shape instanceof Circle) {
                iterator.remove();
            }
        }
    }

    /**
     * Ham lay thong tin cua ca layer.
     * @return string.
     */
    public String getInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            sb.append(shape.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Ham xoa nhung hinh trung lap.
     */
    public void removeDuplicates() {
        Set<Shape> set = new LinkedHashSet<>(shapes);
        shapes.clear();
        shapes.addAll(set);
    }
}
