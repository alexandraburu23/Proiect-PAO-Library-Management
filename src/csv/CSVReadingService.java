package csv;

import jdk.jshell.execution.LoaderDelegate;
import models.*;
import services.AuthorService;
import services.BookService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CSVReadingService {
    private static CSVReadingService instance = null;
    public static CSVReadingService getInstance() {
        if(instance == null) {
            instance = new CSVReadingService();
        }
        return instance;
    }
    public List<Section> readSections(){
        List<Section> sections = new ArrayList<Section>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/sections.csv"));
            while ((line = br.readLine()) != null)
            {
                Section section = new Section();
                System.out.println(line);
                String[] sectionItems = line.split(splitBy);
                section.setSection_id(parseInt(sectionItems[0]));
                section.setName(sectionItems[1]);
                sections.add(section);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return sections;
    }

    public List<Book> readBooks(){
        List<Book> books = new ArrayList<Book>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/books.csv"));
            while ((line = br.readLine()) != null)
            {
                Book book = new Book();
                String[] bookItems = line.split(splitBy);
                book.setBook_id(parseInt(bookItems[0]));
                book.setName(bookItems[1]);
                book.setPages(parseInt(bookItems[2]));
                Author author = new Author();
                author.setId(parseInt(bookItems[3]));
                author.setName(bookItems[4]);
                book.setAuthor(author);
                Section section = new Section();
                section.setSection_id(parseInt(bookItems[5]));
                section.setName(bookItems[6]);
                book.setSection(section);
                books.add(book);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return books;
    }
    public List<TextBook> readTextbooks(){
        List<TextBook> textbooks = new ArrayList<TextBook>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/textbooks.csv"));
            while ((line = br.readLine()) != null)
            {
                TextBook textbook = new TextBook();
                String[] textBookItems = line.split(splitBy);
                textbook.setBook_id(parseInt(textBookItems[0]));
                textbook.setName(textBookItems[1]);
                textbook.setPages(parseInt(textBookItems[2]));
                Author author = new Author();
                author.setId(parseInt(textBookItems[3]));
                author.setName(textBookItems[4]);
                textbook.setAuthor(author);
                Section section = new Section();
                section.setSection_id(parseInt(textBookItems[5]));
                section.setName(textBookItems[6]);
                textbook.setSection(section);
                textbook.setField(textBookItems[7]);
                textbooks.add(textbook);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return textbooks;
    }
    public List<Reader> readReaders(){
        List<Reader> readers = new ArrayList<Reader>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/readers.csv"),'\t');
            while ((line = br.readLine()) != null)
            {
                Reader reader = new Reader();
                String[] readerItems = line.split(splitBy);
                reader.setId(parseInt(readerItems[0]));
                reader.setName(readerItems[1]);
                reader.setRegistrationDate(LocalDate.parse(readerItems[2]));
                readers.add(reader);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return readers;
    }
    public List<Student> readStudents(){
        List<Student> students = new ArrayList<Student>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/students.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] studentItems = line.split(splitBy);
                Student student = new Student();
                student.setId(parseInt(studentItems[0]));
                student.setName(studentItems[1]);
                student.setRegistrationDate(LocalDate.parse(studentItems[2]));
                student.setUniversity(studentItems[3]);
                students.add(student);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return students;
    }
    public List<BookLoan> readBookLoan(BookService bs){
        List<BookLoan> bookloans = new ArrayList<BookLoan>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/bookloans.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] bookloanItems = line.split(splitBy);
                BookLoan bookloan = new BookLoan();
                bookloan.setLoanDate(LocalDate.parse(bookloanItems[0]));
                bookloan.setReturnDate(LocalDate.parse(bookloanItems[1]));
                String[] bookId = bookloanItems[2].split("-");
//                System.out.println(bookloanItems[2]);
//                System.out.println(bookId[0]);
                Book loanedBook = bs.returnBook(parseInt(bookId[1]),bookId[0]);
                System.out.println(loanedBook);
                bookloan.setLoanedBook(loanedBook);

                if(bookloanItems.length==6) {
                    Reader reader = new Reader();
                    reader.setId(parseInt(bookloanItems[3]));
                    reader.setName(bookloanItems[4]);
                    reader.setRegistrationDate(LocalDate.parse(bookloanItems[5]));
                    bookloan.setLoaner(reader);
                }else{
                    Student student = new Student();
                    student.setId(parseInt(bookloanItems[3]));
                    student.setName(bookloanItems[4]);
                    student.setRegistrationDate(LocalDate.parse(bookloanItems[5]));
                    student.setUniversity(bookloanItems[6]);
                    bookloan.setLoaner(student);
                }
                bookloans.add(bookloan);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bookloans;

    }
    public List<Author> readAuthors(){
        List<Author> authors = new ArrayList<Author>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/authors.csv"));
            while ((line = br.readLine()) != null)
            {
                Author author = new Author();
                String[] authorItems = line.split(splitBy);
                author.setId(parseInt(authorItems[0]));
                author.setName(authorItems[1]);
                authors.add(author);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return authors;
    }
}
