package week7.assignment_problems;
public class SquareShape extends Shape {
    private double side;
    public SquareShape(double side) { this.side = side; }
    @Override public double calculateArea() { return side * side; }
    @Override public void scale(double xFactor, double yFactor) { this.side *= xFactor; }
}
