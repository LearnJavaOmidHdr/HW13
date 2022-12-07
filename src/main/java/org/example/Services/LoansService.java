package org.example.Services;

import org.example.entity.Loans;
import org.example.repository.LoanRepository;

public class LoansService extends ServiceImpl<LoanRepository, Loans,Long> {
    public LoansService(LoanRepository loanRepository) {
        super(loanRepository);
    }
}
