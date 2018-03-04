package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class LendsDto {

    private int copyId;
    private int readerId;
    private LocalDate lendDate;
    private LocalDate returnDate;
}
