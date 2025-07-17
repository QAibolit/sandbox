package basepatterns.creational.singleton;

public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {}

    /**
     * Потокобезопасный вариант реализации, но в многопоточной среде работает медленно
     */
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
