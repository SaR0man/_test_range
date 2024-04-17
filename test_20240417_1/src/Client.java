/*
���������:
AbstractFactory: ���������� ��������� ��� �������� �������� ������� ���������.
ConcreteFactory: ��������� ��������� AbstractFactory, �������� ���������� �������.
AbstractProduct: ���������� ��������� ��� ��������� ������� ��������� ��������.
ConcreteProduct: ��������� ��������� AbstractProduct, ����������� ���������� ��������, ������� ��������� ��������.
Client: ���������� ��������� AbstractFactory ��� �������� �������� ��� �������� �� ���������� �������.
 */

//// AbstractFactory: ���������� ��������� ��� �������� �������� ������� ���������.
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

//// ConcreteFactory: ��������� ��������� AbstractFactory, �������� ���������� �������.
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

//// AbstractProduct: ���������� ��������� ��� ��������� ������� ��������� ��������.
interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

//// ConcreteProduct: ��������� ��������� AbstractProduct, ����������� ���������� ��������, ������� ��������� ��������.
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

//// Client: ���������� ��������� AbstractFactory ��� �������� �������� ��� �������� �� ���������� �������.
public class Client {
    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        chair.sitOn();
        sofa.lieOn();
    }
}