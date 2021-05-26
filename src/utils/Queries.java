package utils;

//protected int book_id;
//protected String name;
//protected Author author;
//protected Integer pages;
//protected Section section;
public class Queries {
    public static final String RETRIEVE_ALL_SECTION_BOOKS = "SELECT b.bookId,b.name,b.authorId,b.sectionId,b.pages FROM pao2021.section sec\n" +
            "inner join pao2021.book b\n" +
            "on sec.sectionId = b.sectionId;";
    public static final String RETRIEVE_ALL_BOOKS_FROM_SECTION = "SELECT b.bookId,b.name,b.authorId,b.sectionId,b.pages FROM pao2021.book b\n" +
            "where b.sectionId = ";
    public static final String INSERT_NEW_BOOK = "INSERT INTO book(bookId, name, pages, authorId, sectionId) values (null,?,?,?,?)";
    public static final String INSERT_NEW_SECTION = "INSERT INTO section(sectionId,name) values (null,?)";
    public static final String INSERT_NEW_AUTHOR = "INSERT INTO author(authorId,name) values (null,?)";
    public static final String INSERT_NEW_READER = "INSERT INTO reader(readerId,name,registrationDate) values (null,?,?)";
    public static final String INSERT_NEW_BOOKLOAN = "INSERT INTO bookloan(loanDate,readerId,bookId,returndate) values (?,?,?,?)";
    public static final String READ_AUTHOR = "SELECT a.authorId, a.name from pao2021.author a\n"+
            "where a.authorId = ";
    public static final String READ_SECTION = "SELECT s.sectionId, s.name from pao2021.section s\n"+
            "where s.sectionId = ";
    public static final String READ_BOOK = "SELECT b.bookId,b.name,b.authorId,b.sectionId,b.pages from pao2021.book b\n"+
            "where b.bookId = ";
    public static final String RETRIEVE_ALL_AUTHOR_BOOKS = "SELECT b.bookId,b.name,b.authorId,b.sectionId,b.pages FROM pao2021.author a\n" +
            "inner join pao2021.book b\n" +
            "on a.authorId = b.authorId;";
    public static final String RETRIEVE_ALL_READERS = "SELECT * FROM pao2021.reader ;" ;
    public static final String RETRIEVE_ALL_BOOKLOANS = "SELECT * FROM pao2021.bookloan ;" ;
    public static final String RETRIEVE_ALL_BOOKS = "SELECT * FROM pao2021.book ;" ;
    public static final String RETRIEVE_ALL_AUTHORS = "SELECT * FROM pao2021.author ;" ;
    public static final String RETRIEVE_ALL_SECTIONS = "SELECT * FROM pao2021.section ;" ;
    public static final String READ_READER = "SELECT * from pao2021.reader\n"+
            "where readerId = ";
    public static final String RETRIEVE_ALL_READER_BOOKS = "SELECT b.bookId,b.name,b.authorId,b.sectionId,b.pages FROM pao2021.bookloan bl\n" +
            "inner join pao2021.book b\n" +
            "on bl.bookId = b.bookId;";

    public static String read_author(Integer id){
        return READ_AUTHOR + id.toString() + ";";
    }
    public static String read_section(Integer id){
        return READ_SECTION + id.toString() + ";";
    }
    public static String read_book(Integer id){
        return READ_BOOK + id.toString() + ";";
    }
    public static String read_reader(Integer id){
        return READ_READER + id.toString() + ";";
    }
    public static String retrieve_books_from_section(Integer id){
        return RETRIEVE_ALL_BOOKS_FROM_SECTION + id.toString() +";";
    }
}