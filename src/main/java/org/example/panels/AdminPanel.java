package org.example.panels;

import org.example.Main;
import org.example.Services.AdminService;
import org.example.validation.Validation;
import org.omg.CORBA.DynAnyPackage.Invalid;

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
    public static void select() throws Invalid {
        switch (Main.scanner.nextLine()){
            case "1":
                findAll();
                break;
            case "2":
                confirmLoan();
                break;

                
        }
    }

    //section confirm Loan
    private static void confirmLoan() throws Invalid {
        AdminService adminservice = new AdminService();
        System.out.print("Enter Id to Confirm : ");
        String confirm = Main.scanner.nextLine();
        confirm = Validation.numberOne(confirm);
        adminservice.confirm(confirm);

    }

    //section findAll
    public static void findAll(){
        AdminService adminservice = new AdminService();
        adminservice.showAll("request");

    }

}
