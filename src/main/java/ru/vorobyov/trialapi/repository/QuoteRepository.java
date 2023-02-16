package ru.vorobyov.trialapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vorobyov.trialapi.entities.Quote;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    @Query("select q from Quote q inner join fetch q.user where q.id = ?1")
    Optional<Quote> findByIdWithUser(long id);

    @Query("""
            SELECT q
            FROM Quote q
            INNER JOIN q.voteList v
            WHERE v.isLike = :isLike
            GROUP BY q.id
            ORDER BY COUNT(v.id) DESC
            """)
    List<Quote> findTopByVoteListIsLike(@Param("isLike") boolean isLike, Pageable pageable);

    void deleteById(long id);
}
