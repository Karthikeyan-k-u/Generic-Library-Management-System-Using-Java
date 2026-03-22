import java.util.*;

class Book {
    int id;
    String title;
    String author;
    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}
class BookNotFoundException extends Exception {
    BookNotFoundException(String msg) {
        super(msg);
    }
}
class Library<T extends Book> {
    private ArrayList<T> books = new ArrayList<>();
    void addBook(T book) {
        books.add(book);
        System.out.println("Book Added Successfully");
    }
    void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        for (T b : books) {
            b.display();
        }
    }
    void searchBook(int id) throws BookNotFoundException {
        for (T b : books) {
            if (b.id == id) {
                System.out.println("Book Found:");
                b.display();
                return;
            }
        }
        throw new BookNotFoundException("Book with ID " + id + " not found");
    }
}
public class unitproject4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library<Book> library = new Library<>();
        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");
            System.out.println("");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    library.showBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();
                    try {
                        library.searchBook(searchId);
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Program Ended");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
