package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enums.TypeUnivercity;
import org.example.Enums.maghtaTahsili;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "daneshjo")
public class Daneshjo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String internationalCode;
    private String shenasname;
    private Date brithDate;
    private String daneshjoiNumber;
    private String nameUnivercity;
    private Enum<TypeUnivercity> typeUnivercity;
    private String yearEnter;
    private Enum<maghtaTahsili> maghtaTahsili;

}
