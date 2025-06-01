package library.model;

import java.time.LocalDateTime;

public class Novels extends Book{
    private int pageCount;


    public Novels(int bookId, Author author, String name, String category, BookStatus status, LocalDateTime dateOfPurchase, int pageCount) {
        super(bookId, author, name, category, status, dateOfPurchase);
        this.pageCount = pageCount;
    }


}
