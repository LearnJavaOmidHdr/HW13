package org.example.panels;

import org.example.Enums.Status;
import org.example.Enums.TypeLoan;
import org.example.Main;
import org.example.Services.DaneshjoService;
import org.example.Services.LoansService;
import org.example.Services.PaidService;
import org.example.entity.Conditions;
import org.example.entity.Daneshjo;
import org.example.entity.Loans;
import org.example.entity.Paid;
import org.example.exception.InvalidException;
import org.example.exception.NullpointerExeption;
import org.example.repository.DaneshjoRepository;
import org.example.repository.LoanRepository;
import org.example.repository.PaidRepository;
import org.example.validation.GeneratePassword;
import org.example.validation.Validation;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.zip.DataFormatException;


public class UserPanel {

    private static LoanRepository loanRepository = new LoanRepository();
    private static LoansService loansService = new LoansService(loanRepository);
    private static DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
    private static DaneshjoService daneshjoService = new DaneshjoService(daneshjoRepository);

    //section basePanel
    public static void userPanel() {
        System.out.println("________________ \n" +
                "1.request a loan\n" +
                "2.Pay a loan\n" +
                "3.quit");
    }

    public static void selectUserPanel(Long login) throws DataFormatException, SQLException, NullpointerExeption, InvalidException, Invalid {
        DaneshjoService daneshjoService = new DaneshjoService(new DaneshjoRepository());
        final String status = daneshjoService.getStatus(login);
        System.out.print("Enter your Number : ");
        switch (Main.scanner.nextLine()) {
            case "1":
                if (status.equals("daneshjo")) {
                    UserPanel.showLoan();
                    UserPanel.selectLoan(login);
                    break;
                } else {
                    System.out.println("You aren't Daneshjo \nYou cant request a loan");
                    break;
                }
            case "2":
                if (status.equals("fareghTahsil")) {
                    showMyloan(Math.toIntExact(login));
                    final boolean vaziyat = payLoan(login);
                    if (vaziyat) System.out.println("Paid Successfully :) ");
                    else System.out.println("Failed To pay !! ");
                    break;
                } else {
                    System.out.println("You are still Daneshjo\nDo it after you are finished your education");
                    break;
                }
            case "3":
                Run.basePanel();
                Run.start();
                break;
        }
    }

    //section pay loan
    private static boolean payLoan(Long login) throws Invalid {
        System.out.print("Enter ID Loan To pay : ");
        String idLoan = Validation.between(Main.scanner.nextLine());
        Long idL = Long.parseLong(idLoan);

        Paid paid = new Paid();

        DaneshjoService ds = new DaneshjoService(new DaneshjoRepository());
        LoansService ls = new LoansService(new LoanRepository());

        Daneshjo daneshjoPaid = ds.findById(login, Daneshjo.class);
        final Loans LoansById = ls.findById(idL, Loans.class);
        Loans loans = LoansById;
        int aghsateBaghimandeh = loans.getAghsateBaghimandeh();

        if (aghsateBaghimandeh > 1) {
            LocalDate date = LocalDate.now();
            paid.setDaneshjo(daneshjoPaid);
            paid.setDate(date);
            paid.setPeyghiri(GeneratePassword.generatePassword());
            paid.setLoan(LoansById);
            PaidService paidService = new PaidService(new PaidRepository());
            try {
                paidService.create(paid);
                aghsateBaghimandeh -= 1;
                if (aghsateBaghimandeh == 0) {
                    loans.setAghsateBaghimandeh(aghsateBaghimandeh);
                    ls.delete(loans);
                }
                loans.setAghsateBaghimandeh(aghsateBaghimandeh);
                ls.update(loans);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        } else {
            System.out.println("You have already finished this loan");
            return false;
        }
    }

    private static void showMyloan(int idSearch) {
        LoansService loansService = new LoansService(new LoanRepository());
        loansService.showAll(idSearch);
    }


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
    public static void selectLoan(long id) throws InvalidException, DataFormatException, SQLException, NullpointerExeption, Invalid {
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
                showLoanById(id);
                break;
            case "5":
                UserPanel.userPanel();
                UserPanel.selectUserPanel(id);
                break;
            default:
                break;
        }
    }

    //section get information
    private static Conditions getInformation() throws Invalid {
        System.out.print("Enter International of your wife : ");
        String wifeInternational = Main.scanner.nextLine();
        wifeInternational = Validation.validInternational(wifeInternational);
        System.out.print("Enter your Gharardad Number : ");
        String numberGharardad = Main.scanner.nextLine();
        numberGharardad = Validation.numberOne(numberGharardad);
        System.out.print("Enter Your address : ");
        String address = Main.scanner.nextLine();
        address = Validation.validString(address);
        return new Conditions(wifeInternational, numberGharardad, address);
    }

    //section show loan By id
    private static void showLoanById(long id) {
        final List<Loans> loans = LoanRepository.daneshjoLoans(1L);
        if (loans.size() <= 1)
            System.out.println("You have No loans");
        for (Loans loan : loans) {
            System.out.println("You have Loan : " + loan.getTypeLoan());

        }
    }

