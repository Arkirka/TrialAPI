package ru.vorobyov.trialapi.services.implementations;

import org.springframework.stereotype.Service;
import ru.vorobyov.trialapi.entities.Vote;
import ru.vorobyov.trialapi.repository.VoteRepository;
import ru.vorobyov.trialapi.services.interfaces.VoteService;

@Service("voteService")
public class VoteServiceImpl implements VoteService {
    VoteRepository voteRepository;
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }
    @Override
    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

}
