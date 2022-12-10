package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.Enums.Status;
import org.example.Enums.TypeLoan;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Daneshjo daneshjo;

    private LocalDate date;

    @Enumerated(value = EnumType.STRING)
    private TypeLoan typeLoan;

    private Long amount;

    private int tedadAghsat;
    private int aghsateBaghimandeh;

    @Embedded
    private Conditions conditions;

    public Loans(Status status, Daneshjo daneshjo, LocalDate date, TypeLoan typeLoan, Long amount, int tedadAghsat, int aghsateBaghimandeh) {
        this.status = status;
        this.daneshjo = daneshjo;
        this.date = date;
        this.typeLoan = typeLoan;
        this.amount = amount;
        this.tedadAghsat = tedadAghsat;
        this.aghsateBaghimandeh = aghsateBaghimandeh;
    }

    public Loans() {

    }

}
