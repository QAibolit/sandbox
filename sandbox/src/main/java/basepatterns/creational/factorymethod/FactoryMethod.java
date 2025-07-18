package basepatterns.creational.factorymethod;

/**
 * <h3>Фабричный метод</h3>
 * <br>
 * <b>Фабричный метод</b> - это порождающий паттерн проектирования, который предоставляет интерфейс
 * для создания объектов, но позволяет подклассам изменять тип создаваемых объектов.
 * <br>Вместо того чтобы напрямую использовать оператор new для создания объектов, код использует фабричный метод,
 * который может быть переопределен в подклассах для создания различных типов объектов.
 * <br>
 * <br><b>Суть паттерна:</b>
 * <br>
 * <br><b>Интерфейс для создания объектов</b>:
 * <br>Фабричный метод определяет интерфейс или абстрактный метод в базовом классе, который должен быть реализован
 * в подклассах для создания объектов.
 * <br>
 * <br><b>Гибкость и расширяемость:</b>:
 * <br>Позволяет добавлять новые типы объектов, не изменяя существующий код,
 * просто создавая новые подклассы и переопределяя фабричный метод.
 * <br>
 * <br><b>Скрытие деталей создания:</b>
 * <br>Инкапсулирует логику создания объектов, скрывая её от клиентского кода.
 * <br>
 * <br><b>Снижение связности:</b>
 * <br>Позволяет создавать объекты, не зная их конкретных типов, что упрощает поддержку и расширение кода.
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Department itDepartment = new ItDepartment();
        Emploee programmer = itDepartment.createEmploee();
        programmer.doSomething();

        Department salesDepartment = new SalesDepartment();
        Emploee salesManager = salesDepartment.createEmploee();
        salesManager.doSomething();
    }
}

interface Emploee {
    void doSomething();
}

class Programmer implements Emploee {
    public void doSomething() {
        System.out.println("Coding....");
    }
}

class SalesManager implements Emploee {
    public void doSomething() {
        System.out.println("Sale...");
    }
}

abstract class Department {
    abstract Emploee createEmploee();
}

class ItDepartment extends Department {
    @Override
    Emploee createEmploee() {
        return new Programmer();
    }
}

class SalesDepartment extends Department {
    @Override
    Emploee createEmploee() {
        return new SalesManager();
    }
}
