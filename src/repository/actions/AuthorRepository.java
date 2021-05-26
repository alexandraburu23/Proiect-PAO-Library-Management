package repository.actions;

import models.Author;
import models.Book;
import models.Section;

import java.util.List;

public interface AuthorRepository {

    /**
     *
     * @return a list with all books
     */
    List<Book> retrieveAllAuthorBooks();

    /**
     *
     * @param name
     * @return a list of books for a specific library
     */
    List<Book> retrieveBooksForAuthor(String name);

    /**
     *
     * @param author
     * @return
     */
    int addNewAuthor(Author author);

    /**
     *
     * @param book
     * @return
     */
    int addBook(Book book);

    List<Author> readAllAuthors();
}
