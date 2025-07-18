package basepatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Компоновщик</h3>
 * <br><b>Паттерн Компоновщик (Composite)</b> это структурный паттерн, который позволяет сгруппировать
 * объекты в древовидную структуру и работать с ними как с единым объектом.
 * <br>
 * <br><b>Когда использовать паттерн Компоновщик:</b>
 * <br>&emsp;- Когда нужно представить иерархию "часть-целое".
 * <br>&emsp;- Когда клиент должен единообразно работать как с отдельными объектами, так и с их группами.
 * <br>&emsp;- Когда нужно рекурсивно обрабатывать древовидные структуры.
 * <br>
 * <br><b>Преимущества:</b>
 * <br>&emsp;- Упрощает клиентский код — клиент работает с деревом объектов единообразно.
 * <br>&emsp;- Гибкость — легко добавлять новые типы компонентов.
 * <br>&emsp;- Рекурсивная обработка — удобно для обхода древовидных структур.
 * <br>
 * <br><b>Недостатки:</b>
 * <br>&emsp;- Нарушение принципа единственной ответственности — компоненты могут иметь лишнюю логику.
 * <br>&emsp;- Сложность контроля типов — иногда трудно ограничить добавление неподходящих компонентов.
 * <br>&emsp;- Избыточность — если структура простая, паттерн может усложнить код.
 */
public class CompositePattern {
    public static void main(String[] args) {
        // Создаем листья
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");
        Component leaf3 = new Leaf("Leaf 3");

        // Создаем композитные компоненты
        Composite composite1 = new Composite("Composite 1");
        Composite composite2 = new Composite("Composite 2");

        // Добавляем листья в композитные компоненты
        composite1.add(leaf1);
        composite1.add(leaf2);
        composite2.add(leaf3);

        // Добавляем композит в другой композит
        Composite root = new Composite("Root");
        root.add(composite1);
        root.add(composite2);

        // Вызываем операцию для всей структуры
        root.operation();
    }
}

// Базовый интерфейс компонента
interface Component {
    void operation();
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
}

// Листовой компонент (не имеет детей)
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " is performing operation.");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to a leaf.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf.");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Leaf has no children.");
    }
}

// Композитный компонент (может содержать другие компоненты)
class Composite implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Composite " + name + " is performing operation.");
        for (Component child : children) {
            child.operation();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return children.get(index);
    }
}
