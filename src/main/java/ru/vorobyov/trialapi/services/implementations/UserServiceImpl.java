package ru.vorobyov.trialapi.services.implementations;

import org.springframework.stereotype.Service;
import ru.vorobyov.trialapi.entities.User;
import ru.vorobyov.trialapi.repository.UserRepository;
import ru.vorobyov.trialapi.services.interfaces.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public long createUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public boolean isExist(long id) {
        return userRepository.existsById(id);
    }
}
