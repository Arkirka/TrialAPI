package ru.vorobyov.trialapi.services.interfaces;

import ru.vorobyov.trialapi.entities.User;

public interface UserService {
    long createUser(User user);

    boolean isExist(long id);
}
