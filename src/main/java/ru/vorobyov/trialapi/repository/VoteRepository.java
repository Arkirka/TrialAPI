package ru.vorobyov.trialapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vorobyov.trialapi.entities.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
