package Darthlogus.EnglishWord.repository;

import Darthlogus.EnglishWord.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsRepository extends JpaRepository<Words, Long>{

    @Query(value = "SELECT * FROM words WHERE used = false ORDER BY RAMDOM() LIMIT 10", nativeQuery = true)
    List<Words> findTenWords();
}
