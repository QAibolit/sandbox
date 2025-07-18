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
 */
public class ClassicBuilder {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Строим игровой компьютер
        Computer gamingComputer = director.buildGamingComputer();
        System.out.println("Gaming Computer: " + gamingComputer);

        // Строим офисный компьютер
        Computer officeComputer = director.buildOfficeComputer();
        System.out.println("Office Computer: " + officeComputer);
    }
}

class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", GPU='" + GPU + '\'' +
                '}';
    }
}

// Абстрактный строитель
interface ComputerBuilder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    void buildGPU();
    Computer getComputer();
}

// Конкретный строитель для игрового компьютера
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCPU("Intel Core i9-13900K");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("32GB DDR5");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("2TB NVMe SSD");
    }

    @Override
    public void buildGPU() {
        computer.setGPU("NVIDIA RTX 4090");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

// Конкретный строитель для офисного компьютера
class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCPU("Intel Core i5-12400");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    @Override
    public void buildGPU() {
        computer.setGPU("Integrated Graphics");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

// Директор, который управляет процессом строительства
class ComputerDirector {
    public Computer buildGamingComputer() {
        ComputerBuilder builder = new GamingComputerBuilder();
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildGPU();
        return builder.getComputer();
    }

    public Computer buildOfficeComputer() {
        ComputerBuilder builder = new OfficeComputerBuilder();
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildGPU();
        return builder.getComputer();
    }
}
