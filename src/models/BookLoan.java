package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookLoan {
    private LocalDate loanDate;
    private Reader loaner;
    private Book loanedBook;
    private LocalDate returnDate;

    public BookLoan() {
        this.loanDate = LocalDate.now();
        this.loaner = new Reader();
        this.loanedBook = new Book();
        this.returnDate = LocalDate.now();
    }

    public BookLoan(Reader loaner, Book loanedBook, LocalDate returnDate) {
        this.loanDate = LocalDate.now();
        this.loaner = loaner;
        this.loanedBook = new Book(loanedBook);
        this.returnDate = returnDate;
    }
    public BookLoan(LocalDate loanDate, Reader loaner, Book loanedBook, LocalDate returnDate) {
        this.loanDate = loanDate;
        this.loaner = loaner;
        this.loanedBook = new Book(loanedBook);
        this.returnDate = returnDate;
    }

    public BookLoan(BookLoan bookloan){
        this.loanDate = bookloan.getLoanDate();
        this.loaner = bookloan.getLoaner();
        this.loanedBook = bookloan.getLoanedBook();
        this.returnDate = bookloan.getReturnDate();
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public Reader getLoaner() {
        return loaner;
    }

    public void setLoaner(Reader loaner) {
        this.loaner = loaner;
    }

    public Book getLoanedBook() {
        return loanedBook;
    }

    public void setLoanedBook(Book loanedBook) {
        this.loanedBook = loanedBook;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "models.BookLoan{" +
                "loanDate=" + loanDate +
                ", loaner=" + loaner +
                ", loanedBook=" + loanedBook +
                ", returnDate=" + returnDate +
                '}';
    }
}
