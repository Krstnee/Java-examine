class Triangle {
    protected double side1;
    protected double side2;
    protected double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        // Используем формулу Герона для вычисления площади треугольника
        double s = getPerimeter() / 2; // полупериметр
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

class RightTriangle extends Triangle {
    public RightTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3);
    }

    public boolean isRightTriangle() {
        // Проверяем теорему Пифагора: квадрат гипотенузы равен сумме квадратов катетов
        return (side1 * side1 + side2 * side2 == side3 * side3)
                || (side1 * side1 + side3 * side3 == side2 * side2)
                || (side2 * side2 + side3 * side3 == side1 * side1);
    }
}

public class task14 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Area: " + triangle.getArea());

        RightTriangle rightTriangle = new RightTriangle(5, 12, 13);
        System.out.println("Is right triangle: " + rightTriangle.isRightTriangle());
    }
}
