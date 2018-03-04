package com.kodilla.library.service;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private TitleRepository titleRepository;


    public Reader getReader(int id){
        return readerRepository.findById(id);
    }

    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Title addTitle(Title title) {
        return titleRepository.save(title);
    }

    public List<Title> getTitles(){ return titleRepository.findAll();
    }

}