    //section select loan Tahsili
    private static void selectLoanTahsili(long id, String typeLoan) throws DataFormatException, SQLException, NullpointerExeption, InvalidException, Invalid {

        final Daneshjo fullDaneshjo = daneshjoService.findById(id, Daneshjo.class);
        String real = fullDaneshjo.getMaghtaTahsili().toString();
        System.out.print("Do you want this Loan (y/n) : ");
        final String answer = Main.scanner.nextLine();
        if (answer.contains("y")) {
            if (real.contains("kardani") || real.contains("karshenasiPeyvasteh") || real.contains("karshenasiNaPeyvasteh")) {
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans kardani = createLoan(fullDaneshjo, typeLoan, 1900000L, 60);
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
                    final Loans arshad = createLoan(fullDaneshjo, typeLoan, 2250000L, 60);
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
                    final Loans doctora = createLoan(fullDaneshjo, typeLoan, 2600000L, 60);
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
    private static void selectLoanShahrieh(long id, String typeLoan) throws DataFormatException, SQLException, NullpointerExeption, InvalidException, Invalid {

        final Daneshjo fullDaneshjo = daneshjoService.findById(id, Daneshjo.class);
        String real = fullDaneshjo.getMaghtaTahsili().toString();
        System.out.print("Do you want this Loan (y/n) : ");
        final String answer = Main.scanner.nextLine();
        if (answer.contains("y")) {
            if (real.contains("kardani") || real.contains("karshenasiPeyvasteh") || real.contains("karshenasiNaPeyvasteh")) {
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Loans kardani = createLoan(fullDaneshjo, typeLoan, 1300000L, 60);
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
                    final Loans arshad = createLoan(fullDaneshjo, typeLoan, 2600000L, 60);
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
                    final Loans doctora = createLoan(fullDaneshjo, typeLoan, 65000000L, 60);
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
    private static void selectLoanMaskan(long id, String typeLoan) throws InvalidException, DataFormatException, SQLException, NullpointerExeption, Invalid {

        LoanRepository loanRepository = new LoanRepository();
        final LoansService loansService = new LoansService(loanRepository);
        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
        DaneshjoService daneshjoService = new DaneshjoService(daneshjoRepository);
        final Daneshjo fullDaneshjo = daneshjoService.findById(id, Daneshjo.class);

        System.out.print("Enter your Number :");
        switch (Main.scanner.nextLine()) {
            case "1":
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Conditions information = getInformation();
                    Daneshjo byId = daneshjoRepository.findById(id, Daneshjo.class);
                    final boolean item = daneshjoRepository.existInternational(byId.getInternationalCode());
                    final boolean item2 = daneshjoRepository.existInternational(information.getWifeInternational());
                    if (item || item2) {
                        System.out.println("You or your wife take it this loan already \n" +
                                "you cant request anymore ! ");
                        break;
                    }
                    final Loans Tehran = createLoan(fullDaneshjo, typeLoan, 32000000L, 60);
                    Tehran.setConditions(information);
                    loansService.create(Tehran);
                } else {
                    System.out.println("You have already a loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
                break;
            case "2":
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Conditions information = getInformation();
                    Daneshjo byId = daneshjoRepository.findById(id, Daneshjo.class);
                    final boolean item = daneshjoRepository.existInternational(byId.getInternationalCode());
                    final boolean item2 = daneshjoRepository.existInternational(information.getWifeInternational());
                    if (item || item2) {
                        System.out.println("You or your wife take it this loan already \n" +
                                "you cant request anymore ! ");
                        break;
                    }
                    final Loans Kalanshahr = createLoan(fullDaneshjo, typeLoan, 26000000L, 60);
                    loansService.create(Kalanshahr);
                } else {
                    System.out.println("You have already a loan !! ");
                    UserPanel.showLoan();
                    UserPanel.selectLoan(id);
                }
                break;
            case "3":
                if (LoansService.checkLoanExists(id, typeLoan)) {
                    final Conditions information = getInformation();
                    Daneshjo byId = daneshjoRepository.findById(id, Daneshjo.class);
                    final boolean item = daneshjoRepository.existInternational(byId.getInternationalCode());
                    final boolean item2 = daneshjoRepository.existInternational(information.getWifeInternational());
                    if (item || item2) {
                        System.out.println("You or your wife take it this loan already \n" +
                                "you cant request anymore ! ");
                        break;
                    }
                    final Loans Other = createLoan(fullDaneshjo, typeLoan, 19500000L, 60);
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
    }

    //section create Loan
    public static Loans createLoan(Daneshjo id, String typeLoan, Long amount, int tedadAghsat) throws InvalidException {
        try {
            LocalDate date = LocalDate.now();
            Loans loans = new Loans(Status.request, id, date, TypeLoan.getFromString(typeLoan), amount, tedadAghsat, tedadAghsat);
            return loans;
        } catch (Exception e) {
            throw new InvalidException("Wrong Input");
        }
    }

}
