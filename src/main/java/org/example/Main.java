package org.example;

import org.example.entity.Daneshjo;
import org.example.exception.InvalidException;
import org.example.exception.NullpointerExeption;
import org.example.panels.Run;
import org.example.repository.DaneshjoRepository;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {

    public final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NullpointerExeption, DataFormatException, SQLException, InvalidException {
        Run.basePanel();
        Run.start();
//        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
//        final Daneshjo byId = daneshjoRepository.findById(4L, Daneshjo.class);
//        byId.setFatherName("ali");
//        daneshjoRepository.update(byId);
//        System.out.println(byId.getFatherName());


    }
}