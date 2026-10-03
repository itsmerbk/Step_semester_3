package week7.assignment_problems;
public abstract class Shape {
    private static int counter = 0;
    private final String shapeId;
    public Shape() {
        counter++;
        this.shapeId = "SHAPE-" + counter;
    }
    public abstract double calculateArea();
    public void scale(double factor) { scale(factor, factor); }
    public void scale(double xFactor, double yFactor) {}
    public String getShapeId() { return shapeId; }
}
