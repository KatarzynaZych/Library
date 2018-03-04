package com.kodilla.library.controller;

import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private DbService dbService;
    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public Reader getReader (int id){
        return  dbService.getReader(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<Title> getTitles (){
        return dbService.getTitles();
    }

//    dodanie czytelnika,
    @RequestMapping(method = RequestMethod.POST, value = "addReader")
    public void addReader(ReaderDto readerDto){
       // dbService.addReader(readerDto);
    }
//    dodanie tytułu,
    @RequestMapping(method = RequestMethod.POST, value = "addTitle")
    public void addTitle(TitleDto titleDto){
       // dbService.addTitle(titleDto)
    }

//    dodanie egzemplarza,
    @RequestMapping(method = RequestMethod.POST, value = "addCopy")
    public void addCopy(CopyDto copyDto){}

//    zmiana statusu egzemplarza,
    @RequestMapping(method = RequestMethod.PUT, value = "updateState")
    public CopyDto updateState(CopyDto copyDto){
        return new CopyDto(1,new Title("Beginning Java Programming For Dummies", "John Smith", LocalDate.of(2001, 02, 01)), "Lost");
    }

//    sprawdzenie ilości egzemplarzy danego tytułu dostępnych do wypożyczenia,
    @RequestMapping(method = RequestMethod.GET, value = "getNumberOfCopies")
    public int getNumberOfCopies(TitleDto titleDto){
        return 3; }

//    wypożyczenie książki
    @RequestMapping(method = RequestMethod.POST, value = "addToLends")
    public void addToLends(LendsDto lendsDto){}

//    zwrot książki
    @RequestMapping(method = RequestMethod.DELETE, value = "removeFromLends")
    public void removeFromLends(LendsDto lendsDto){}
}
