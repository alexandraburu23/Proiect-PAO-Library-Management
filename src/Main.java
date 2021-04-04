import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String args[]) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        ReaderService rs = ReaderService.getInstance();
        AuthorService as = AuthorService.getInstance();
        BookService bs = BookService.getInstance();
        LoanService ls = LoanService.getInstance();

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
        System.out.println("11.Exit");
        String option=br.readLine();
        if(option.equals("1")){
            bs.showBooks();
        } else if(option.equals("2")){
            as.showAuthors();
        } else if(option.equals("3")){
            rs.showReaders();
        } else if(option.equals("4")){
            ls.showLoans();
        }else if(option.equals("5")){
            System.out.println("1.Adaugati carte");
            System.out.println("2.Adaugati manual");
            String option2=br.readLine();
            if(option2.equals("1")){
                System.out.println("Id");
                Integer id=parseInt(br.readLine());
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
                as.addAuthor(newauthor);
                System.out.println("Autor adaugat automat");


            }else{
                System.out.println("Id");
                Integer id=parseInt(br.readLine());
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
                Book newtextbook = new TextBook(id,name,newauthor,pg,newsection,field);
                bs.addBook(newtextbook);
                as.addAuthor(newauthor);
                System.out.println("Autor adaugat automat");
            }

        }else if(option.equals("6")){
            System.out.println("Id");
            Integer aid = parseInt(br.readLine());
            System.out.println("Nume");
            String aname = br.readLine();
            Author newauthor = new Author(aid,aname);
            as.addAuthor(newauthor);
        }else if(option.equals("7")){
            System.out.println("1.Adaugati cititor obisnuit");
            System.out.println("2.Adaugati student");
            String option3=br.readLine();
            if(option3.equals("1")){
                System.out.println("Id");
                Integer id=parseInt(br.readLine());
                System.out.println("Nume");
                String name= br.readLine();
                LocalDate ld = LocalDate.now();
                Reader newreader = new Reader(id,name,ld);
                rs.addReader(newreader);


            }else{
                System.out.println("Id");
                Integer id=parseInt(br.readLine());
                System.out.println("Nume");
                String name= br.readLine();
                LocalDate ld = LocalDate.now();
                System.out.println("Universitate");
                String uni = br.readLine();
                Student newstudent = new Student(id,name,ld,uni);
                rs.addReader(newstudent);

            }

        }else if(option.equals( "8")){
            System.out.println("Va aratam lista de carti,selectati id-urile pe care vreti sa le imprumutati,scrieti exit atunci cand ati terminat");
            bs.showBooks();
            List<Book> selectedBooks = new ArrayList<>();
            while(true){

                String selection= br.readLine();
                if(!selection.equals("exit")){
                    Integer selectedId =parseInt(selection);
                    Book selectedBook = bs.returnBook(selectedId);
                    selectedBooks.add(new Book(selectedBook));

                }else{
                    break;
                }
            }
            System.out.println("Va aratam lista de cititori,selectati id-ul ");
            rs.showReaders();
            Integer idr=parseInt(br.readLine());
            Reader selectedReader = rs.returnReader(idr);
            LocalDate ld = LocalDate.now();
            LocalDate rd = ld.plusMonths(2);
            BookLoan newloan = new BookLoan(ld,selectedReader,selectedBooks,rd);
            ls.addLoan(newloan);


        }else if(option.equals("9")){
            System.out.println("Va aratam lista de carti,selectati id-ul pe care vreti sa il stergeti");
            bs.showBooks();
            Integer selectedId =parseInt(br.readLine());
            Book selectedBook = bs.returnBook(selectedId);
            bs.deleteBook(selectedBook);

        }else if(option.equals("10")){
            System.out.println("Va aratam lista de imprumuturi,selectati id-ul pe care vreti sa il stergeti");
            ls.showLoans();
            Integer selectedId =parseInt(br.readLine());
            ls.deleteLoan(selectedId);
        }
        else {
            break;
        }
        }
    }
}
