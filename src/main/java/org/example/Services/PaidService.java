package org.example.Services;

import org.example.entity.Paid;
import org.example.repository.PaidRepository;

import java.util.List;

public class PaidService extends ServiceImpl<PaidRepository, Paid,Long> {
    public PaidService(PaidRepository paidRepository) {
        super(paidRepository);
    }

    public List<Paid> listPaid(Long id) {
        PaidRepository paidRepository = new PaidRepository();
        return paidRepository.listPaid(id);
    }
}
