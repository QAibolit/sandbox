package basepatterns.structural.bridge;

/**
 * <h3>Мост</h3>
 * <br><b>Паттерн Мост</b> это структурный паттерн проектирования, который разделяет
 * один или несколько классов на две отдельные иерархии — абстракцию и реализацию,
 * позволяя изменять их независимо друг от друга.
 * <br>
 * <br><b>Когда использовать паттерн Адаптер:</b>
 * <br>&emsp;- Когда нужно разделить абстракцию и реализацию, чтобы они могли изменяться независимо:
 * Например, разные типы пультов (базовый, продвинутый) и разные устройства (TV, радио)
 * <br>&emsp;- Когда нужно избежать постоянной привязки абстракции к реализации:
 * Если реализация должна выбираться во время выполнения
 * <br>&emsp;- Когда изменения в реализации не должны влиять на клиентский код:
 * Клиент работает только с абстракцией
 * <br>&emsp;- Когда у вас есть несколько "измерений" ваших сущностей:
 * Например, разные виды окон (иконки, диалоги) и разные ОС (Windows, Linux)
 * <br>&emsp;- Когда наследование приводит к "взрывному" росту числа классов:
 * Например, если бы мы создавали классы для каждой комбинации пульта и устройства
 * <br>
 * <br><b>Преимущества:</b>
 * <br>&emsp;- Разделение ответственности: Абстракция и реализация живут в разных иерархиях классов
 * <br>&emsp;- Расширяемость: Можно добавлять новые абстракции и реализации независимо
 * <br>&emsp;- Скрытие деталей реализации: Клиентский код работает с абстракцией, не зная о реализации
 * <br>&emsp;- Уменьшение количества подклассов: Избегаем комбинаторного взрыва подклассов
 * <br>&emsp;- Переключение реализации во время выполнения: Можно динамически изменять реализацию,
 * с которой работает абстракция
 * <br>
 * <br><b>Недостатки:</b>
 * <br>&emsp;- Усложнение кода: Введение дополнительных классов и интерфейсов может сделать
 * код сложнее для понимания
 * <br>&emsp;- Неоправданное усложнение для простых случаев: Если интерфейс и реализация
 * стабильны и вряд ли будут меняться, паттерн может быть избыточным
 * <br>&emsp;- Требует тщательного проектирования: Нужно правильно выделить абстракцию
 * и реализацию на ранних этапах проектирования
 * <br>&emsp;- Может снизить производительность: Дополнительный уровень косвенности может
 * немного снизить производительность (хотя обычно незначительно)
 */
public class Bridge {
    public static void main(String[] args) {
        Programm bankApp = new BankApp(new JavaDeveloper());
        bankApp.createProgramm();

        Programm shopApp = new ShopApp(new CppDeveloper());
        shopApp.createProgramm();
    }
}

interface Developer {
    void writeCode();
}

class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes code...");
    }
}

class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("C++ developer writes code...");
    }
}

abstract class Programm {
    Developer developer;

    abstract void createProgramm();
}

class BankApp extends Programm {

    public BankApp(Developer developer) {
        this.developer = developer;
    }

    @Override
    void createProgramm() {
        System.out.println("Bank application in progress...");
        developer.writeCode();
    }
}

class ShopApp extends Programm {

    public ShopApp(Developer developer) {
        this.developer = developer;
    }

    @Override
    void createProgramm() {
        System.out.println("Shop application in progress...");
        developer.writeCode();
    }
}
