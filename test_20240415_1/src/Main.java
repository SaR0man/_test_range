import java.util.HashMap;
import java.util.Map;

// Прототип книги
class Book implements Cloneable {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}

// Фабрика книг
class BookFactory {
    private Map<String, Book> prototypes = new HashMap<>();

    public void addPrototype(String type, Book book) {
        prototypes.put(type, book);
    }

    public Book createBook(String type) {
        Book prototype = prototypes.get(type);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем фабрику книг
        BookFactory bookFactory = new BookFactory();

        // Создаем и добавляем прототипы книг в фабрику
        Book originalBook1 = new Book("Book 1", "Author 1", 100);
        Book originalBook2 = new Book("Book 2", "Author 2", 200);
        bookFactory.addPrototype("Book1", originalBook1);
        bookFactory.addPrototype("Book2", originalBook2);

        // Создаем копии книг с помощью фабрики
        Book clonedBook1 = bookFactory.createBook("Book1");
        Book clonedBook2 = bookFactory.createBook("Book2");

        // Выводим информацию о копиях книг
        System.out.println("Cloned Book 1: " + clonedBook1.getTitle() + " by " + clonedBook1.getAuthor() + ", " + clonedBook1.getPages() + " pages");
        System.out.println("Cloned Book 2: " + clonedBook2.getTitle() + " by " + clonedBook2.getAuthor() + ", " + clonedBook2.getPages() + " pages");
    }
}
