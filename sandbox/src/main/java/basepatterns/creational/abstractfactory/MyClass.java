package basepatterns.creational.abstractfactory;

/**
 * <h3>Абстрактная фабрика</h3>
 * <br>
 * <b>Абстрактная фабрика</b> - это порождающий паттерн проектирования, который позволяет создавать
 * семейства связанных объектов, не привязываясь к конкретным классам создаваемых объектов.
 * <br>
 * <br>
 * <br><b>Основные компоненты паттерна:</b>
 * <br>
 * <br><b>Абстрактная фабрика (Abstract Factory)</b>:
 * Объявляет интерфейс для создания всех типов продуктов.
 * <br>
 * <br><b>Конкретная фабрика (Concrete Factory):</b>
 * Реализует интерфейс абстрактной фабрики, создавая конкретные продукты.
 * <br>
 * <br><b>Абстрактный продукт (Abstract Product):</b>
 * Объявляет интерфейс для семейства взаимосвязанных продуктов.
 * <br>
 * <br><b>Конкретный продукт (Concrete Product):</b>
 * Реализует интерфейс абстрактного продукта и создает конкретный продукт.
 * <br>
 * <br>
 * <br><b>Преимущества использования паттерна Абстрактная фабрика:</b>
 * <br>
 * <br>&emsp;1. <b>Снижает зависимость от конкретных классов:</b> Клиентский код работает с интерфейсами абстрактных
 * продуктов и фабрик, а не с конкретными классами.
 * <br>
 * <br>&emsp;2. <b>Облегчает добавление новых семейств продуктов:</b> Добавление нового семейства продуктов не
 * требует изменения существующего кода.
 * <br>
 * <br>&emsp;3. <b>Обеспечивает согласованность создаваемых объектов:</b> Все объекты, созданные одной фабрикой,
 * гарантированно совместимы.
 * <br>
 * <br>&emsp;4. <b>Повышает модульность и гибкость:</b> Программа становится более модульной и гибкой при
 * работе с различными семействами объектов.
 * <br>
 * <br>
 * <br><b>В каких случаях полезен паттерн Абстрактная фабрика:</b>
 * <br>&emsp;- Когда необходимо работать с несколькими семействами взаимосвязанных продуктов.
 * <br>&emsp;- Когда необходимо обеспечить возможность переключения между различными семействами продуктов.
 * <br>&emsp;- Когда требуется изолировать создание объектов от клиентского кода.
 * <br>&emsp;- Когда требуется упростить добавление новых семейств продуктов.
 */
public class MyClass {
    public static void main(String[] args) {
        CarsFactory dodgeFactory = new DodgeFactory();
        Suv dodgeSuv = dodgeFactory.createSuv();
        dodgeSuv.description();
        Pickup dodgePickup = dodgeFactory.createPickup();
        dodgePickup.description();

        CarsFactory fordFactory = new FordFactory();
        Suv fordSuv = fordFactory.createSuv();
        fordSuv.description();
        Pickup fordPickup = fordFactory.createPickup();
        fordPickup.description();
    }
}

interface Pickup {
    void description();
}

interface Suv {
    void description();
}

class FordPickup implements Pickup {
    @Override
    public void description() {
        System.out.println("Ford Pickup");
    }
}

class FordSuv implements Suv {
    @Override
    public void description() {
        System.out.println("Ford Suv");
    }
}

class DodgePickup implements Pickup {
    @Override
    public void description() {
        System.out.println("Dodge Pickup");
    }
}

class DodgeSuv implements Suv {
    @Override
    public void description() {
        System.out.println("Dodge Suv");
    }
}

interface CarsFactory {
    Suv createSuv();
    Pickup createPickup();
}

class FordFactory implements CarsFactory {
    @Override
    public Suv createSuv() {
        return new FordSuv();
    }

    @Override
    public Pickup createPickup() {
        return new FordPickup();
    }
}

class DodgeFactory implements CarsFactory {
    @Override
    public Suv createSuv() {
        return new DodgeSuv();
    }

    @Override
    public Pickup createPickup() {
        return new DodgePickup();
    }
}
