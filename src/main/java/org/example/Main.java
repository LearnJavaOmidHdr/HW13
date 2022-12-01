package org.example;

import org.example.Services.DaneshjoService;
import org.example.entity.Daneshjo;
import org.example.panels.Run;
import org.example.repository.DaneshjoRepository;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
        Run.basePanel();
        Daneshjo daneshjo = Run.register();
        DaneshjoService daneshjoService = new DaneshjoService(daneshjoRepository);
        daneshjoService.create(daneshjo);
    }


}