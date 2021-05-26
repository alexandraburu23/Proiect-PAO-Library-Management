package repository.actionsImpl;

import models.Author;
import models.Book;
import models.Reader;
import models.Section;
import repository.actions.AuthorRepository;
import repository.actions.SectionRepository;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static utils.Queries.*;

public class AuthorRepositoryImpl implements AuthorRepository {
        private DbConnection dbConnection = DbConnection.getInstance();
        @Override
        public List<Book> retrieveAllAuthorBooks() {
            List<Book> bookList = new ArrayList<>();
            try{
                PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_AUTHOR_BOOKS);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    PreparedStatement preparedStatement2 = dbConnection.getDBConnection().prepareStatement(read_author((resultSet.getInt(4))));
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    Author author = new Author(resultSet2.getInt(1),resultSet2.getString(2));
                    PreparedStatement preparedStatement3 = dbConnection.getDBConnection().prepareStatement(read_section((resultSet.getInt(4))));
                    ResultSet resultSet3 = preparedStatement2.executeQuery();
                    Section section = new Section(resultSet3.getInt(1),resultSet3.getString(2));
                    Book book = new Book(resultSet.getInt(1), resultSet.getString(2), author, resultSet.getInt(3), section);
                    bookList.add(book);
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return bookList;
        }

        @Override
        public List<Book> retrieveBooksForAuthor(String name) {
            return null;
        }

        @Override
        public int addNewAuthor(Author author) {
            ResultSet resultSet;
            try{
                PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_AUTHOR, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, author.getName());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                return Integer.parseInt(resultSet.getString(1));
            }catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Some problem ocurred during adding author");
            }
        }

        @Override
        public int addBook(Book book) {
            return 0;
        }

        @Override
        public List<Author> readAllAuthors(){
            List<Author> authorList = new ArrayList<>();
            try{
                PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_AUTHORS);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Author author = new Author(resultSet.getInt(1), resultSet.getString(2));
                    authorList.add(author);
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return authorList;
        }
}


