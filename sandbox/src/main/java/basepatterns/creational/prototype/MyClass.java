package basepatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Прототип</h3>
 * <br><b>Прототип</b> — это порождающий паттерн проектирования, который позволяет копировать объекты,
 * не вдаваясь в подробности их реализации.
 * <br>
 * <br>Паттерн Прототип поручает создание копий самим копируемым объектам.
 * <br>Он вводит общий интерфейс для всех объектов, поддерживающих клонирование.
 * <br>Это позволяет копировать объекты, не привязываясь к их конкретным классам.
 * <br>Обычно такой интерфейс имеет всего один метод {@code clone}.
 * <br>
 * <br>Реализация этого метода в разных классах очень схожа.
 * <br>Метод создаёт новый объект текущего класса и копирует в него значения всех полей собственного объекта.
 * <br>Так получится скопировать даже приватные поля, так как большинство языков программирования разрешает
 * доступ к приватным полям любого объекта текущего класса.
 * <br>
 * <br><b>Преимущества</b>
 * <br>&emsp;- Позволяет клонировать объекты, не привязываясь к их конкретным классам.
 * <br>&emsp;- Меньше повторяющегося кода инициализации объектов.
 * <br>&emsp;- Ускоряет создание объектов.
 * <br>&emsp;- Альтернатива созданию подклассов для конструирования сложных объектов.
 * <br>
 * <br><b>Недостатки:</b>
 * <br>&emsp;- Сложно клонировать составные объекты, имеющие ссылки на другие объекты.
 */
public class MyClass {

    public static void main(String[] args) {
        // Создаем оригинальный профиль
        ConcretPrototype proto = new ConcretPrototype("John", 25);
        proto.addPreferences("language","en");
        proto.addPreferences("notifications","enabled");

        System.out.println("Original prototype: " + proto);

        // Создаем копию
        ConcretPrototype copy = (ConcretPrototype) proto.copy();
        System.out.println("Copy before changes: " + copy);

        // Модифицируем копию
        copy.setName("Bob");
        copy.setValue(101);
        copy.addPreferences("language","fr");

        System.out.println("\nAfter modification:");
        System.out.println("Original prototype: " + proto);
        System.out.println("Modified copy: " + copy);
    }
}

// Интерфейс прототипа
interface Prototype {
    Prototype copy();
}

// Конкретный класс, реализующий прототип
class ConcretPrototype implements Prototype {
    private String name;
    private int value;
    private Map<String, String> preferences;

    public ConcretPrototype(String name, int value) {
        this.name = name;
        this.value = value;
        this.preferences = new HashMap<>();
    }

    // Приватный конструктор для копирования
    private ConcretPrototype(ConcretPrototype source) {
        this.name = source.name;
        this.value = source.value;
        this.preferences = new HashMap<>(source.preferences);
    }

    @Override
    public Prototype copy() {
        return new ConcretPrototype(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addPreferences(String key, String value) {
        this.preferences.put(key, value);
    }

    @Override
    public String toString() {
        return "ConcretPrototype{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", preferences=" + preferences +
                '}';
    }
}
