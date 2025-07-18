package basepatterns.creational.builder;

/**
 * <h3>Строитель</h3>
 * <br>
 * <b>Строитель</b> — это порождающий паттерн проектирования,
 * который позволяет создавать сложные объекты пошагово.
 * <br>Строитель даёт возможность использовать один и тот же код строительства
 * для получения разных представлений объектов.
 * <br>
 * <br><b>Преимущества</b>
 * <br>&emsp;- Позволяет создавать продукты пошагово.
 * <br>&emsp;- Позволяет использовать один и тот же код для создания различных продуктов.
 * <br>&emsp;- Изолирует сложный код сборки продукта от его основной бизнес-логики.
 * <br>
 * <br><b>Недостатки:</b>
 * <br>&emsp;- Усложняет код программы из-за введения дополнительных классов.
 * <br>&emsp;- Клиент будет привязан к конкретным классам строителей,
 * так как в интерфейсе директора может не быть метода получения результата.
 * <br>
 * <br><b>Реализация паттерна Builder с fluent interface</b>
 * <br>
 * <br><b>Fluent Interface (в переводе "текучий интерфейс")</b> — это подход к проектированию API,
 * который позволяет писать код в стиле цепочки методов, делая его более читаемым и выразительным.
 * Такой интерфейс имитирует естественный язык, упрощая понимание кода.
 * <br>
 * <br><b>Основные характеристики Fluent Interface:</b>
 * <br>&emsp;- Цепочка вызовов методов – каждый метод возвращает объект,
 * что позволяет вызывать следующий метод сразу после предыдущего.
 * <br>&emsp;- Минимизация промежуточных переменных – не нужно сохранять временные объекты.
 * <br>&emsp;- Повышенная читаемость – код выглядит почти как предложение на естественном языке.
 */
public class FluentInterfaceBuilder {
    public static void main(String[] args) {
        MyComputer computer = new MyComputer.Builder()
                .withCPU("AMD Ryzen 7 5800X")
                .withRAM("16GB DDR4")
                .withStorage("1TB NVMe SSD")
                .withGPU("NVIDIA RTX 3070")
                .build();

        System.out.println(computer);
    }
}

class MyComputer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    // Приватный конструктор
    private MyComputer() {}

    // Геттеры...

    public static class Builder {
        private MyComputer computer;

        public Builder() {
            computer = new MyComputer();
        }

        public Builder withCPU(String CPU) {
            computer.CPU = CPU;
            return this;
        }

        public Builder withRAM(String RAM) {
            computer.RAM = RAM;
            return this;
        }

        public Builder withStorage(String storage) {
            computer.storage = storage;
            return this;
        }

        public Builder withGPU(String GPU) {
            computer.GPU = GPU;
            return this;
        }

        public MyComputer build() {
            return computer;
        }
    }
}
