package basepatterns.creational.staticfactorymethod;

/**
 * <h3>Статический фабричный метод</h3>
 * <p>
 * <b>Статический фабричный метод</b> — вариация создающего метода, объявленная как static.
 * Если этот метод создаёт объекты своего же класса, то, по сути, он выступает в роли альтернативного конструктора.
 * <p>
 * <br>Это может быть полезно, если:
 * <br>
 * <br>&emsp;1. Требуется создать разные по функциональности конструкторы, у которых бы совпадали сигнатуры
 * (например, Random(int max) и Random(int min)). Это невозможно во многих языках программирования,
 * но создав статический метод, вы можете обойти это ограничение.
 * <br>
 * <br>&emsp;2. Хочется повторно использовать готовые объекты, вместо создания новых (например, паттерн Одиночка).
 * При вызове конструктора вы всегда создаёте новый объект. Это можно обойти, если вынести вызов конструктора
 * в новый метод. В этом методе вы можете сначала поискать готовый объект в каком-то кеше, и только если его нет,
 * создать новый объект.
 * <br>
 * <br>В данном примере, {@code createFromString} и {@code createFromInteger} являются статическими фабричными методами,
 * которые создают объекты класса {@code MyClass}. Они предоставляют более удобный способ создания объектов,
 * чем использование конструктора напрямую, особенно если есть разные варианты инициализации
 */
public class StaticFactoryMethod {

    private String data;

    private StaticFactoryMethod(String data) {
        this.data = data;
    }

    public static StaticFactoryMethod createFromString(String data) {
        return new StaticFactoryMethod(data);
    }

    public static StaticFactoryMethod createFromInteger(int number) {
        return new StaticFactoryMethod(String.valueOf(number));
    }

    public String getData() {
        return data;
    }

    public static void main(String[] args) {
        StaticFactoryMethod obj1 = StaticFactoryMethod.createFromString("test");
        StaticFactoryMethod obj2 = StaticFactoryMethod.createFromInteger(123);

        System.out.println(obj1.getData());
        System.out.println(obj2.getData());
    }
}
