package org.example.Services;

import org.example.entity.Loans;
import org.example.repository.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LoansService extends ServiceImpl<LoanRepository, Loans,Long> {
    public static final Logger logger = LoggerFactory.getLogger(LoansService.class);
    public LoansService(LoanRepository loanRepository) {
        super(loanRepository);
    }

    //section check loan exist
    public static boolean checkLoanExists(long id, String type) {
        if (LoanRepository.checkLoanExists(id, type)) {
            System.out.println("Loan Already Exist try another loan ! ");
            logger.error("Loan already existsuser {} log user already exist",id);
            return false;
        }
        logger.info("loan dose not exist from user id : {}",id);
        return true;
    }

    //section show All
    public static void showAll(int search) {
        LoanRepository loanRepository = new LoanRepository();
        final List<Loans> loans = loanRepository.allLoans();
        if (loans.size() < 1)
            System.out.println("There is No Loan");
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getDaneshjo().getId()==search) {
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
    }
}
