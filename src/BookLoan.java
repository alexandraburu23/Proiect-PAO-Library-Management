import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookLoan {
    protected LocalDate loanDate;
    protected Reader loaner;
    protected List<Book> loanedBooks;
    protected LocalDate returnDate;

    public BookLoan( Reader loaner, List<Book> loanedBooks, LocalDate returnDate) {
        this.loanDate = LocalDate.now();
        this.loaner = loaner;
        this.loanedBooks = new ArrayList<>(loanedBooks);
        this.returnDate = returnDate;
    }
    public BookLoan(LocalDate loanDate, Reader loaner, List<Book> loanedBooks, LocalDate returnDate) {
        this.loanDate = loanDate;
        this.loaner = loaner;
        this.loanedBooks = new ArrayList<>(loanedBooks);
        this.returnDate = returnDate;
    }

    public BookLoan(BookLoan bookloan){
        this.loanDate = bookloan.getLoanDate();
        this.loaner = bookloan.getLoaner();
        this.loanedBooks = new ArrayList<>(bookloan.getLoanedBooks());
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

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(List<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanDate=" + loanDate +
                ", loaner=" + loaner +
                ", loanedBooks=" + loanedBooks +
                ", returnDate=" + returnDate +
                '}';
    }
}
