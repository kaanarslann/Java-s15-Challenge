package library.model;

import java.time.LocalDateTime;

public class StudyBooks extends Book{
    private String lectureName;
    private String edition;
    private String condition;


    public StudyBooks(int bookId, Author author, String name, String category, String lectureName, String edition, String condition) {
        super(bookId, author, name, category);
        this.lectureName = lectureName;
        this.edition = edition;
        this.condition = condition;
    }
}
