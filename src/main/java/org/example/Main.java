package org.example;

import org.example.DataBaseConnection.SingleTonConnection;
import org.example.entity.Daneshjo;
import org.example.exception.InvalidException;
import org.example.exception.NullpointerExeption;
import org.example.panels.Run;
import org.example.repository.DaneshjoRepository;
import org.example.repository.LoanRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {

    public final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NullpointerExeption, DataFormatException, SQLException, InvalidException {
        Run.basePanel();
        Run.start();

    }
}