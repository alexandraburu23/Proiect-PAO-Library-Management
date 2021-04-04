import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoanService {
    private List<BookLoan> listLoans;
    private static LoanService instance = null;

    private LoanService() {
        listLoans = new ArrayList<>();
    }

    public static LoanService getInstance() {
        if(instance == null) {
            instance = new LoanService();
        }
        return instance;
    }

    public void addLoan(BookLoan addedBookLoan) {
        boolean exists = false;
        for(BookLoan bl : listLoans)
            if (bl.equals(addedBookLoan)) {
                exists = true;
                break;
            }
        if(!exists) {
            listLoans.add(new BookLoan(addedBookLoan));

        }
    }
    public void deleteLoan(Integer id)
    {
        boolean deleted = false;
        for(int i=0;i<this.listLoans.size();i++){
            if(i==id-1){
                this.listLoans.remove(i);
                deleted=true;
                break;
            }
        }
        if(!deleted){
            System.out.println("This Loan does not exist in this list");
        }
    }

    public void showLoans() {
        for(BookLoan bl : listLoans)
            System.out.println(bl.toString());
    }
}
