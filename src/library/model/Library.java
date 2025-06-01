package library.model;

import library.util.BookFilterable;

import java.util.*;

public class Library implements BookFilterable {
    private static Library instance;
    private List<Book> books;
    private Set<Reader> readers;

    private Library() {
        books = new ArrayList<>();
        readers = new HashSet<>();
    }

    public static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return Collections.unmodifiableSet(readers);
    }

    public void newBook(Book book) {
        book.setStatus(BookStatus.AVAILABLE);
        books.add(book);
        System.out.println("Added new book successfully!");
    }

    public void removeBook(Book book) {
        book.setStatus(BookStatus.NOT_AVAILABLE);
        books.remove(book);
        System.out.println("Removed book successfully!");
    }

    public void updateBook(Book currentBook, Book newBook) {
        if(books.contains(currentBook)) {
            currentBook.setName(newBook.getName());
            currentBook.setAuthor(newBook.getAuthor());
            currentBook.setStatus(newBook.getStatus());
            currentBook.setCategory(newBook.getCategory());
            System.out.println("Book updated successfully!");
        }else {
            System.out.println("Book not found!");
        }
    }

    public void lendBook(Book book, Reader reader) {
        if(book.getStatus() == BookStatus.AVAILABLE) {
            book.setStatus(BookStatus.BORROWED);
            book.setBurrower(reader);
            reader.recieveBook(book);
            System.out.println("Book lent successfully!");
        } else if (book.getStatus() == BookStatus.BORROWED){
            System.out.println("Book is currently burrowed by: " + book.getBurrower());
        } else {
            System.out.println("Book is not available on the system!");
        }
    }

    public void takeBackBook(Book book) {
        book.setStatus(BookStatus.AVAILABLE);
        book.setBurrower(null);
        System.out.println("Book successfully returned!");
    }

    public String showBook(Book book) {
        return "Author: " + book.getAuthor() + " Name: " + book.getName();
    }


    @Override
    public List<Book> filterByAuthor(Author author) {
        return books.stream()
                .filter(book -> book.getAuthor().getName().equals(author.getName()))
                .sorted(Comparator.comparing(Book::getName))
                .toList();
    }

    @Override
    public List<Book> filterByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .sorted(Comparator.comparing(Book::getName))
                .toList();
    }

    @Override
    public List<Book> filterByTitle(String title) {
        return books.stream()
                .filter(book -> book.getName().equals(title))
                .sorted(Comparator.comparing(Book::getName))
                .toList();
    }

    @Override
    public List<Book> listAllBooks() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getBookId))
                .toList();
    }
}
