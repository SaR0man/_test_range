//// Создание интерфейсов продуктов.
interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

//// Определение интерфейса абстрактной фабрики.
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

//// Создание конкретных продуктов.
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
        System.out.println("Lying on a classic sofa. Или так.");
    }
}

//// Создание конкретных фабрик.
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

//// Создаем семейства мебели стилей modern и classic, используя фабрики для создания соответствующей мебели.
public class Main {
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Sofa modernSofa = modernFactory.createSofa();
        modernChair.sitOn();
        modernSofa.lieOn();

        FurnitureFactory classicFactory = new ClassicFurnitureFactory();
        Chair classicChair = classicFactory.createChair();
        Sofa classicSofa = classicFactory.createSofa();
        classicChair.sitOn();
        classicSofa.lieOn();
    }
}