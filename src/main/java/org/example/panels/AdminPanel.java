package org.example.panels;

import org.example.Main;
import org.example.Services.AdminService;

public class AdminPanel {

    //section panel
    public static void panel(){
        System.out.println("_______________ \n" +
                "1. Show Loans Requested \n" +
                "2. Confirm Loan\n" +
                "3. Reject Loan]n" +
                "4. Quit");
        System.out.print("Enter Your Number : ");
    }

    //section select
    public static void select(){
        switch (Main.scanner.nextLine()){
            case "1":
                findAll();
                break;

                
        }
    }
    //section findAll
    public static void findAll(){
        AdminService adminservice = new AdminService();
        adminservice.showAll("request");

    }

}
