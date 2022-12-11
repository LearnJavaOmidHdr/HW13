package org.example.Services;

import org.example.entity.Paid;
import org.example.repository.PaidRepository;

public class PaidService extends ServiceImpl<PaidRepository, Paid,Long> {
    public PaidService(PaidRepository paidRepository) {
        super(paidRepository);
    }
}
