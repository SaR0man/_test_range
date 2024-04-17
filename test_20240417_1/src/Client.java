/*
Структура:
AbstractFactory: Определяет интерфейс для создания объектов каждого семейства.
ConcreteFactory: Реализует интерфейс AbstractFactory, создавая конкретные объекты.
AbstractProduct: Определяет интерфейс для продуктов каждого семейства объектов.
ConcreteProduct: Реализует интерфейс AbstractProduct, представляя конкретные продукты, которые создаются фабрикой.
Client: Использует интерфейс AbstractFactory для создания объектов без указания их конкретных классов.
 */

//// AbstractFactory: Определяет интерфейс для создания объектов каждого семейства.
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

//// ConcreteFactory: Реализует интерфейс AbstractFactory, создавая конкретные объекты.
class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ModernChair();
    }

    public Sofa createSofa() {
        return new ModernSofa();
    }
}

class ClassicFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ClassicChair();
    }

    public Sofa createSofa() {
        return new ClassicSofa();
    }
}

//// AbstractProduct: Определяет интерфейс для продуктов каждого семейства объектов.
interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

//// ConcreteProduct: Реализует интерфейс AbstractProduct, представляя конкретные продукты, которые создаются фабрикой.
class ModernChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on a modern chair.");
    }
}

class ModernSofa implements Sofa {
    public void lieOn() {
        System.out.println("Lying on a modern sofa.");
    }
}

class ClassicChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on a classic chair.");
    }
}

class ClassicSofa implements Sofa {
    public void lieOn() {
        System.out.println("Lying on a classic sofa.");
    }
}

//// Client: Использует интерфейс AbstractFactory для создания объектов без указания их конкретных классов.
public class Client {
    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        chair.sitOn();
        sofa.lieOn();
    }
}