package org.example.Services;

import org.example.entity.Daneshjo;
import org.example.panels.Space;
import org.example.repository.DaneshjoRepository;

public class DaneshjoService extends ServiceImpl<DaneshjoRepository, Daneshjo, Long> {

    public DaneshjoService(DaneshjoRepository daneshjoRepository) {
        super(daneshjoRepository);
    }

    public static long login(Daneshjo daneshjo) {
        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
        final long login = daneshjoRepository.login(daneshjo);
        if (daneshjoRepository.login(daneshjo)>= 1) {
            Space.space();
            System.out.println("User Login Successfully ");
            return daneshjoRepository.login(daneshjo);
        }
        System.out.println("wrong User name or Password ");
        return 0;
    }

    public boolean getStatus(Long login) {
        DaneshjoRepository daneshjoRepository = new DaneshjoRepository();
        //todo
//        return daneshjoRepository.getStatus(Long login);
        return false;
    }
}
