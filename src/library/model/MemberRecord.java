package library.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MemberRecord {
    private Reader reader;
    private double balance = 0.0;
    private int bookCount;
    private String address;
    private String phoneNumber;
    private LocalDateTime dateOfMembership;
    private Map<Book, LocalDateTime> borrowHistory;

    public MemberRecord(Reader reader) {
        this.reader = reader;
        this.borrowHistory = new HashMap<>();
    }

    public MemberRecord(Reader reader, String address, String phoneNumber, LocalDateTime dateOfMembership, Map<Book, LocalDateTime> borrowHistory) {
        this.reader = reader;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfMembership = dateOfMembership;
        this.borrowHistory = borrowHistory;
    }

    public double getBalance() {
        return balance;
    }

    public void updateHistory(Book book, LocalDateTime dateTime, double price) {
        borrowHistory.put(book, dateTime);
        reduceBalance(price);
    }

    public void reduceBalance(double price) {
        balance -= price;
        bookCount += 1;
        System.out.println("Your current balance is: " + balance);
    }

    public void increaseBalance(double price) {
        balance += price;
        bookCount -= 1;
        System.out.println("Your current balance is: " + balance);
    }

    public int getBookCount() {
        return bookCount;
    }
}
