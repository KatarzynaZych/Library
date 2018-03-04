package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Lends")
public class Lends {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lendId")
    private int lendId;

    @ManyToOne
    @JoinColumn(name = "copyId")
    private Copy copy;

    @ManyToOne
    @JoinColumn(name = "readerId")
    private Reader reader;

    @Column(name = "FirstDay")
    private LocalDate lendDate;

    @Column(name = "LastDay")
    private LocalDate returnDate;


}
