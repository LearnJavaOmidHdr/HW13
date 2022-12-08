package org.example.Services;

import org.example.entity.Daneshjo;
import org.example.entity.Loans;
import org.example.repository.AdminRepository;

import java.util.List;
import java.util.stream.Stream;

public class AdminService {
    //section login
    public static boolean login(Daneshjo daneshjo) {
        if (AdminRepository.login(daneshjo)) {
            System.out.println("Admin Logged in Successfully");
            return true;
        }
        return false;
    }

    //section show All
    public static void showAll(String string) {
       AdminRepository adminRepository = new AdminRepository();
        final List<Loans> loans = adminRepository.daneshjoLoans(string);
//        if (loans.size() < 1)
//            System.out.println("There is No Request");
        for (Loans loan:loans) {
            System.out.println(loan);
        }
//        loans.forEach(loans1 -> {
//            System.out.println("ID : "+ loans1.getId());
//            System.out.println("Amount : "+ loans1.getAmount());
//            System.out.println("Date : "+ loans1.getDate());
//            System.out.println("Status : "+ loans1.getStatus());
//            System.out.println("Type Loan : "+ loans1.getTypeLoan());
//            System.out.println("Daneshjo ID : "+ loans1.getDaneshjo());
//        });

    }

}
