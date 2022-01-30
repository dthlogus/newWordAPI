package Darthlogus.EnglishWord.service;

import Darthlogus.EnglishWord.model.Words;
import Darthlogus.EnglishWord.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class WordsService {

    @Autowired
    private WordsRepository wordsRepository;

    public Words insert(Words word) throws SQLException {
        try {
            return wordsRepository.save(word);
        }catch (Exception erro){
            throw new SQLException("Erro ao inserir o dado" + word);
        }
    }

    public List<Words> getWords() throws SQLException {
        try {
            return wordsRepository.findAll();
        }catch (Exception erro){
            throw new SQLException("Erro pegar todos os dados");
        }
    }

    public void updateWord(Long id) throws SQLException {
        Words word = wordsRepository.findById(id).get();
        try {
            wordsRepository.save(word);
        }catch (Exception erro){
            throw new SQLException("Erro ao atualizar os dados do ID: "+word.getId());
        }
    }

    public void usedWord(Long id) throws SQLException {
        Words word = wordsRepository.findById(id).get();
        try {
            word.setUsed(true);
            wordsRepository.save(word);
        }catch (Exception erro){
            throw new SQLException("Erro ao excluir a palavra do ID: "+id);
        }
    }

    public List<Words> getRandomWords() throws SQLException {
        try{
            return wordsRepository.findTenWords();
        }catch (Exception erro){
            throw new SQLException("Erro ao trazer palavras aleatórias");
        }
    }
}
