class Singleton {
    // Приватное статическое поле для хранения единственного экземпляра класса
    private static Singleton instance;

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне класса
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    // Метод для получения экземпляра Singleton, создает его, если он еще не был создан
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Другие методы и поля класса
}

public class Main {
    public static void main(String[] args) {
        // Попытка создать экземпляр Singleton
        Singleton singleton1 = Singleton.getInstance();
        // Еще одна попытка создать экземпляр Singleton
        Singleton singleton2 = Singleton.getInstance();

        // Проверяем, что оба объекта - один и тот же экземпляр
        System.out.println("Are singleton1 and singleton2 the same instance? " + (singleton1 == singleton2));
    }
}