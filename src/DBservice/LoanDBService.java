package DBservice;

import models.Book;
import models.BookLoan;
import models.Reader;
import repository.actions.BookLoanRepository;
import repository.actions.ReaderRepository;
import repository.actionsImpl.BookLoanRepositoryImpl;
import repository.actionsImpl.ReaderRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class LoanDBService {
    private BookLoanRepository loanRepository  = new BookLoanRepositoryImpl();

    public void addNewLoan(BookLoan bookLoan){
        loanRepository.addNewLoan(bookLoan);
    }
    public List<BookLoan> readAllLoans(){
        return  loanRepository.readAllLoans();
    }
}
