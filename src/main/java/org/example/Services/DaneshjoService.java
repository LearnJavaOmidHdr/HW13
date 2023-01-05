package org.example.Services;

import org.example.entity.Daneshjo;
import org.example.panels.Space;
import org.example.repository.DaneshjoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaneshjoService extends ServiceImpl<DaneshjoRepository, Daneshjo, Long> {

    public static final Logger logger = LoggerFactory.getLogger(DaneshjoService.class);
    public DaneshjoService(DaneshjoRepository daneshjoRepository) {
        super(daneshjoRepository);
    }

    public static long login(Daneshjo daneshjo) {
        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
        final long login = daneshjoRepository.login(daneshjo);
        if (daneshjoRepository.login(daneshjo)>= 1) {
            Space.space();
            System.out.println("User Login Successfully ");
            logger.info("user {} loged in sucessfully",daneshjo);
            return daneshjoRepository.login(daneshjo);
        }
        logger.info("wrong User name or Password ");
        return 0;
    }

    public String getStatus(Long login) {
        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
        return daneshjoRepository.getStatus(login);
    }
}
