package repository.actions;

import models.Author;
import models.Book;
import models.BookLoan;
import models.Reader;

import java.util.List;

public interface ReaderRepository {
    /**
     *
     * @return a list with all books
     */
    List<Book> retrieveAllBooksfromReader();
    /**
     *
     * @param reader
     * @return
     */
    int addNewReader(Reader reader);
//    /**
//     *
//     * @param reader
//     * @return
//     */
//    int updateReader(Reader reader);
//
//    /**
//     *
//     * @param reader
//     * @return
//     */
//    int deleteReader(Reader reader);
//    /**
//     *
//     * @return a list with all loans
//     */
    List<Reader> readAllReaders();
    /**
     *
     * @param id
     * @return
     */
    Reader selectReader(int id);
}
