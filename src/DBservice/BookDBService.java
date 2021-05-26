package DBservice;

import models.Book;
import models.BookLoan;
import repository.actions.BookLoanRepository;
import repository.actions.BookRepository;
import repository.actionsImpl.BookLoanRepositoryImpl;
import repository.actionsImpl.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class BookDBService {
    private BookRepository bookRepository  = new BookRepositoryImpl();

    public int addNewBook(Book book){
        return bookRepository.addNewBook(book);
    }
    public List<Book> readAllBooks(){
        return  bookRepository.retrieveAllBooks();
    }
    public Book selectBook(int id) { return bookRepository.selectBook(id);}
}
