package repository.actions;

import models.Book;

import java.util.List;

public interface BookRepository {
    /**
     *
     * @return a list with all books
     */
    List<Book> retrieveAllBooks();
    /**
     *
     * @param book
     * @return
     */
    int addNewBook(Book book);
    /**
     *
     * @param id
     * @return
     */
    Book selectBook(int id);
}
