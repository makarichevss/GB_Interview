package HW1.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Square();
        Shape shape3 = new Triangle();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(shape1);
        shapes.add(shape2);
        shapes.add(shape3);

        System.out.printf("%d objects created:\n", shapes.size());
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
