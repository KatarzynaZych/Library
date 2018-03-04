package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ReaderDto {

    private int id;
    private String name;
    private String surname;
    private LocalDate created;


}
