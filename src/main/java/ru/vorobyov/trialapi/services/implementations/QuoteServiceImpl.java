package ru.vorobyov.trialapi.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vorobyov.trialapi.entities.Quote;
import ru.vorobyov.trialapi.entities.User;
import ru.vorobyov.trialapi.entities.Vote;
import ru.vorobyov.trialapi.repository.QuoteRepository;
import ru.vorobyov.trialapi.services.interfaces.QuoteService;
import ru.vorobyov.trialapi.services.interfaces.VoteService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service("quoteService")
public class QuoteServiceImpl implements QuoteService {
    private final VoteService voteService;
    private final QuoteRepository quoteRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository, VoteService voteService) {
        this.quoteRepository = quoteRepository;
        this.voteService = voteService;
    }
    @Override
    public List<Quote> getQuoteList() {
        return quoteRepository.findAll();
    }

    @Override
    public List<Quote> getTopQuotes(boolean isLike) {
        return quoteRepository.findTopByVoteListIsLike(isLike, Pageable.ofSize(10));
    }

    @Override
    public Optional<Quote> getRandomQuote() {
        long count = quoteRepository.count();
        return quoteRepository.findById(ThreadLocalRandom.current().nextLong(count));
    }

    @Override
    public Optional<Quote> getQuoteById(long id) {
        return quoteRepository.findById(id);
    }

    @Override
    public long createQuote(Quote quote) {
        return quoteRepository.save(quote).getId();
    }

    @Override
    public long updateQuote(long id, String content) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quote not found"));
        quote.setContent(content);
        return quoteRepository.save(quote).getId();
    }

    @Override
    public long vote(long id, User user, boolean isLike) {
        return doQuoteVote(id, isLike, user);
    }

    private long doQuoteVote(long id, boolean isLike, User user){
        Quote quote = quoteRepository.findByIdWithUser(id)
                .orElseThrow(() -> new EntityNotFoundException("Quote not found"));

        return voteService.createVote(new Vote(isLike, user, quote))
                .getQuote().getId();
    }

    @Override
    public void deleteQuote(long id) {
        quoteRepository.deleteById(id);
    }


}
