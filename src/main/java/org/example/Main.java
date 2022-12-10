package org.example;

import org.example.DataBaseConnection.SingleTonConnection;
import org.example.entity.Loans;
import org.example.exception.InvalidException;
import org.example.exception.NullpointerExeption;
import org.example.panels.Run;
import org.example.repository.AdminRepository;
import org.example.repository.DaneshjoRepository;
import org.example.repository.LoanRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.omg.CORBA.DynAnyPackage.Invalid;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {

    public final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NullpointerExeption, DataFormatException, SQLException, InvalidException, Invalid {
//        Run.basePanel();
//        Run.start();

        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
        System.out.println(daneshjoRepository.getStatus(1L));
//        final Long aLong = daneshjoRepository.existInternational("4310831877");
//        System.out.println(aLong);

    }
}