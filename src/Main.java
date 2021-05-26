import DBservice.*;
import csv.CSVReadingService;
import csv.CSVWritingService;
import models.*;
import services.AuthorService;
import services.BookService;
import services.LoanService;
import services.ReaderService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    public static int numberLines(String path)
    {
        int index = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (reader.readLine() != null)
                index++;
        }catch(IOException e){
            System.out.println("error opening file");
        }
        return index;
    }
    public static void main(String args[]) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        ReaderService rs = ReaderService.getInstance();
        AuthorService as = AuthorService.getInstance();
        BookService bs = BookService.getInstance();
        LoanService ls = LoanService.getInstance();
        CSVReadingService csvReader = CSVReadingService.getInstance();
        CSVWritingService csvWriter = CSVWritingService.getInstance();
        List<Reader> readerItems = csvReader.readReaders();

        for(int i=0;i<readerItems.toArray().length;i++){
            rs.addReader(readerItems.get(i));
        }
        List<Student> studentItems = csvReader.readStudents();
        for(int i=0;i<studentItems.toArray().length;i++){
            rs.addReader(studentItems.get(i));
        }
        List<Author> authorItems = csvReader.readAuthors();
        for(int i=0;i<authorItems.toArray().length;i++){
            as.addAuthor(authorItems.get(i));
        }
        List<Book> bookItems = csvReader.readBooks();
        for(int i=0;i<bookItems.toArray().length;i++){
            bs.addBook(bookItems.get(i));
        }
        List<TextBook> textBooks = csvReader.readTextbooks();
        for(int i=0;i<textBooks.toArray().length;i++){
            bs.addBook(textBooks.get(i));
        }
        List<BookLoan> bookLoans = csvReader.readBookLoan(bs);
        for(int i=0;i<bookLoans.toArray().length;i++){
            ls.addLoan(bookLoans.get(i));
        }
        Integer index = 0;
        System.out.println(
                bs.returnBook(1,"TextBook")
        );

        while (true){
        System.out.println("Meniu");
        System.out.println("1.Aratati lista de carti");
        System.out.println("2.Aratati lista de autori");
        System.out.println("3.Aratati lista de cititori");
        System.out.println("4.Arati lista de imprumuturi");
        System.out.println("5.Adaugati o carte");
        System.out.println("6.Adaugati un autor");
        System.out.println("7.Adaugati un cititor");
        System.out.println("8.Adaugati un imprumut");
        System.out.println("9.Stergeti o carte");
        System.out.println("10.Stergeti un imprumut");
        System.out.println("11.Editati baza de date");
        String option=br.readLine();
        if(option.equals("1")){
            csvWriter.writeAudit("SHOW","Book", LocalDate.now());
            bs.showBooks();
            csvWriter.writeAudit("SHOW","TextBook", LocalDate.now());
        } else if(option.equals("2")){
            csvWriter.writeAudit("SHOW","Author", LocalDate.now());
            as.showAuthors();
        } else if(option.equals("3")){
            csvWriter.writeAudit("SHOW","Reader", LocalDate.now());
            rs.showReaders();
            csvWriter.writeAudit("SHOW","Student", LocalDate.now());
        } else if(option.equals("4")){
            csvWriter.writeAudit("SHOW","BookLoan",LocalDate.now());
            ls.showLoans();
        }else if(option.equals("5")){
            csvWriter.writeAudit("INSERT","Book",LocalDate.now());
            System.out.println("1.Adaugati carte");
            System.out.println("2.Adaugati manual");
            String option2=br.readLine();
            if(option2.equals("1")){
                Integer id=numberLines("authors.csv");
                System.out.println("Nume");
                String name= br.readLine();
                System.out.println("Pagini");
                Integer pg = parseInt(br.readLine());
                System.out.println("Introduceti datele autorului");
                System.out.println("Id");
                Integer aid = parseInt(br.readLine());
                System.out.println("Nume");
                String aname = br.readLine();
                System.out.println("Introduceti datele sectiunii");
                System.out.println("Id");
                Integer sid = parseInt(br.readLine());
                System.out.println("Nume");
                String sname = br.readLine();
                Section newsection = new Section(sid,sname);
                Author newauthor = new Author(aid,aname);
                Book newbook = new Book(id,name,newauthor,pg,newsection);
                bs.addBook(newbook);
                if(as.addAuthor(newauthor)){
                    csvWriter.writeAuthors(newauthor);
                }
                csvWriter.writeBooks(newbook);
                System.out.println("Autor adaugat automat");

            }else{
                Integer id=numberLines("src/textbooks.csv");
                System.out.println("Nume");
                String name= br.readLine();
                System.out.println("Pagini");
                Integer pg = parseInt(br.readLine());
                System.out.println("Domeniu");
                String field= br.readLine();
                System.out.println("Introduceti datele autorului");
                System.out.println("Id");
                Integer aid = parseInt(br.readLine());
                System.out.println("Nume");
                String aname = br.readLine();
                System.out.println("Introduceti datele sectiunii");
                System.out.println("Id");
                Integer sid = parseInt(br.readLine());
                System.out.println("Nume");
                String sname = br.readLine();
                Section newsection = new Section(sid,sname);
                Author newauthor = new Author(aid,aname);
                TextBook newtextbook = new TextBook(id,name,newauthor,pg,newsection,field);
                bs.addBook(newtextbook);
                if(as.addAuthor(newauthor)){
                    csvWriter.writeAuthors(newauthor);
                }
                csvWriter.writeTextbooks(newtextbook);
                System.out.println("Autor adaugat automat");
            }

        }else if(option.equals("6")){
            csvWriter.writeAudit("INSERT","Author",LocalDate.now());
            Integer aid = numberLines("src/authors.csv");
            System.out.println("Nume");
            String aname = br.readLine();
            Author newauthor = new Author(aid,aname);
            as.addAuthor(newauthor);
            csvWriter.writeAuthors(newauthor);
        }else if(option.equals("7")){
            csvWriter.writeAudit("INSERT","Reader",LocalDate.now());
            System.out.println("1.Adaugati cititor obisnuit");
            System.out.println("2.Adaugati student");
            String option3=br.readLine();
            if(option3.equals("1")){
                csvWriter.writeAudit("INSERT","Book",LocalDate.now());
                Integer id=numberLines("src/readers.csv");
                System.out.println("Nume");
                String name= br.readLine();
                LocalDate ld = LocalDate.now();
                Reader newreader = new Reader(id,name,ld);
                rs.addReader(newreader);
                csvWriter.writeReaders(newreader);

            }else{
                Integer id=numberLines("csv/students.csv");
                System.out.println("Nume");
                String name= br.readLine();
                LocalDate ld = LocalDate.now();
                System.out.println("Universitate");
                String uni = br.readLine();
                Student newstudent = new Student(id,name,ld,uni);
                rs.addReader(newstudent);
                csvWriter.writeStudents(newstudent);
            }

        }else if(option.equals( "8")){
            csvWriter.writeAudit("INSERT","BookLoan",LocalDate.now());
            String type;
            System.out.println("Ce tip de carte selectati? 0-Carte, 1-Manual");
            if(br.readLine()=="0"){
                System.out.println("Va aratam lista de carti,selectati id-ul ");
                bs.showBooks();
                type="Book";
            }else{
                System.out.println("Va aratam lista de manuale,selectati id-ul ");
                bs.showBooks();
                type="TextBook";
            }
            Integer selectedId =parseInt(br.readLine());
            Book selectedBook = bs.returnBook(selectedId,type);
            System.out.println("Ce tip de cititor selectati? 0-normal, 1-student");
            if(br.readLine()=="0"){
                System.out.println("Va aratam lista de cititori,selectati id-ul ");
                rs.showReaders();
            }else{
                System.out.println("Va aratam lista de studenti,selectati id-ul ");
                rs.showReaders();
            }
            Integer readerId =parseInt(br.readLine());
            Reader selectedReader = rs.returnReader(readerId);
            LocalDate ld = LocalDate.now();
            LocalDate rd = ld.plusMonths(2);
            BookLoan newloan = new BookLoan(ld,selectedReader,selectedBook,rd);
            csvWriter.writeBookLoan(newloan,selectedId,type);
            ls.addLoan(newloan);


        }else if(option.equals("9")){
            csvWriter.writeAudit("DELETE","Book",LocalDate.now());
            System.out.println("Ce tip de carte selectati? 0-Carte, 1-Manual");
            String type;
            if(br.readLine()=="0"){
                System.out.println("Va aratam lista de carti,selectati id-ul ");
                bs.showBooks();
                type="Book";
            }else{
                System.out.println("Va aratam lista de manuale,selectati id-ul ");
                bs.showBooks();
                type="TextBook";
            }
            System.out.println("Va aratam lista de carti,selectati id-ul pe care vreti sa il stergeti");
            bs.showBooks();
            Integer selectedId =parseInt(br.readLine());
            Book selectedBook = bs.returnBook(selectedId,type);
            bs.deleteBook(selectedBook);

        }else if(option.equals("10")){
            csvWriter.writeAudit("DELETE","LoanBook",LocalDate.now());
            System.out.println("Va aratam lista de imprumuturi,selectati id-ul pe care vreti sa il stergeti");
            ls.showLoans();
            Integer selectedId =parseInt(br.readLine());
            ls.deleteLoan(selectedId);
        }
        else {
            break;
        }
        index+=1;
        }
        SectionDBService sectionService = new SectionDBService();
        AuthorDBService authorService = new AuthorDBService();
        LoanDBService loanService = new LoanDBService();
        BookDBService bookService = new BookDBService();
        ReaderDBService readerService = new ReaderDBService();

