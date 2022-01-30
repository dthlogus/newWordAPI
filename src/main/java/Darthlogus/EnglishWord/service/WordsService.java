package Darthlogus.EnglishWord.service;

import Darthlogus.EnglishWord.model.Words;
import Darthlogus.EnglishWord.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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

    public List<Words> insertAll(List<Words> words) throws SQLException {
        try {
            return wordsRepository.saveAll(words);
        }catch (Exception erro){
            throw new SQLException("Erro ao inserir os dados");
        }
    }

    public List<Words> getWords() throws SQLException {
        try {
            return wordsRepository.findAll();
        }catch (Exception erro){
            throw new SQLException("Erro pegar todos os dados");
        }
    }

    public Words getWord(Long id) throws SQLException {
        try {
            return wordsRepository.findById(id).get();
        }catch (Exception erro){
            throw new SQLException("Erro ao pegar os dados do ID: "+id);
        }
    }

    public void updateWord(Words word) throws SQLException {
        try {
            wordsRepository.save(word);
        }catch (Exception erro){
            throw new SQLException("Erro ao atualizar os dados do ID: "+word.getId());
        }
    }

    public void deleteWord(Long id) throws SQLException {
        try {
            wordsRepository.deleteById(id);
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
