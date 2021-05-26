package DBservice;

import models.Author;
import models.Book;
import models.Section;
import repository.actions.AuthorRepository;
import repository.actions.SectionRepository;
import repository.actionsImpl.AuthorRepositoryImpl;
import repository.actionsImpl.SectionRepositoryImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthorDBService {
    private AuthorRepository authorRepository  = new AuthorRepositoryImpl();

    public List<Book> retrieveAllAuthorBooks() {
        return  authorRepository.retrieveAllAuthorBooks();
    }

    public int addNewAuthor(Author author) {
        return authorRepository.addNewAuthor(author);
    }

    public List<Author> retrieveAllAuthors() { return authorRepository.readAllAuthors();}
}
