package org.example.repository;

import org.example.entity.Daneshjo;
import org.example.exception.UserNotFound;

public interface IdaneshjoiRepository {
    long login(Daneshjo daneshjo) throws UserNotFound;
}
