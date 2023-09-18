package javastudy;

class Circle {
    protected int radius;
    String name;

    public Circle(int r, String n) {
        radius = r;
        name = n;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }
}

public class PizzaTest {
    public static void main(String args[]) {
        Circle obj = new Circle(20, "Pepperoni");
        System.out.printf("%s의 반지름은 %d, 넓이는 %.2f입니다.\n", obj.name, obj.radius, obj.getArea());
    }
}
