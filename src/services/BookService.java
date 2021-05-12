package services;

import models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> listBooks;
    private static BookService instance = null;

    private BookService() {
        listBooks = new ArrayList<>();
    }

    public static BookService getInstance() {
        if(instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public void addBook(Book addedBook)
    {
        boolean exists = false;
        for(Book b : listBooks)
            if (b.equals(addedBook)) {
                exists = true;
                break;
            }
        if(!exists) {
            listBooks.add(addedBook);

        }
        else{
            this.listBooks.add(new Book (addedBook));
        }

    }

    public void deleteBook(Book deletedBook)
    {
        boolean deleted = false;
        for(int i=0;i<this.listBooks.size();i++){
            if(this.listBooks.get(i).equals(deletedBook)){
                this.listBooks.remove(i);
                deleted=true;
                break;
            }
        }
        if(!deleted){
            System.out.println("This models.Book does not exist in this list");
        }
    }


    public void showBooks() {
        for(Book book : listBooks)
            System.out.println(book.toString());
    }
    public Book returnBook(Integer id, String type){

        for(Book b: listBooks)
        {
            if(b.getBook_id()==id && b.bookType().equals(type)){
                System.out.println(id);
                return b;
            }
        }
        return null;
    }
}
