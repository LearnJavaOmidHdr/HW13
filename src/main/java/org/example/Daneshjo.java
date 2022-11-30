package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "daneshjo")
public class Daneshjo {

    @Id
    private int id;
    private String name;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String internationalCode;
    private String shenasname;
    private Date date;
    private String daneshjoiNumber;
    private String nameUnivercity;
    private Enum<TypeUnivercity> typeUnivercity;
    private String yearEnter;
    private Enum<maghtaTahsili> maghtaTahsili;

}
