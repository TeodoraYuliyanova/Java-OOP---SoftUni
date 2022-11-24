package Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double perimeter, Double area ,Double height, Double width) {
        super(perimeter, area);
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * this.width + 2 * this.height;

    }

    @Override
    public double calculateArea() {
        return this.width * this.height;
    }
}
