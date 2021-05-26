package DBservice;

import models.Book;
import models.Section;
import repository.actions.SectionRepository;
import repository.actionsImpl.SectionRepositoryImpl;

import java.util.List;

public class SectionDBService {

    private SectionRepository sectionRepository  = new SectionRepositoryImpl();

    public List<Book> retrieveAllSectionBooks() {
        return  sectionRepository.retrieveAllSectionBooks();
    }

    public int addNewSection(Section section) {
        return sectionRepository.addNewSection(section);
    }

    public List<Section> retrieveAllSections() {return sectionRepository.readAllSections();}
}
