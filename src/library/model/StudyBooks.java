package library.model;

import java.time.LocalDateTime;

public class StudyBooks extends Book{
    private String lectureName;
    private String edition;
    private String condition;


    public StudyBooks(int bookId, Author author, String name, String category, BookStatus status, LocalDateTime dateOfPurchase, String lectureName, String edition, String condition) {
        super(bookId, author, name, category, status, dateOfPurchase);
        this.lectureName = lectureName;
        this.edition = edition;
        this.condition = condition;
    }
}
