package library.model;

import library.util.Validator;

import java.time.LocalDateTime;

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

    public void updateBookInfo(Book currentBook, Book newBookInfo) {
        Validator.validate(currentBook);
        Validator.validate(newBookInfo);
        library.updateBook(currentBook, newBookInfo);

        /*if(currentBook == null || newBookInfo == null)
            throw new IllegalArgumentException("Book cannot be null!");*/
    }

    public void approveBorrow(Book book, Reader reader) {
        if(book.isAvailable() && reader.getRecord().getBookCount() < 5) {
            System.out.println("Book request approved!");
            reader.setMoney(reader.getMoney() - bookPrice);
            reader.getRecord().updateHistory(book, LocalDateTime.now(), bookPrice);
            library.lendBook(book, reader);
        } else {
            System.out.println("Book request denied!");
            if(reader.getRecord().getBookCount() >= 5){
                System.out.println("Reader has reached maximum book limit. Please return at least 1 book.");
            } else if (!book.isAvailable()) {
                System.out.println("Requested book is not available.");
            }
        }
    }

    public void approveReturn(Book book, Reader reader) {
            reader.setMoney(reader.getMoney() + bookPrice);
            reader.getRecord().increaseBalance(bookPrice);
            library.takeBackBook(book);
    }

    @Override
    public String whoYouAre() {
        return "Librarian";
    }

}
