package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Readers")
public class Reader {

    public Reader(String name, String surname, LocalDate created) {
        this.name = name;
        this.surname = surname;
        this.created = created;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "created")
    private LocalDate created;
}
