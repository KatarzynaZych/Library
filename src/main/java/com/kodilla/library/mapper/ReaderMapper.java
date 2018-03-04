package com.kodilla.library.mapper;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto){
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getCreated());
    }

    public ReaderDto mapToReaderDto(final ReaderDto reader){
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getCreated());
    }

}
