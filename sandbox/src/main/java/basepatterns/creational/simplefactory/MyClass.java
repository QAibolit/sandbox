package basepatterns.creational.simplefactory;

/**
 * <h3>Простая фабрика</h3>
 * <br>
 * <b>Простая фабрика</b> - это шаблон проектирования, который относится к категории порождающих,
 * и используется для создания объектов, не раскрывая логику их создания клиенту.
 * <br>Простая фабрика реализуется как отдельный класс, содержащий статический метод, который
 * в зависимости от входных параметров создает и возвращает нужный объект.
 * <br>У простой фабрики как правило нет подклассов
 * <br>
 * <br>Преимущества:
 * <br>&emsp;1. Упрощает создание объектов, скрывая сложную логику за одним интерфейсом.
 * <br>&emsp;2. Повышает гибкость и расширяемость, так как добавление новых типов объектов требует
 * лишь модификации фабрики, а не всего клиентского кода.
 * <br>&emsp;3. Улучшает читаемость кода, поскольку клиенту не нужно знать, как именно создаются объекты.
 * <br>
 * <br>Недостатки:
 * <br>&emsp;1. Может привести к разрастанию фабрики, если логика создания объектов становится очень сложной.
 * <br>&emsp;2. Не подходит для ситуаций, когда нужно создавать объекты разных семейств,
 * для этого лучше использовать абстрактную фабрику.
 */
public class MyClass {

    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape(ShapeType.CIRCLE);
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape(ShapeType.RECTANGLE);
        shape2.draw();

        Shape shape3 = ShapeFactory.getShape(ShapeType.TRIANGLE);
        shape3.draw();
    }
}

interface Shape {
    void draw();
}

enum ShapeType {
    CIRCLE, RECTANGLE, TRIANGLE
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

class ShapeFactory {
    public static Shape getShape(ShapeType shapeType) {
        switch (shapeType) {
            case CIRCLE -> {
                return new Circle();
            }
            case RECTANGLE -> {
                return new Rectangle();
            }
            case TRIANGLE -> {
                return new Triangle();
            }
            default -> throw new UnsupportedOperationException();
        }
    }
}
