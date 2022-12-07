package org.example.panels;

import org.example.Enums.Status;
import org.example.Enums.TypeLoan;
import org.example.Main;
import org.example.Services.LoansService;
import org.example.entity.Daneshjo;
import org.example.entity.Loans;
import org.example.exception.InvalidException;
import org.example.repository.DaneshjoRepository;
import org.example.repository.LoanRepository;
import java.time.LocalDate;


public class UserPanel {

    // section showLoan
    public static void showLoan() {
        System.out.println("Select your loan ");
        System.out.println("________________________\n" +
                "1. Maskan \n" +
                "2. Shahrieh \n" +
                "3. Tahsili \n" +
                "4. Show My loans \n" +
                "5. Quit ");
        System.out.print("Enter your Number : ");
    }

    //section select loan
    public static void selectLoan(long daneshjo) throws InvalidException {
        switch (Main.scanner.nextLine()) {
            case "1":
                showMaskanLoan();
                String typeLoan = "maskan";
                selectLoanMaskan(daneshjo ,typeLoan);
                break;
            case "2":
                showShahriehLoan();
                break;
            case "3":
                showTahsiliLoan();
                break;
            case "5":
                Run.basePanel();
                break;
            default:
                break;
        }
    }

    // section select Load Maskan
    private static void selectLoanMaskan(long daneshjo , String typeLoan) throws InvalidException {
        switch (Main.scanner.nextLine()) {
            case "1":
                LoanRepository loanRepository = new LoanRepository();
                final LoansService loansService = new LoansService(loanRepository);
//                Long amount = 32000000l;
                DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
                final Daneshjo byId = daneshjoRepository.findById(daneshjo, Daneshjo.class);
//                System.out.println(byId.getFatherName());
//                final Loans loan = createLoan(daneshjo, typeLoan , amount);
//                loansService.create(loan);
                break;
        }
    }

    //section show shahrieh loan
    private static void showShahriehLoan() {
        System.out.println("____________________\n" +
                "1. (kardani - karshenasiPeyvasteh - karshenasiNapeyvasteh ) '1/300/000' \n" +
                "2. (karshenasiArshad Peyvasteh va Napeyvasteh - DoctoraHerfei va Peyvasteh) '2/600/000' \n" +
                "3. (Doctora Takhasosi Napeyvasteh) '65/000/000'");
    }

    //section show tahsili loan
    private static void showTahsiliLoan() {
        System.out.println("____________________ \n" +
                "1. (kardani - karshenasiPeyvasteh - karshenasiNapeyvasteh ) '1/900/000' \n" +
                "2. (karshenasiArshad Peyvasteh va Napeyvasteh - DoctoraHerfei va Peyvasteh) '2/250/000' \n" +
                "3. (Doctora Takhasosi Napeyvasteh) '2/600/000' \n");
    }

    //section maskan loan
    private static void showMaskanLoan() {
        System.out.println("______________\n" +
                "1. Tehran '32/000/000' \n" +
                "2. Kalanshahr '26/000/000' \n" +
                "3. Other '19/500/000'\n" +
                "4. Back");
        System.out.println("Select Your City : ");
    }

    //section create Loan
    public static Loans createLoan(Daneshjo daneshjo, String typeLoan, Long amount) throws InvalidException {
        try {
            LocalDate date = LocalDate.now();
            Loans loans = new Loans(Status.request,daneshjo,date,TypeLoan.getFromString(typeLoan),amount);
            return loans;
        } catch (Exception e) {
            throw new InvalidException("Wrong Input");
        }
    }

}
