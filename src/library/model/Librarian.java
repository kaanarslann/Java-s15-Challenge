package library.model;

import library.util.Validator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Librarian extends Person {
    private String password;
    private double bookPrice = 15.50;

    Library library = Library.getInstance();

    public Librarian(int id, String name, String password) {
        super(id, name);
        this.password = password;
    }

    public void addBook(Book book) {
        Validator.validate(book);
        library.newBook(book);
    }

    public void removeBook(Book book) {
        Validator.validate(book);
        library.removeBook(book);
    }

    public void updateBookInfo(Book currentBook, String newTitle, String newCategory) {
        Validator.validate(currentBook);
        Validator.validate(newTitle);
        Validator.validate(newCategory);
        library.updateBook(currentBook, newTitle, newCategory);
    }

    public void approveBorrow(Book book, Reader reader) {
        if(book.isAvailable() && reader.getRecord().getBookCount() < 5) {
            System.out.println("Book request approved!");
            reader.setMoney(reader.getMoney() - bookPrice);
            reader.getRecord().updateHistory(book, LocalDateTime.now(), bookPrice);
            library.lendBook(book, reader);
            Map<Book, LocalDateTime> history = reader.getRecord().getBorrowHistory();
            System.out.println("Borrow history: ");
            for (Map.Entry<Book, LocalDateTime> entry : history.entrySet()) {
                System.out.println(entry.getKey());
            }
        } else {
            System.out.println("Book request denied!");
            if(reader.getRecord().getBookCount() >= 5){
                System.out.println("Reader has reached maximum book limit. Please return at least 1 book.");
            } else if (!book.isAvailable()) {
                System.out.println("Requested book is currently borrowed by " + book.getBorrower());
            }
        }
    }

    public void approveReturn(Book book, Reader reader) {
        reader.setMoney(reader.getMoney() + bookPrice);
        reader.getRecord().increaseBalance(bookPrice);
        library.takeBackBook(book);
    }

    public List<Book> listAllBooks() {
        return library.listAllBooks();
    }

    public List<Book> filterByAuthor(String authorName) {
        return library.filterByAuthor(authorName);
    }

    public List<Book> filterByCategory(String category) {
        return library.filterByCategory(category);
    }

    public List<Book> filterByTitle(String title) {
        return library.filterByTitle(title);
    }

    @Override
    public String whoYouAre() {
        return "Librarian";
    }

}
