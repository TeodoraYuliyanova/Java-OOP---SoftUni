package Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double perimeter, Double area, Double radius) {
        super(perimeter, area);
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * (2 * this.radius);
    }
}
