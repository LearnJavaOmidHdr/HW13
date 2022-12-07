package org.example.panels;

import org.example.Enums.Status;
import org.example.Enums.TypeLoan;
import org.example.Main;
import org.example.Services.DaneshjoService;
import org.example.Services.LoansService;
import org.example.entity.Daneshjo;
import org.example.entity.Loans;
import org.example.exception.InvalidException;
import org.example.exception.NullpointerExeption;
import org.example.repository.DaneshjoRepository;
import org.example.repository.LoanRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.zip.DataFormatException;


public class UserPanel {

    private static LoanRepository loanRepository = new LoanRepository();
    private static LoansService loansService = new LoansService(loanRepository);
    private static DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
    private static DaneshjoService daneshjoService = new DaneshjoService(daneshjoRepository);

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
    public static void selectLoan(long id) throws InvalidException, DataFormatException, SQLException, NullpointerExeption {
        switch (Main.scanner.nextLine()) {
            case "1":
                showMaskanLoan();
                selectLoanMaskan(id, "maskan");
                break;
            case "2":
                showShahriehLoan();
                selectLoanShahrieh(id, "shahrieh");
                break;
            case "3":
                showTahsiliLoan();
                selectLoanTahsili(id, "tahsili");
                break;
            case "4":
                showLoanById();
                break;
            case "5":
                Run.basePanel();
                Run.start();
                break;
            default:
                break;
        }
    }

    //section show loan By id
    private static void showLoanById(long id) {
        

    }

    //section select loan Tahsili
    private static void selectLoanTahsili(long id, String typeLoan) throws DataFormatException, SQLException, NullpointerExeption, InvalidException {

        final Daneshjo fullDaneshjo = daneshjoService.findById(id, Daneshjo.class);
        String real = fullDaneshjo.getMaghtaTahsili().toString();
        System.out.print("Do you want this Loan (y/n) : ");
        final String answer = Main.scanner.nextLine();
        if (answer.contains("y")) {
            if (real.contains("kardani") || real.contains("karshenasiPeyvasteh") || real.contains("karshenasiNaPeyvasteh")) {
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans kardani = createLoan(fullDaneshjo, typeLoan, 1900000L);
                    loansService.create(kardani);
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                } else {
                    System.out.println("You have already requested this loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
            } else if (real.contains("karshenasiArshadPeyvasteh") || real.contains("karshenasiArshadNaPeyvasteh") || real.contains("doctoraHerfei") || real.contains("doctoaPeyvasteh,")) {

                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans arshad = createLoan(fullDaneshjo, typeLoan, 2250000L);
                    loansService.create(arshad);
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                } else {
                    System.out.println("You have already requested this loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
            } else {
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans doctora = createLoan(fullDaneshjo, typeLoan, 2600000L);
                    loansService.create(doctora);
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                } else {
                    System.out.println("You have already requested this loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
            }
        } else {
            UserPanel.showLoan();
            UserPanel.selectLoan(id);
        }
    }

    //section select loan shahrieh
    private static void selectLoanShahrieh(long id, String typeLoan) throws DataFormatException, SQLException, NullpointerExeption, InvalidException {

        final Daneshjo fullDaneshjo = daneshjoService.findById(id, Daneshjo.class);
        String real = fullDaneshjo.getMaghtaTahsili().toString();
        System.out.print("Do you want this Loan (y/n) : ");
        final String answer = Main.scanner.nextLine();
        if (answer.contains("y")) {
            if (real.contains("kardani") || real.contains("karshenasiPeyvasteh") || real.contains("karshenasiNaPeyvasteh")) {
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans kardani = createLoan(fullDaneshjo, typeLoan, 1300000L);
                    loansService.create(kardani);
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                } else {
                    System.out.println("You have already requested this loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
            } else if (real.contains("karshenasiArshadPeyvasteh") || real.contains("karshenasiArshadNaPeyvasteh") || real.contains("doctoraHerfei") || real.contains("doctoaPeyvasteh,")) {

                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans arshad = createLoan(fullDaneshjo, typeLoan, 2600000L);
                    loansService.create(arshad);
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                } else {
                    System.out.println("You have already requested this loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
            } else {
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans doctora = createLoan(fullDaneshjo, typeLoan, 65000000L);
                    loansService.create(doctora);
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                } else {
                    System.out.println("You have already requested this loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
            }
        } else {
            UserPanel.showLoan();
            UserPanel.selectLoan(id);
        }
    }

    // section select Load Maskan
    private static void selectLoanMaskan(long id, String typeLoan) throws InvalidException, DataFormatException, SQLException, NullpointerExeption {

        LoanRepository loanRepository = new LoanRepository();
        final LoansService loansService = new LoansService(loanRepository);
        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
        DaneshjoService daneshjoService = new DaneshjoService(daneshjoRepository);
        final Daneshjo fullDaneshjo = daneshjoService.findById(id, Daneshjo.class);

        System.out.print("Enter your Number :");
        switch (Main.scanner.nextLine()) {
            case "1":
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans Tehran = createLoan(fullDaneshjo, typeLoan, 32000000L);
                    loansService.create(Tehran);
                } else {
                    System.out.println("You have already a loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
                break;
            case "2":
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans Kalanshahr = createLoan(fullDaneshjo, typeLoan, 26000000L);
                    loansService.create(Kalanshahr);
                } else {
                    System.out.println("You have already a loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
                break;
            case "3":
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans Other = createLoan(fullDaneshjo, typeLoan, 19500000L);
                    loansService.create(Other);
                } else {
                    System.out.println("You have already a loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
                break;
            case "4":
                UserPanel.showLoan();
                UserPanel.selectLoan(id);
                break;
            default:
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
    public static Loans createLoan(Daneshjo id, String typeLoan, Long amount) throws InvalidException {
        try {
            LocalDate date = LocalDate.now();
            Loans loans = new Loans(Status.request, id, date, TypeLoan.getFromString(typeLoan), amount);
            return loans;
        } catch (Exception e) {
            throw new InvalidException("Wrong Input");
        }
    }

}