//        List<Book> books = sectionService.retrieveAllSectionBooks();
//        System.out.println("Am preluat cartile: ");
//        System.out.println(books);
//
//        Section section = new Section("Lifestyle");
//        int sectionId = sectionService.addNewSection(section);
//        System.out.println("Am adaugat libraria cu id-ul " + sectionId);

        while (true) {
            System.out.println("Meniu");
            System.out.println("1.Aratati lista de carti");
            System.out.println("2.Aratati lista de autori");
            System.out.println("3.Aratati lista de cititori");
            System.out.println("4.Aratati lista de imprumuturi");
            System.out.println("5.Aratati lista de sectiuni");
            System.out.println("6.Adaugati o carte");
            System.out.println("7.Adaugati un autor");
            System.out.println("8.Adaugati un cititor");
            System.out.println("9.Adaugati un imprumut");
            System.out.println("10.Adaugati o sectiune");
            System.out.println("11.Exit");
            String option = br.readLine();
            if (option.equals("1")) {
                csvWriter.writeAudit("SHOW", "Book", LocalDate.now());
                System.out.println(bookService.readAllBooks());
            } else if (option.equals("2")) {
                csvWriter.writeAudit("SHOW", "Author", LocalDate.now());
                System.out.println(authorService.retrieveAllAuthors());
            } else if (option.equals("3")) {
                csvWriter.writeAudit("SHOW", "Reader", LocalDate.now());
                System.out.println(readerService.readAllReaders());
            } else if (option.equals("4")) {
                csvWriter.writeAudit("SHOW", "BookLoan", LocalDate.now());
                System.out.println(loanService.readAllLoans());
            }else if (option.equals("5")) {
                csvWriter.writeAudit("SHOW", "Section", LocalDate.now());
                System.out.println(sectionService.retrieveAllSections());
            } else if (option.equals("6")) {
                csvWriter.writeAudit("INSERT", "Book", LocalDate.now());
                Integer id = numberLines("authors.csv");
                System.out.println("Nume");
                String name = br.readLine();
                System.out.println("Pagini");
                Integer pg = parseInt(br.readLine());
                System.out.println("Introduceti datele autorului");
                System.out.println("Id");
                Integer aid = parseInt(br.readLine());
                System.out.println("Nume");
                String aname = br.readLine();
                System.out.println("Introduceti datele sectiunii");
                System.out.println("Id");
                Integer sid = parseInt(br.readLine());
                System.out.println("Nume");
                String sname = br.readLine();
                Section newsection = new Section(sid, sname);
                Author newauthor = new Author(aid, aname);
                Book newbook = new Book(id, name, newauthor, pg, newsection);
                bookService.addNewBook(newbook);


            } else if (option.equals("7")) {
                csvWriter.writeAudit("INSERT", "Author", LocalDate.now());
                Integer aid = numberLines("src/authors.csv");
                System.out.println("Nume");
                String aname = br.readLine();
                Author newauthor = new Author(aid, aname);
                authorService.addNewAuthor(newauthor);

            } else if (option.equals("8")) {
                csvWriter.writeAudit("INSERT", "Reader", LocalDate.now());
                Integer id = numberLines("src/readers.csv");
                System.out.println("Nume");
                String name = br.readLine();
                LocalDate ld = LocalDate.now();
                Reader newreader = new Reader(id, name, ld);
                readerService.addNewReader(newreader);

            } else if (option.equals("9")) {
                csvWriter.writeAudit("INSERT", "BookLoan", LocalDate.now());
                System.out.println("Va aratam lista de carti,selectati id-ul ");
                System.out.println(bookService.readAllBooks());
                Integer selectedId = parseInt(br.readLine());
                Book selectedBook = bookService.selectBook(selectedId);
                System.out.println(readerService.readAllReaders());
                Integer readerId = parseInt(br.readLine());
                Reader selectedReader = readerService.selectReader(readerId);
                LocalDate ld = LocalDate.now();
                LocalDate rd = ld.plusMonths(2);
                BookLoan newloan = new BookLoan(ld, selectedReader, selectedBook, rd);
                loanService.addNewLoan(newloan);

            } else if (option.equals("10")) {
                csvWriter.writeAudit("INSERT", "SECTION", LocalDate.now());
                Integer aid = numberLines("src/section.csv");
                System.out.println("Nume");
                String sname = br.readLine();
                Section newsection = new Section(aid, sname);
                sectionService.addNewSection(newsection);

            } else {
                break;
            }
        }
    }
}
