package csv;

import models.*;
import models.Reader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import static java.nio.file.StandardOpenOption.*;
import static java.nio.file.StandardOpenOption.APPEND;

public class CSVWritingService {
    private static CSVWritingService instance = null;
    public static CSVWritingService getInstance() {
        if(instance == null) {
            instance = new CSVWritingService();
        }
        return instance;
    }
    public void writeSections(Section section){
        StringBuilder sb = new StringBuilder();
        sb.append(section.getSection_id());
        sb.append(',');
        sb.append(section.getName());
        sb.append('\n');
        byte[] bsb = sb.toString().getBytes();
        try{
            Files.write(Paths.get("src/sections.csv"), bsb, StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("unsuccessful");
        }
    }

    public void writeBooks(Book book){
        StringBuilder sb = new StringBuilder();
        sb.append(book.getBook_id());
        sb.append(',');
        sb.append(book.getName());
        sb.append(',');
        sb.append(book.getPages());
        sb.append(',');
        sb.append(book.getAuthor().getId());
        sb.append(',');
        sb.append(book.getAuthor().getName());
        sb.append(',');
        sb.append(book.getSection().getSection_id());
        sb.append(',');
        sb.append(book.getSection().getName());
        sb.append('\n');
        byte[] bsb = sb.toString().getBytes();
        try{
            Files.write(Paths.get("src/books.csv"), bsb, StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("unsuccessful");
        }
    }
    public void writeTextbooks(TextBook textBook){
         StringBuilder sb = new StringBuilder();
         sb.append(textBook.getBook_id());
         sb.append(',');
         sb.append(textBook.getName());
         sb.append(',');
         sb.append(textBook.getPages());
         sb.append(',');
         sb.append(textBook.getAuthor().getId());
         sb.append(',');
         sb.append(textBook.getAuthor().getName());
         sb.append(',');
         sb.append(textBook.getSection().getSection_id());
         sb.append(',');
         sb.append(textBook.getSection().getName());
         sb.append('\n');
         byte[] bsb = sb.toString().getBytes();
         try{
             Files.write(Paths.get("src/textbooks.csv"), bsb, StandardOpenOption.APPEND);
         }catch(IOException e){
             System.out.println("unsuccessful");
         }
    }
    public void writeReaders(Reader reader){
        StringBuilder sb = new StringBuilder();
        sb.append(reader.getId());
        sb.append(',');
        sb.append(reader.getName());
        sb.append(',');
        sb.append(reader.getRegistrationDate());
        sb.append('\n');
        byte[] bsb = sb.toString().getBytes();
        try{
            Files.write(Paths.get("src/readers.csv"), bsb, StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("unsuccessful");
        }
    }
    public void writeStudents(Student student){
        StringBuilder sb = new StringBuilder();
        sb.append(student.getId());
        sb.append(',');
        sb.append(student.getName());
        sb.append(',');
        sb.append(student.getRegistrationDate());
        sb.append(',');
        sb.append(student.getUniversity());
        sb.append('\n');
        byte[] bsb = sb.toString().getBytes();
        try{
            Files.write(Paths.get("src/students.csv"), bsb, StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("unsuccessful");
        }
    }
    public void writeBookLoan(BookLoan bookLoan, Integer BookId, String type){
        StringBuilder sb = new StringBuilder();
        sb.append(bookLoan.getLoanDate());
        sb.append(',');
        sb.append(bookLoan.getReturnDate());
        sb.append(',');
        sb.append(type);
        sb.append('-');
        sb.append(BookId);
        sb.append(',');
        Reader loaner = bookLoan.getLoaner();
        sb.append(loaner.toString());
        sb.append('\n');
        byte[] bsb = sb.toString().getBytes();
        try{
            Files.write(Paths.get("src/bookloans.csv"), bsb, StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("unsuccessful");
        }
    }
    public void writeAuthors(Author author){
        StringBuilder sb = new StringBuilder();
        sb.append(author.getId());
        sb.append(',');
        sb.append(author.getName());
        sb.append('\n');
        byte[] bsb = sb.toString().getBytes();
        try{
            Files.write(Paths.get("src/authors.csv"), bsb, StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("unsuccessful");
        }
    }
    public void writeAudit( String operation, String entity, LocalDate date) {
        int index = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/audit.csv"));
            while (reader.readLine() != null)
                index++;
        }catch(IOException e){
            System.out.println("error opening audit");
        }

        try{
            StringBuilder sb = new StringBuilder();
            sb.append(index);
            sb.append(',');
            sb.append(operation);
            sb.append(',');
            sb.append(entity);
            sb.append(',');
            sb.append(date.toString());
            sb.append('\n');
            System.out.println(sb);
            byte[] bsb = sb.toString().getBytes();
            Files.write(Paths.get("src/audit.csv"), bsb, StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println("unsuccessful");
        }
    }
}
