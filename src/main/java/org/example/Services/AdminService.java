package org.example.Services;

import org.example.entity.Daneshjo;
import org.example.repository.AdminRepository;

public class AdminService {
    public static boolean login(Daneshjo daneshjo) {
        if (AdminRepository.login(daneshjo)) {
            System.out.println("Admin Logged in Successfully");
            return true;
        }
        return false;
    }
}
