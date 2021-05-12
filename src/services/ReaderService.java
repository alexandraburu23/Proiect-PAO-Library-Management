package services;

import models.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReaderService {
    private List<Reader> listReaders;
    private static ReaderService instance = null;

    private ReaderService() {
        listReaders = new ArrayList<>();
    }

    public static ReaderService getInstance() {
        if(instance == null) {
            instance = new ReaderService();
        }
        return instance;
    }

    public void addReader(Reader addedReader) {
        boolean exists = false;
        for(Reader r : listReaders)
            if (r.equals(addedReader)) {
                exists = true;
                break;
            }
        if(!exists) {
            listReaders.add(new Reader(addedReader));
            sortReaders();
        }
    }



    private void sortReaders() {
        Collections.sort(listReaders);
    }

    public void showReaders() {
        for(Reader r : listReaders)
            System.out.println(r.toString());
    }
    public Reader returnReader(Integer id){
        for(Reader r : listReaders)
        {   if(r.getId()==id){
                return r;
            }
        }
        return null;
    }
}
