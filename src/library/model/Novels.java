package library.model;

import java.time.LocalDateTime;

public class Novels extends Book{
    private int pageCount;


    public Novels(int bookId, Author author, String name, String category, int pageCount) {
        super(bookId, author, name, category);
        this.pageCount = pageCount;
    }


}
