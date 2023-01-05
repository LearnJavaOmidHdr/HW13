package org.example.Services;

import org.example.entity.Paid;
import org.example.repository.PaidRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PaidService extends ServiceImpl<PaidRepository, Paid,Long> {
    public static final Logger logger = LoggerFactory.getLogger(PaidService.class);
    public PaidService(PaidRepository paidRepository) {
        super(paidRepository);
    }

    public List<Paid> listPaid(Long id) {
        PaidRepository paidRepository = new PaidRepository();
        logger.info("log from paid service id : {} " ,id);
        return paidRepository.listPaid(id);
    }
}
