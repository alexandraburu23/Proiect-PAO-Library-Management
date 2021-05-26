package repository.actionsImpl;

import models.Author;
import models.Book;
import models.Section;
import repository.actions.BookRepository;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utils.Queries.*;

public class BookRepositoryImpl implements BookRepository {
    private DbConnection dbConnection = DbConnection.getInstance();
    @Override
    public List<Book> retrieveAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PreparedStatement preparedStatement2 = dbConnection.getDBConnection().prepareStatement(read_author((resultSet.getInt(4))));
                //System.out.println(preparedStatement2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                //System.out.println(resultSet2);
                Author author = new Author();
                while (resultSet2.next()) {
                    author.setId(resultSet2.getInt(1));
                    author.setName(resultSet2.getString(2));
                }
                //System.out.println(author);
                PreparedStatement preparedStatement3 = dbConnection.getDBConnection().prepareStatement(read_section((resultSet.getInt(5))));
                ResultSet resultSet3 = preparedStatement3.executeQuery();
                Section section = new Section();
                while (resultSet3.next()) {
                    section.setSection_id(resultSet3.getInt(1));
                    section.setName(resultSet3.getString(2));
                }
                Book book = new Book(resultSet.getInt(1), resultSet.getString(2), author, resultSet.getInt(3), section);
                bookList.add(book);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
    @Override
    public int addNewBook(Book book){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_BOOK, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getPages().toString());
            preparedStatement.setString(3,book.getAuthor().getId().toString());
            preparedStatement.setString(4,book.getSection().getSection_id().toString());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return Integer.parseInt(resultSet.getString(1));
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during adding bookloan");
        }

    }
    public Book selectBook(int id) {
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(read_book(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PreparedStatement preparedStatement2 = dbConnection.getDBConnection().prepareStatement(read_author((resultSet.getInt(4))));
                //System.out.println(preparedStatement2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                //System.out.println(resultSet2);
                Author author = new Author();
                while (resultSet2.next()) {
                    author.setId(resultSet2.getInt(1));
                    author.setName(resultSet2.getString(2));
                }
                //System.out.println(author);
                PreparedStatement preparedStatement3 = dbConnection.getDBConnection().prepareStatement(read_section((resultSet.getInt(5))));
                ResultSet resultSet3 = preparedStatement3.executeQuery();
                Section section = new Section();
                while (resultSet3.next()) {
                    section.setSection_id(resultSet3.getInt(1));
                    section.setName(resultSet3.getString(2));
                }
                Book book = new Book(resultSet.getInt(1), resultSet.getString(2), author, resultSet.getInt(3), section);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
