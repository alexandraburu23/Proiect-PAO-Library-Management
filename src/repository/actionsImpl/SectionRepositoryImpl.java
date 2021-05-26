 package repository.actionsImpl;

import models.Author;
import models.Book;
import models.Section;
import repository.actions.SectionRepository;
import utils.DbConnection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utils.Queries.*;

 public class SectionRepositoryImpl implements SectionRepository {
    private DbConnection dbConnection = DbConnection.getInstance();
    @Override
    public List<Book> retrieveAllSectionBooks() {
        List<Book> bookList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_SECTION_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("executeQuery"+preparedStatement);
            while (resultSet.next()) {
                PreparedStatement preparedStatement2 = dbConnection.getDBConnection().prepareStatement(read_author((resultSet.getInt(4))));
                System.out.println(preparedStatement2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                System.out.println(resultSet2);
                Author author = new Author() ;
                while (resultSet2.next()) {
                    author.setId(resultSet2.getInt(1));
                    author.setName(resultSet2.getString(2));
                }
                System.out.println(author);
                PreparedStatement preparedStatement3 = dbConnection.getDBConnection().prepareStatement(read_section((resultSet.getInt(5))));
                ResultSet resultSet3 = preparedStatement3.executeQuery();
                Section section = new Section();
                while (resultSet3.next()) {
                    section.setSection_id(resultSet3.getInt(1));
                    section.setName(resultSet3.getString(2));
                }
                System.out.println(section);
                Book book = new Book(resultSet.getInt(1), resultSet.getString(2), author, resultSet.getInt(3), section);
                bookList.add(book);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> retrieveBooksForSection(int id) {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(retrieve_books_from_section(id));
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
                //System.out.println(section);
                Book book = new Book(resultSet.getInt(1), resultSet.getString(2), author, resultSet.getInt(3), section);
                bookList.add(book);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public int addNewSection(Section section) {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_SECTION, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, section.getName());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return Integer.parseInt(resultSet.getString(1));
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred during adding section");
        }
    }
     @Override
     public List<Section> readAllSections(){
         List<Section> sectionList = new ArrayList<>();
         try{
             PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_SECTIONS);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 Section section = new Section(resultSet.getInt(1), resultSet.getString(2));
                 sectionList.add(section);
             }
         }catch (SQLException e) {
             e.printStackTrace();
         }
         return sectionList;
     }

}
