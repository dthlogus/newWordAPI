package Darthlogus.EnglishWord.service;

import Darthlogus.EnglishWord.model.Words;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Scanner;

@Service
public class WordsFileToDB {

    @Autowired
    private WordsService wordsService;

    public void createWords(MultipartFile file) throws Exception {
        try {
            InputStream is = file.getInputStream();
            Scanner scan = new Scanner(is);
            scan.useDelimiter(";");

            while (scan.hasNext()) {
                Words word = new Words();
                word.setWord(scan.next());
                word.setUsed(false);
                wordsService.insert(word);
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao importar o TXT para o BD");
        }
    }

}
