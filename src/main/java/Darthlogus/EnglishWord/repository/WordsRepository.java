package Darthlogus.EnglishWord.repository;

import Darthlogus.EnglishWord.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<Words, Long>{
}
