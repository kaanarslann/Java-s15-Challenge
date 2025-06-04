package library.model;

import library.util.Validator;

import java.util.*;

public class Reader extends Person{
    private Set<Book> books;
    private double money;
    private MemberRecord record;


    public Reader(int id, String name) {
        super(id, name);
        this.money = 250.50;
        this.books = new HashSet<>();
    }

    public Set<Book> getBooks() {
        if(books.isEmpty()) {
            System.out.println("Reader does not have any book!");
        }
        return Collections.unmodifiableSet(books);
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public MemberRecord getRecord() {
        return record;
    }

    public void setRecord(MemberRecord record) {
        this.record = record;
    }

    public void requestBorrow(Book book, Librarian librarian) {
        Validator.validate(book);
        Validator.validate(librarian);
        librarian.approveBorrow(book, this);
    }

    public void recieveBook(Book book) {
        books.add(book);
    }

    public void returnBook(Book book, Librarian librarian) {
        Validator.validate(book);
        Validator.validate(librarian);
        if(books.contains(book)) {
            librarian.approveReturn(book, this);
            books.remove(book);
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String whoYouAre() {
        return "Reader";
    }

}
