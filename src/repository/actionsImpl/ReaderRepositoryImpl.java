package repository.actionsImpl;

import models.Author;
import models.Book;
import models.Reader;
import models.Section;
import repository.actions.ReaderRepository;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static utils.Queries.*;
import static utils.Queries.INSERT_NEW_AUTHOR;

public class ReaderRepositoryImpl implements ReaderRepository {
    private DbConnection dbConnection = DbConnection.getInstance();
    public List<Book> retrieveAllBooksfromReader() {
        List<Book> bookList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_READER_BOOKS);
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
    public int addNewReader(Reader reader) {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_READER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getRegistrationDate().toString());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return Integer.parseInt(resultSet.getString(1));
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during adding reader");
        }
    }

//    public void updateReader(Reader reader){
//
//    }
    public List<Reader> readAllReaders(){
        List<Reader> readerList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_READERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reader reader = new Reader(resultSet.getInt(1), resultSet.getString(2), LocalDate.parse(resultSet.getString(3)));
                readerList.add(reader);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return readerList;
    }
    public Reader selectReader(int id){
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(read_reader(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reader reader = new Reader(resultSet.getInt(1), resultSet.getString(2), LocalDate.parse(resultSet.getString(3)));
                return reader;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
