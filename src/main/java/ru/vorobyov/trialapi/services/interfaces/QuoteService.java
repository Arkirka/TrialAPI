package ru.vorobyov.trialapi.services.interfaces;

import ru.vorobyov.trialapi.entities.Quote;
import ru.vorobyov.trialapi.entities.User;

import java.util.List;
import java.util.Optional;

public interface QuoteService {
    List<Quote> getQuoteList();
    Optional<Quote> getRandomQuote();
    Optional<Quote> getQuoteById(long id);
    long createQuote(Quote quote);
    long updateQuote(long id, String content);
    long vote(long id, User user, boolean isLike);
    void deleteQuote(long id);

    List<Quote> getTopQuotes(boolean isLike);
}
