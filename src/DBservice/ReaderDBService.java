package DBservice;

import models.Book;
import models.Reader;
import repository.actions.AuthorRepository;
import repository.actions.ReaderRepository;
import repository.actionsImpl.AuthorRepositoryImpl;
import repository.actionsImpl.ReaderRepositoryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReaderDBService {
    private ReaderRepository readerRepository  = new ReaderRepositoryImpl();
    public List<Book> retrieveAllBooksfromReader(){
        return readerRepository.retrieveAllBooksfromReader();
    }
    public int addNewReader(Reader reader){
        return readerRepository.addNewReader(reader);
    }
    public List<Reader> readAllReaders(){
        return  readerRepository.readAllReaders();
    }
    public Reader selectReader(int id) { return readerRepository.selectReader(id);}
}
