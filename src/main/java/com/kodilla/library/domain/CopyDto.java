package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CopyDto {

    private int copyId;
    private Title title;
    private String state;
}