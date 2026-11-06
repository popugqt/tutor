public class Main {
    public static void main(String[] args) {
        Figure myFigure = new Figure(0.0, 0.0, "red");
        Cicrle myCicrle = new Cicrle(1.0, 0.0, "green", 4);
        Square mySquare = new Square(0.0, 0.0, "blue", 3);
        Rectangle myRectangle = new Rectangle(0.0, 0.0, "pink", 2, 4);
        
        Figure[] list = new Figure[4];

        list[0] = myFigure;
        list[1] = myCicrle;
        list[2] = mySquare;
        list[3] = myRectangle;

        for (Figure Element : list) {
            System.out.printf("Figure(%s)%n", Element.toString());
        }

        // System.out.println(((Figure) myCicrle).radius); // Ошибка

        Figure myFigureCicrle = myCicrle;
    }
}

class Figure {
    private double x;
    private double y;
    private final String color;
    
    Figure(double x, double y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    public void setX(double newX) {
        x = newX;
    }
    
    public void setY(double newY) {
        y = newY;
    }
    
    public String getColor() {
        return color;
    }

    public String toString() {
        return "x=" + x + ", y=" + y + ", color=" + color;
    }
}
 
final class Cicrle extends Figure {
    private double radius;

    Cicrle(double x, double y, String color, double radius) {
        super(x, y, color);

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    public String toString() {
        return super.toString() + ", radius=" + radius;
    }
}

class Square extends Figure {
    private int width;

    Square(double x, double y, String color, int width) {
        super(x, y, color);

        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int newWidth) {
        width = newWidth;
    }

    public String toString() {
        return super.toString() + ", width=" + width;
    }
}

class Rectangle extends Square {
    private int height;

    Rectangle(double x, double y, String color, int width, int height) {
        super(x, y, color, width);

        this.height = height;
    }
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int newHeight) {
        height = newHeight;
    }

    public String toString() {
        return super.toString() + ", height=" + height;
    }
}