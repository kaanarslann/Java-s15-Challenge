package library.model;

import library.util.Validator;

import java.time.LocalDateTime;
import java.util.*;

public class Reader extends Person{
    private Set<Book> books;
    private double money;
    private MemberRecord record;


    public Reader(int id, String name) {
        super(id, name);
        this.books = new HashSet<>();
    }

    public Reader(int id, String name, double money, MemberRecord record) {
        super(id, name);
        this.money = money;
        this.books = new HashSet<>();
        this.record = record;
    }

    public Set<Book> getBooks() {
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

    @Override
    public String whoYouAre() {
        return "Reader";
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

}
