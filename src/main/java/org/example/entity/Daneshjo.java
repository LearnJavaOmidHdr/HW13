package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enums.TypeUnivercity;
import org.example.Enums.MaghtaTahsili;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "daneshjo")
public class Daneshjo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "international_code", unique = true)
    private String internationalCode;

    @Column(unique = true)
    private String shenasname;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date brithDate;

    @Column(name = "daneshjoi_number", unique = true)
    private String daneshjoiNumber;

    @Column(name = "name_univercity")
    private String nameUnivercity;

    @Column(name = "type_univercity")
    @Enumerated(value = EnumType.STRING)
    private TypeUnivercity typeUnivercity;

    @Column(name = "year_enter")
    private String yearEnter;

    @Column(name = "maghta_Tahsili")
    @Enumerated(value = EnumType.STRING)
    private MaghtaTahsili maghtaTahsili;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "password")
    private String password;


    public Daneshjo(String name, String lastName, String fatherName, String motherName, String internationalCode, String shenasname, Date brithDate, String daneshjoiNumber, String nameUnivercity, TypeUnivercity typeUnivercity, String yearEnter, MaghtaTahsili maghtaTahsili, String userName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.internationalCode = internationalCode;
        this.shenasname = shenasname;
        this.brithDate = brithDate;
        this.daneshjoiNumber = daneshjoiNumber;
        this.nameUnivercity = nameUnivercity;
        this.typeUnivercity = typeUnivercity;
        this.yearEnter = yearEnter;
        this.maghtaTahsili = maghtaTahsili;
        this.userName = userName;
        this.password = password;
    }

    public Daneshjo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
