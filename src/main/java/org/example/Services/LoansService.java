package org.example.Services;

import org.example.entity.Loans;
import org.example.repository.LoanRepository;

public class LoansService extends ServiceImpl<LoanRepository, Loans,Long> {
    public LoansService(LoanRepository loanRepository) {
        super(loanRepository);
    }
    public static boolean checkLoanExists(long id,String type) {
        if (LoanRepository.checkLoanExists(id,type)){
            System.out.println("Loan Already Exist try another loan ! ");
            return false;
        }
        return true;
    }
}
