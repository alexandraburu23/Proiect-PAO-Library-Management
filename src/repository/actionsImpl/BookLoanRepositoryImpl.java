package repository.actionsImpl;

import models.*;
import repository.actions.BookLoanRepository;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static utils.Queries.*;
import static utils.Queries.read_section;

public class BookLoanRepositoryImpl implements BookLoanRepository {
    private DbConnection dbConnection = DbConnection.getInstance();
    public List<BookLoan> readAllLoans(){
        List<BookLoan> bookLoans = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_BOOKLOANS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PreparedStatement preparedStatement2 = dbConnection.getDBConnection().prepareStatement(read_reader((resultSet.getInt(2))));
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                Reader reader = new Reader();
                while(resultSet2.next()){
                    reader.setId(resultSet2.getInt(1));
                    reader.setName(resultSet2.getString(2));
                    reader.setRegistrationDate(LocalDate.parse(resultSet2.getString(3)));
                }
                PreparedStatement preparedStatement3 = dbConnection.getDBConnection().prepareStatement(read_book((resultSet.getInt(2))));
                ResultSet resultSet3 = preparedStatement3.executeQuery();
                Book book = new Book();
                while(resultSet3.next()) {
                    book.setBook_id(resultSet3.getInt(1));
                    book.setName(resultSet3.getString(2));
                    book.setPages(resultSet3.getInt(3));
                    PreparedStatement preparedStatement4 = dbConnection.getDBConnection().prepareStatement(read_author((resultSet3.getInt(4))));
                    ResultSet resultSet4 = preparedStatement4.executeQuery();
                    Author author = new Author();
                    while (resultSet4.next()) {
                        author.setId(resultSet4.getInt(1));
                        author.setName(resultSet4.getString(2));
                    }
                    //System.out.println(author);
                    PreparedStatement preparedStatement5 = dbConnection.getDBConnection().prepareStatement(read_section((resultSet3.getInt(5))));
                    ResultSet resultSet5 = preparedStatement5.executeQuery();
                    Section section = new Section();
                    while (resultSet3.next()) {
                        section.setSection_id(resultSet5.getInt(1));
                        section.setName(resultSet5.getString(2));
                    }

                    book.setAuthor(author);
                    book.setSection(section);
                }
                BookLoan bookLoan = new BookLoan(LocalDate.parse(resultSet.getString(1)),reader, book,LocalDate.parse(resultSet.getString(4)));
                bookLoans.add(bookLoan);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bookLoans;
    }
    public void addNewLoan(BookLoan bookLoan) {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_BOOKLOAN, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,bookLoan.getLoanDate().toString());
            preparedStatement.setString(2,bookLoan.getLoaner().getId().toString());
            preparedStatement.setString(3,bookLoan.getLoanedBook().getBook_id().toString());
            preparedStatement.setString(4,bookLoan.getReturnDate().toString() );
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during adding bookloan");
        }
    }

}
