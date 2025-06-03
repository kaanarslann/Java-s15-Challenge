package library.util;

import library.model.Author;
import library.model.Book;
import library.model.Novels;

import java.util.List;

public interface BookFilterable {
    List<Book> filterByAuthor(String authorName);
    List<Book> filterByCategory(String category);
    List<Book> filterByTitle(String title);
    List<Book> listAllBooks();
}
