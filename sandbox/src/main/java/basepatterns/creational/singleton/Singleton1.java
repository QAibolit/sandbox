package basepatterns.creational.singleton;


public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {}

    /**
     * Не потокобезопасный вариант реализации, не работает в многопоточной среде
     */
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
