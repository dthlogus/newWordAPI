package Darthlogus.EnglishWord.Controler;

import Darthlogus.EnglishWord.model.Words;
import Darthlogus.EnglishWord.service.WordsService;
import Darthlogus.EnglishWord.service.WordsFileToDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

@RestController
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @Autowired
    private WordsFileToDB wordsFileToDB;

    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public List<Words> GetAll() throws SQLException {
        return wordsService.getWords();
    }

    @RequestMapping(value = "/wordsToStudy", method = RequestMethod.GET)
    public List<Words> GetTenWords() throws SQLException {
        return wordsService.getRandomWords();
    }

    @RequestMapping(value = "words/{id}", method = RequestMethod.PUT)
    public void updateWord(@PathVariable(value = "id") Long id) throws SQLException {
        wordsService.updateWord(id);
    }

    @RequestMapping(value = "words/used/{id}", method = RequestMethod.PUT)
    public void usedWord(@PathVariable(value = "id")Long id) throws SQLException{
        wordsService.usedWord(id);
    }

    @RequestMapping(value = "file/txt", method = RequestMethod.POST)
    public void uploadFile(MultipartFile file) throws Exception {
        wordsFileToDB.createWords(file);
    }

}
