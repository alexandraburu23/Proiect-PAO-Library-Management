package repository.actions;

import models.Book;
import models.BookLoan;
import models.Reader;

import java.util.List;

public interface BookLoanRepository {
    /**
     *
     * @param bookLoan
     * @return
     */
    void addNewLoan(BookLoan bookLoan);

//    /**
//     *
//     * @param bookLoan
//     * @return
//     */
//    int updateLoan(BookLoan bookLoan);
//
//    /**
//     *
//     * @param bookLoan
//     * @return
//     */
//    int deleteLoan(BookLoan bookLoan);

    /**
     *
     * @return a list with all loans
     */
    List<BookLoan> readAllLoans();
}
