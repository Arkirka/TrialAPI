package ru.vorobyov.trialapi.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vorobyov.trialapi.entities.Quote;
import ru.vorobyov.trialapi.entities.User;
import ru.vorobyov.trialapi.services.interfaces.QuoteService;
import ru.vorobyov.trialapi.services.interfaces.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ApiPaths.QUOTES_URL})
public class QuoteController {

    private final UserService userService;
    private final QuoteService quoteService;

    public QuoteController(UserService userService, QuoteService quoteService) {
        this.userService = userService;
        this.quoteService = quoteService;
    }

    @GetMapping
    public ResponseEntity<List<Quote>> getAll() {
        List<Quote> quotes = quoteService.getQuoteList();
        return ResponseEntity.ok(quotes);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Quote>> getTopQuotes() {
        return getMostQuoteList(true);
    }

    @GetMapping("/worst")
    public ResponseEntity<List<Quote>> getWorstQuoteList() {
        return getMostQuoteList(false);
    }

    private ResponseEntity<List<Quote>> getMostQuoteList(boolean isTop) {
        List<Quote> topQuotes = quoteService.getTopQuotes(isTop);
        return ResponseEntity.ok(topQuotes);
    }

    @GetMapping("/random")
    public ResponseEntity<Quote> getRandomQuote() {
        Optional<Quote> randomQuote = quoteService.getRandomQuote();
        return randomQuote.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getById(@PathVariable long id) {
        Optional<Quote> quote = quoteService.getQuoteById(id);
        return quote.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Quote quote) {
        long id = quoteService.createQuote(quote);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody String content) {
        if (content == null || content.isBlank())
            return ResponseEntity.badRequest().body("Content is null or empty");
        long updatedQuoteId = quoteService.updateQuote(id, content);
        if (updatedQuoteId == 0)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/upvote")
    public ResponseEntity<Long> upvote(@PathVariable long id, @RequestBody User user) {
        return vote(id, user, true);
    }

    @PutMapping("/{id}/downvote")
    public ResponseEntity<Long> downvote(@PathVariable long id, @RequestBody User user) {
        return vote(id, user, false);
    }

    private ResponseEntity<Long> vote(long id, User user, boolean isUpvote) {
        try {
            if (user == null || !userService.isExist(user.getId()))
                return ResponseEntity.notFound().build();
            long voteCount = quoteService.vote(id, user, isUpvote);
            return ResponseEntity.ok().body(voteCount);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        quoteService.deleteQuote(id);
        return ResponseEntity.noContent().build();
    }
}
