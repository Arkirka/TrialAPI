package ru.vorobyov.trialapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vorobyov.trialapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(String email);
}
