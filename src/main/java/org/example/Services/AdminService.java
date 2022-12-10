package org.example.Services;

import org.example.entity.Daneshjo;
import org.example.entity.Loans;
import org.example.repository.AdminRepository;
import org.example.repository.DaneshjoRepository;

import java.util.List;

import static org.example.Enums.Status.request;

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
        final List<Loans> loans = adminRepository.daneshjoLoans();
        if (loans.size() < 1)
            System.out.println("There is No Request");

        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getStatus().toString().equals(string)) {
                System.out.println("______________________________________");
                System.out.println("ID : " + loans.get(i).getId());
                System.out.println("Status : " + loans.get(i).getStatus());
                System.out.println("Amount : " + loans.get(i).getAmount());
                System.out.println("Date : " + loans.get(i).getDate());
                System.out.println("Type Loan : " + loans.get(i).getTypeLoan());
                System.out.println("Daneshjo ID : " + loans.get(i).getDaneshjo().getId());
                System.out.println("______________________________________");
            }
        }
        /*
        loans.forEach(loans1 -> {
            System.out.println("ID : "+ loans1.getId());
            System.out.println("Amount : "+ loans1.getAmount());
            System.out.println("Date : "+ loans1.getDate());
            System.out.println("Status : "+ loans1.getStatus());
            System.out.println("Type Loan : "+ loans1.getTypeLoan());
            System.out.println("Daneshjo ID : "+ loans1.getDaneshjo());
        });
         */
    }
    //section confirm
    public void confirm(String confirm) {
        AdminRepository adminRepository = new AdminRepository();
        final List<Loans> loans = adminRepository.daneshjoLoans();
        if (loans.size() < 1)
            System.out.println("There is No Request");

        for (int i = 0; i < loans.size(); i++) {
            final long id = loans.get(i).getId();
            String s = String.valueOf(id);
            if (s.equals(confirm)){
                DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
                daneshjoRepository.update(new Daneshjo());
                long idL = loans.get(i).getId();
                System.out.println("User : ");
                System.out.println("______________________________________");
                System.out.println("ID : " + loans.get(i).getId());
                System.out.println("Status : " + loans.get(i).getStatus());
                System.out.println("Amount : " + loans.get(i).getAmount());
                System.out.println("Date : " + loans.get(i).getDate());
                System.out.println("Type Loan : " + loans.get(i).getTypeLoan());
                System.out.println("Daneshjo ID : " + loans.get(i).getDaneshjo().getId());
                System.out.println("______________________________________");
                System.out.println("Confirm it");
                String name = String.valueOf(loans.get(i).getId());

            }
        }
    }
}
