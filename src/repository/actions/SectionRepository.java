package repository.actions;
import models.Author;
import models.Book;
import models.Section;

import java.util.List;

public interface SectionRepository {

    /**
     *
     * @return a list with all books
     */
    List<Book> retrieveAllSectionBooks();

    /**
     *
     * @param id
     * @return a list of books for a specific section
     */
    List<Book> retrieveBooksForSection(int id);
    List<Section> readAllSections();
    /**
     *
     * @param section
     * @return
     */
    int addNewSection(Section section);

//    /**
//     *
//     * @param book
//     * @return
//     */
//    int addBook(Book book);
}