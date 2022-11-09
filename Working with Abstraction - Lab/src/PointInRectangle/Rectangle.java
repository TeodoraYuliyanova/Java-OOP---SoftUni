package PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {

        boolean containsOnX = point.getXCoordinate() >= bottomLeft.getXCoordinate() && point.getXCoordinate() <= topRight.getXCoordinate();

        boolean containsOnY = point.getYCoordinate() >= bottomLeft.getYCoordinate() && point.getYCoordinate() <= topRight.getYCoordinate();

        return containsOnX && containsOnY;
    }
}
