package library.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Book {
    private int bookId;
    private Author author;
    private String name;
    private String category;
    private BookStatus status;
    private LocalDateTime dateOfPurchase;
    private Reader borrower;

    public Book(int bookId, Author author, String name, String category) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.category = category;
        this.status = BookStatus.AVAILABLE;
        this.dateOfPurchase = LocalDateTime.now();
    }

    public int getBookId() {
        return bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    public Reader getBorrower() {
        return borrower;
    }

    public void setBorrower(Reader borrower) {
        this.borrower = borrower;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    @Override
    public String toString() {
        return "Book= Id: " + bookId + ".Title: " + name + " by Author: " + author + ".Category: " + category;
    }
}
